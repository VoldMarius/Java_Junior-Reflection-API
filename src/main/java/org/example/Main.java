package org.example;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        List<Animal> animals = new ArrayList<>();

        animals.add( new Dog("Zevs", 1.2,55.6,"CaneCorso"));
        animals.add(new Dog("Matilda", 2, 40.5,"German Shepherd"));
        animals.add(new Cat("Claid", 0.5,5.2,"Persian cat"));
        animals.add(new Cat("Bony", 1.0,3.2,"British Shorthair"));

        for (Animal animal:animals) {
            Class<?> clazz = animal.getClass();
            Field[] fields = clazz.getDeclaredFields();
            Method[] methods = clazz.getDeclaredMethods();
            System.out.println("Класс объекта: " + clazz.getName());
            System.out.println("Поля обекта:");
            for (Field field:fields) {
                System.out.println(field.getName() + ": " + field.get(animal));
            }
            System.out.println("Доступные методы: ");
            for (Method method: methods) {
                String methodName = method.getName();
                System.out.println(methodName);
                if (methodName.equals("makeSound")){
                    method.invoke(animal);
                }
            }
            System.out.println("-------------------");
            // Вызов метода "makeSound()":
            Method makeSoundMethod;
            try {
                makeSoundMethod = clazz.getDeclaredMethod("Sound");
                makeSoundMethod.invoke(animal);
                System.out.println();
            } catch (NoSuchMethodException e) {
                System.out.println("У этого животного такого метода нет\n");
            }
        }
    }
}