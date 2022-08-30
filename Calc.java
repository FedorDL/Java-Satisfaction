package com.Fedor;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Calc {
    public static void main(String[] args) throws IOException {
        System.out.println("Здравствуйте! Вы зашли в приложение Калькулятор." +
                "\nЗдесь вы можете произвести сложение,вычитание,умножение,деление арабских или римских чисел. " +
                "\nНеобходимо ввести данные в следующем формате 1 + 2,т.е. с пробелами." +
                "\nЗначение каждого операнда должно быть в диапазоне от 1 до 10 включительно,не более." +
                "\nПоняли? Тогда пользуйтесь! Удачи! ");
        System.out.print("\nВведите выражение: ");
        Main main = new Main();
        Scanner console = new Scanner(System.in);
        String data = console.nextLine();
        main.calc(data);
    }
}

class Nums {
    String[] numberArray = new String[] {"1","2","3","4","5","6","7","8","9","10"};
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

    String arabicToRoman (int a) throws IOException {
        if(a < 0){
            throw new IOException("В римской системе нет отрицательных чисел.");
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

class Main {
    public static String calc(String input) throws IOException {
        String[] dataArray = input.split(" ");
        if (dataArray.length != 3){
            throw new IOException("Вы ввели неправильное выражение. Введите в формате 10 + 2, 5 * 3 и тд.");
        }
        String[] symbols =new String[]{"+","-","*","/"};
        if(Arrays.asList(symbols).contains(dataArray[1])){
        }else {
            throw new IOException("Вы ввели неправильное выражение. Введите в формате 10 + 2, 5 * 3 и тд.");
        }
        int flag = 0;
        Roman1 trans = new Roman1();
        for(int i = 0; i < trans.numbers.length; i++){
            for(int j = 0; j < trans.numbers.length; j++){
                if(trans.numbers[i].equals(dataArray[0]) && trans.numbers[j].equals(dataArray[2])) {
                    dataArray[0] = Integer.toString(trans.romanToInt(dataArray[0]));
                    dataArray[2] = Integer.toString(trans.romanToInt(dataArray[2]));
                    flag = 1;
                }
            }
        }
        Nums first = new Nums();
        if(Arrays.asList(first.numberArray).contains(dataArray[0])
                && Arrays.asList(first.numberArray).contains(dataArray[2])){
            first.num1 = Integer.parseInt(dataArray[0]);
            first.num2 = Integer.parseInt(dataArray[2]);
        }else {
            throw new IOException("Вы ввели неправильное выражение. Введите в формате 10 + 2, 5 * 3 и тд.");
        }
        Arabic arabic = new Arabic();
        int lastResult = 0;
        switch (dataArray[1]) {
            case "+" -> lastResult = first.sum();
            case "-" -> lastResult = first.minus();
            case "*" -> lastResult = first.multiply();
            case "/" -> lastResult = first.divided();
            default -> System.out.println("Выражение не является математической операцией");
        }
        if(flag == 0){
            System.out.println("Результат: " + lastResult);
        }else{
            System.out.println("Результат: " + arabic.arabicToRoman(lastResult));
        }
        return Integer.toString(lastResult);
    }
}
