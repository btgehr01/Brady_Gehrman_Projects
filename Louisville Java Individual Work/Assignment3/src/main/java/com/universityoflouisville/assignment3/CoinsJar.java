/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.universityoflouisville.assignment3;

import java.text.NumberFormat;

/**
 *
 * @author Brady Gehrman
 */
public class CoinsJar {
    private int numOfQuarters;
    private int numOfDimes;
    private int numOfNickels;
    private int numOfPennies;

    public CoinsJar(){
        
    }
    //constructor taking in all arguments
    public CoinsJar(int numOfQuarters, int numOfDimes, int numOfNickels, int numOfPennies) {
        this.numOfQuarters = numOfQuarters;
        this.numOfDimes = numOfDimes;
        this.numOfNickels = numOfNickels;
        this.numOfPennies = numOfPennies;
    }

    public int getNumOfQuarters() {
        return numOfQuarters;
    }

    public int getNumOfDimes() {
        return numOfDimes;
    }

    public int getNumOfNickels() {
        return numOfNickels;
    }

    public int getNumOfPennies() {
        return numOfPennies;
    }

    public void setNumOfQuarters(int numOfQuarters) {
        this.numOfQuarters = numOfQuarters;
    }

    public void setNumOfDimes(int numOfDimes) {
        this.numOfDimes = numOfDimes;
    }

    public void setNumOfNickels(int numOfNickels) {
        this.numOfNickels = numOfNickels;
    }

    public void setNumOfPennies(int numOfPennies) {
        this.numOfPennies = numOfPennies;
    }
    
    public String getAmount(){
        double total;
        //sum up all coins values and add them together
        total = (numOfQuarters * 0.25) + (numOfDimes * 0.1) + (numOfNickels * 0.05) + (numOfPennies * .01);
        NumberFormat format = NumberFormat.getCurrencyInstance();
        //fomat and return the whole string amount
        String amount = format.format(total);
        return amount;
    }
    public String getValues(){
        NumberFormat format = NumberFormat.getCurrencyInstance();
        String value = "The values of each category of coins: \n";
        value += "Quarters Value: " + format.format(numOfQuarters * 0.25) + "\n";
        value += "Dimes Value: " + format.format(numOfDimes * 0.1) + "\n";
        value += "Nickels Value: " + format.format(numOfNickels * 0.05) + "\n";
        value += "Pennies Value: " + format.format(numOfPennies * 0.01) + "\n";
        //create a string that display the amount of money for each cointype in the coin jar
        return value;
    }
    
    
    public String toString(){
        //returns a string of each how many of each coins are in the coin jar for each cointype 
        String change = "The contents of the Coins Jar are as follows:\n";
        change += numOfQuarters + " Quarters, " + numOfDimes + " Dimes, " + numOfNickels + " Nickels, " + numOfPennies + " Pennies.";
        return change;
    }
}
