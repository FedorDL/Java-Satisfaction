package com.Fedor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {
        System.out.println("Здравствуйте! Вы зашли в приложение Калькулятор." +
                "\nЗдесь вы можете произвести сложение,вычитание,умножение,деление арабских или римских чисел. " +
                "\nНеобходимо ввести данные в следующем формате 1 + 2,т.е. с пробелами." +
                "\nЗначение каждого операнда должно быть в диапазоне от 1 до 10 включительно,не более." +
                "\nПоняли? Тогда пользуйтесь! Удачи! ");
        System.out.print("\nВведите выражение: ");
        Scanner console = new Scanner(System.in);
        String data = console.nextLine();
        String[] dataArray = data.split(" ");
        if (dataArray.length != 3){
            try {
                throw new IOException();
            }catch (IOException ioe){
                System.out.println("Вы ввели неправильное выражение. Введите в формате 10 + 2, 5 * 3 и тд.");
                System.exit(0);
            }
        }
        String symbol = "null";
        try {
            symbol = dataArray[1];
        } catch (ArrayIndexOutOfBoundsException arrIndex) {
            System.out.println("Вы ввели неправильное выражение. Введите в формате 10 + 2, 5 * 3 и тд.");
            System.exit(0);
        }
        int flag = 0;
        Roman1 trans = new Roman1();
        for(int i = 0; i < trans.numbers.length; i++){
            for(int j = 0; j < trans.numbers.length; j++){
           if(trans.numbers[i].equals(dataArray[0]) && trans.numbers[j].equals(dataArray[2])) {
               dataArray[0] = Integer.toString(trans.romanToInt(dataArray[0]));
               dataArray[2] = Integer.toString(trans.romanToInt(dataArray[2]));
               flag = 1;
               break;
                }
           }
        }
        Nums first = new Nums();
        int operand1 = 0;
        int operand2 = 0;
        try {
            operand1 = Integer.parseInt(dataArray[0]);
        }catch (NumberFormatException numbExc){
            System.out.println("Вы ввели не число. Введите в формате 10 + 2, 5 * 3 и тд.");
            System.exit(0);
        }
        try {
            operand2 = Integer.parseInt(dataArray[2]);
        }catch (NumberFormatException numbExc){
            System.out.println("Вы ввели не число. Введите в формате 10 + 2, 5 * 3 и тд.");
            System.exit(0);
        }catch (ArrayIndexOutOfBoundsException arrIndex){
            System.out.println("Вы ввели неправильное выражение. Введите в формате 10 + 2, 5 * 3 и тд.");
            System.exit(0);
        }
        if (operand1 <= 10 && operand2 <= 10 && operand1 > 0 && operand2 > 0) {
            first.num1 = Integer.parseInt(dataArray[0]);
            first.num2 = Integer.parseInt(dataArray[2]);
        } else {
            System.out.println("Вы ввели неправильное выражение. Читайте описание работы калькулятора.");
            System.exit(0);
        }
        Arabic arabic = new Arabic();
        int lastResult = 0;
        switch (symbol) {
            case "+":
                lastResult = first.sum();
                break;
            case "-":
                lastResult = first.minus();
                break;
            case "*":
                lastResult = first.multiply();
                break;
            case "/":
                lastResult = first.divided();
                break;
            default:
                System.out.println("Выражение не является математической операцией");
        }
        if(flag == 0){
            System.out.println("Результат: " + lastResult);
        }else{
            System.out.println("Результат: " + arabic.arabicToRoman(lastResult));
        }
    }
}

class Nums {
    int num1;
    int num2;

    int sum(){return num1 + num2;}

    int minus(){return num1 - num2;}

    int multiply(){ return num1 * num2;}

    int divided(){return num1 / num2;}
}

class Roman1{
    String[] numbers = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

    public int romanToInt (String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);

        int end = s.length() - 1;
        char[] arr = s.toCharArray();
        int arabian;
        int result = map.get(arr[end]);
        for(int i = end - 1;i >= 0; i--){
            arabian = map.get(arr[i]);

            if(arabian < map.get(arr[i + 1])){
                result -= arabian;
            }else{
                result += arabian;
            }
        }
        return result;
    }
}

class Arabic {

    String arabicToRoman (int a) {
        if(a < 0){
            System.out.println("В римской системе нет отрицательных чисел");
            System.exit(0);
        }
        String result = "";
        if (a - 100 == 0) {
            result = "C";
        }
        if (a - 90 >= 0) {
            result += "XC";
            a -= 90;
        } else if (a - 50 >= 0) {
            result += "L";
            a -= 50;
        } else if (a - 40 >= 0) {
            result += "XL";
            a -= 40;
        }
        while (a > 10 || a - 10 == 0) {
            result += "X";
            a -= 10;
        }
        if (a - 9 == 0) {
            result += "IX";
            a -= 9;
        }if (a - 5 >= 0){
            result += "V";
            a -= 5;
        }if (a - 4 == 0){
            result += "IV";
            a -= 4;
        }while (a - 1 >= 0) {
            result += "I";
            a -= 1;}
        return result;
    }
}