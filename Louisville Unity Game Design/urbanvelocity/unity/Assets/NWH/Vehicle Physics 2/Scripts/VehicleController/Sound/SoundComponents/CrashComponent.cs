using System;
using UnityEngine;
using UnityEngine.Audio;
using Random = UnityEngine.Random;

namespace NWH.VehiclePhysics2.Sound.SoundComponents
{
    /// <summary>
    ///     Sound of vehicle crashing into an object.
    ///     Supports multiple audio clips of which one will be chosen at random each time this effect is played.
    /// </summary>
    [Serializable]
    public partial class CrashComponent : SoundComponent
    {
        public override bool IsOneShot => true;

        /// <summary>
        ///     Different random pitch in range [basePitch + (1 +- pitchRandomness)] is set each time a collision happens.
        /// </summary>
        [Range(0, 0.5f)]
        [Tooltip(
            "Different random pitch in range [basePitch + (1 +- pitchRandomness)] is set each time a collision happens.")]
        public float pitchRandomness = 0.4f;

        /// <summary>
        ///     Higher values result in collisions getting louder for the given collision velocity magnitude.
        /// </summary>
        [Range(0, 5)]
        [Tooltip("    Higher values result in collisions getting louder for the given collision velocity magnitude.")]
        public float velocityMagnitudeEffect = 1f;

        private Collision collisionData;
        private bool      collisionFlag;


        public override void InitializeSoundComponent(AudioMixerGroup mixerGroup, GameObject sourceContainer)
        {   
            base.InitializeSoundComponent(mixerGroup, sourceContainer);

            vc.damageHandler.OnCollision.AddListener(RaiseCollisionFlag);
        }


        public override void Update()
        {
            if (!Active)
            {
                collisionFlag = false;
                return;
            }

            if (collisionFlag)
            {
                PlayCollisionSound();
                collisionFlag = false;
            }
        }


        public override void FixedUpdate()
        {
        }


        public override void SetDefaults(VehicleController vc)
        {
            base.SetDefaults(vc);

            baseVolume = 0.4f;

            if (Clip == null)
            {
                AddDefaultClip("Crash");                
            }
        }


        public void PlayCollisionSound()
        {
            if (!IsEnabled || !initialized)
            {
                return;
            }

            if (Clips.Count == 0 || collisionData == null || collisionData.contacts.Length == 0)
            {
                return;
            }

            // Do not play if rim collider was hit
            ContactPoint[] contactPoints = collisionData.contacts;
            int            n             = contactPoints.Length;
            for (int i = 0; i < n; i++)
            {
                if (contactPoints[i].thisCollider.name == "RimCollider")
                {
                    return;
                }
            }

            float newVolume =
                Mathf.Clamp01(collisionData.relativeVelocity.magnitude * 0.025f * velocityMagnitudeEffect) *
                baseVolume;
            float newPitch = Random.Range(1f - pitchRandomness, 1f + pitchRandomness);

            PlayOneShot(RandomClip, newVolume);
        }


        public void RaiseCollisionFlag(Collision collision)
        {
            collisionData = collision;
            collisionFlag = true;
        }
    }
}