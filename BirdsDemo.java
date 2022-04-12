package com.java.practice;

class Bird{
  private String birdColour;
  private int birdLifeSpan;
  public Bird(String birdColour){
      this.birdColour=birdColour;
      this.birdLifeSpan=10;
  }
  public String getColour(){
      return this.birdColour;
  }
  public int getLifeSpan(String type){
      if(type.equals("years")){
          return this.birdLifeSpan;  //life span in years
      }
      else {
          return this.birdLifeSpan*12;  //life span in months
      }
      // Need to modify if requested for days which is Violating OCP
  }
  public void walk(){
      System.out.println("Bird is Walking!!");
  }
  public void fly(){
    System.out.println("Bird is Flying^^");
  }
}

class Sparrow extends Bird{
    private Bird ob;
    public Sparrow(String birdColour) {
        super(birdColour);
        this.ob=new Bird(birdColour);
    }

    @Override
    public void walk(){
        System.out.println("Sparrow Colour is: "+this.ob.getColour());  //Extra or other functionality violating SRP
        System.out.println("Sparrow is Walking!!"); //Main functionality
    }
    @Override
    public void fly(){
        System.out.println("Sparrow is Flying^^");
    }
}

class Ostritch extends Bird{
    private Bird ob;
    public Ostritch(String birdColour) {
        super(birdColour);
        this.ob=new Bird(birdColour);
    }

    @Override
    public void walk(){
        System.out.println("Ostritch is Walking!!");
    }
    /*@Override
    public void fly(){
        System.out.println("Ostritch is Flying^^");
    }*/  //Violates LSP principle

    public void printLifeSpan(){
       System.out.println(this.ob.getLifeSpan("years")+" Years"); //Needs to be changed for months/days, so violated OCP
       //Lower Level Class interacting directly with Higher Level Class violating DIP
        //Also, printLifeSpan method depends on getLifeSpan method of Bird Class(Base Class) which violated ISP
    }
}

public class BirdsDemo {
    public static void main(String args[]){
        Sparrow sp = new Sparrow("Brown");
        sp.fly();
        sp.walk();
        Ostritch os = new Ostritch("White");
        os.walk();
        os.printLifeSpan();
    }
}
