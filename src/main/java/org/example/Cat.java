package org.example;

public class Cat extends Animal{

    double weight;
    String breed;

    public Cat(String name, double age, double weight, String breed) {
        super(name, age);
        this.weight = weight;
        this.breed = breed;
    }

    @Override
    public void Sound(){
        System.out.println("Мяу!! Мяу !!!");

}
}
