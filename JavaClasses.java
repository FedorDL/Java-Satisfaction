package com.Fedor;

public class JavaClasses {
    public static void main(String[] args){
        Person person1 = new Person();
        person1.setName("Vano");
        person1.age = 99;
        person1.speak();
        Person person2 = new Person();
        person2.name = "Petr";
        person2.age = 88;
        int year1 = person1.calculsteYears();
        int year2 = person2.calculsteYears();
        System.out.println("First retirement =" + year1 + " Second retirement = " + year2);
    }
}
 class Person{
    String name;
    int age;

    void setName(String username){
    name = username;
    }

    int calculsteYears(){
        int years = 65 - age;
        return years;
    }

    void speak(){
        for(int i = 0; i<3; ++i){
        System.out.println("My name is " + name + "," + "My age is " + age);}
    }
    void sayHello(){
        System.out.println("Privet");
    }
 }