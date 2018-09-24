package sample;
import java.io.*;


public class Characters implements Serializable {
    //Declare Variables
    String charName;
    private int wounds, strain, soak;
    private double credits;
   //private boolean pC;

    //Default Constructor
    public Characters() {
        charName = "New Character";
        wounds = 10;
        strain = 10;
        soak = 1;
        credits = 0;
    }

    //Constructor with arguments
    public Characters(String name, int wounds, int strain, int soak, double credits) {
        charName = name;
        wounds = wounds;
        strain = strain;
        soak = soak;
        credits = credits;
    }

    //CharName Methods
    public void setCharName(String charName) {
        this.charName = charName;
    }
    public String getCharName() {
        return charName;
    }

    //Wounds
    public void setWounds(int wounds) {
        this.wounds = wounds;
    }
    public int getWounds() {
        return wounds;
    }

    //Strain
    public void setStrain(int strain) {
        this.strain = strain;
    }
    public int getStrain() {
        return strain;
    }

    //Soak
    public void setSoak(int soak) {
        this.soak = soak;
    }
    public int getSoak() {
        return soak;
    }

    //Credits
    public void setCredits(double credits) {
        this.credits = credits;
    }
    public double getCredits() {
        return credits;
    }
    
    @Override
    public String toString() {
        return ("Name: " + this.charName + 
                "\nWound Threshold: " + this.wounds +
                "\nStrain Threshold: " + this.strain +
                "\nSoak: " + this.soak +
                "\nCredits: " + this.credits);
    }
}
