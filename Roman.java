package com.Fedor;


import java.util.HashMap;

public class Roman {

    public static void main(String[] args) {
        Arabic1 arab = new Arabic1();
        System.out.println(arab.arabicToRoman(38));
    }
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

class Arabic1 {

    String arabicToRoman (int a) {
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
