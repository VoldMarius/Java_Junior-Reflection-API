package org.example;

public class Dog extends Animal {

    double weight;
    String breed;

    public Dog(String name, double age,   double weight, String breed) {
        super(name, age);

        this.weight = weight;
        this.breed = breed;
    }

    public void Sound(){
        System.out.println("Гау!! Гау !!!");
    }

}
