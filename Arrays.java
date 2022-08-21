package com.Fedor;

public class Arrays {
    public static void main(String[] args) {
//        int number = 10;
//        int[] numbers = new int[5];
//        for(int i = 0; i<numbers.length; i++){
//            numbers[i] = i*10;}
//        for(int i = 0; i<numbers.length; i++){
//            System.out.println(numbers[i]);}
        String[] strings = new String[3];
        strings[0] = "hello";
        strings[1] = "salam";
        strings[2] = "popolam";
        for(String string: strings){
            System.out.println(string);
        }
        int[] numbers1 = {1,2,3};
        int sum = 0;
        for(int x:numbers1){
            sum = sum + x;
        }
        System.out.println(sum);
        int value = 0;

    }
}
