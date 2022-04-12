package com.java.practice;

import java.io.Flushable;

interface GenericBird{
    public void walk();
    public int getLifeSpanInYears();
    public int getLifeSpanInMonths();
}
interface FlyingBird{
    public void fly();
}

class BirdSolid implements GenericBird,FlyingBird{
    private String birdColour;
    private int birdLifeSpan;
    public BirdSolid(String birdColour,int birdLifeSpan){
        this.birdColour=birdColour;
        this.birdLifeSpan=birdLifeSpan;
    }
    public String getColour(){
        return this.birdColour;
    }
    public int getLifeSpanInYears() {
        return this.birdLifeSpan;  //life span in years
    }
    public int getLifeSpanInMonths() {
        return this.birdLifeSpan*12;  //life span in Months
    }
    public void walk(){
        System.out.println("Bird is Walking!!");
    }
    public void fly(){
        System.out.println("Bird is Flying^^");
    }
}

class SparrowSolid implements GenericBird, FlyingBird {
    private GenericBird ob;  //using interface reference
    public SparrowSolid(String birdColour,int birdLifeSpan) {
        this.ob=new BirdSolid(birdColour,birdLifeSpan);
    }
    public void walk(){
        System.out.println("Sparrow is Walking!!");
    }

    @Override
    public int getLifeSpanInYears() {
        System.out.print("Sparrow Life Span (in years): ");
        return this.ob.getLifeSpanInYears();
    }

    @Override
    public int getLifeSpanInMonths() {
        System.out.print("Sparrow Life Span (in months): ");
        return this.ob.getLifeSpanInMonths();
    }

    public void fly(){
        System.out.println("Sparrow is Flying^^");
    }
}

class OstritchSolid implements GenericBird{
    private GenericBird ob;  //using interface reference
    public OstritchSolid(String birdColour,int birdLifeSpan) {
        this.ob=new BirdSolid(birdColour,birdLifeSpan); //interface reference refers to the object of the BirdSolid class.
    }
    public void walk(){
        System.out.println("Ostritch is Walking!!");
    }

    @Override
    public int getLifeSpanInYears() {
        System.out.print("Ostritch Life Span (in years): ");
        return this.ob.getLifeSpanInYears();
    }

    @Override
    public int getLifeSpanInMonths() {
        System.out.print("Ostritch Life Span (in months): ");
        return this.ob.getLifeSpanInMonths();
    }

}

public class SolidBirdsDemo {
    public static void main(String args[]){
        SparrowSolid sp = new SparrowSolid("Brown",14);
        sp.fly();
        sp.walk();
        System.out.println(sp.getLifeSpanInYears());
        OstritchSolid os = new OstritchSolid("White",8);
        os.walk();
        System.out.println(os.getLifeSpanInMonths());
    }
}
