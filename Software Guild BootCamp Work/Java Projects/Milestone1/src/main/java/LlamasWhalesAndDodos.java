/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 19bgehrman
 */
public class LlamasWhalesAndDodos {

    public static void main(String[] args) {
        int llamas = 20;
        int whales = 15;
        int dodos = 0;

        if (dodos > 0) {
            System.out.println("Egads, I thought dodos were extinct!");
        }

        if (dodos < 0) {
            System.out.println("Hold on, how can we have NEGATIVE dodos??!");
        }

        if (llamas > whales) {
            System.out.println("Whales may be bigger, but llamas are better, ha!");
        }

        if (llamas <= whales) {
            System.out.println("Aw man, brawn over brains I guess. Whales beat llamas.");
        }

        System.out.println("There's been a huge increase in the dodo population "
                + " via cloning!");
        dodos += 100;

        if ((whales + llamas) < dodos) {
            System.out.println("I never thought I'd see the day when dodos ruled the earth.");
        }

        if (llamas > whales && llamas > dodos) {
            System.out.println("I don't know how, but the llamas have come out ahead!"
                    + " Sneaky!");
        }
    }
}
