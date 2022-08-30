package com.Fedor;


public class Test {
    public static void main(String[] args) {
    Human human1 = new Human();
    human1.setAge(15);
    human1.setName("Petr");
    human1.getInfo();
    }
}

class Human{
    private int age;
    private String name;

    public void setName(String name) {
        if(name.isEmpty()) {
            System.out.println("Vi vveli ne imya");
        }else {
            this.name = name;
        }
    }
    public String getName(){
        return name;
    }

    public void setAge(int age){
        if(age>0){
            this.age = age;
        }else {
            System.out.println("Vosrast otricatel");
        }
    }

    public int getAge(){
        return age;
    }

    public void getInfo(){
        System.out.println(name + " " + age);
    }
}