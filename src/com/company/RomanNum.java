package com.company;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class RomanNum {
    private static final Map<String, Integer> romannum = new HashMap<>();
    private static final TreeMap<Integer, String> arabicnum = new TreeMap<>();
    static {
        romannum.put("I", 1);
        romannum.put("II", 2);
        romannum.put("III", 3);
        romannum.put("IV", 4);
        romannum.put("V", 5);
        romannum.put("VI", 6);
        romannum.put("VII", 7);
        romannum.put("VIII", 8);
        romannum.put("IX", 9);
        romannum.put("X", 10);

        arabicnum.put(100, "C");
        arabicnum.put(90, "XC");
        arabicnum.put(50, "L");
        arabicnum.put(40, "XL");
        arabicnum.put(10, "X");
        arabicnum.put(9, "IX");
        arabicnum.put(5, "V");
        arabicnum.put(4, "IV");
        arabicnum.put(1, "I");
    }

    public static void calculate(String str) {
        String first = str.split(" ")[0];
        String second = str.split(" ")[2];
        String operation = str.split(" ")[1];


        if (!romannum.containsKey(first) || !romannum.containsKey(second)) {
            try {
                throw new ArithmeticException("Числа ниже 1 и выше 10 не принимаются!");
            } catch (Exception e) {
                System.err.println(e.getMessage());
                System.exit(1);
            }
        }

                switch (operation) {
                    case ("+") -> {
                        Operations addition = Integer::sum;
                        System.out.println(addition.calculate(romannum.get(first),romannum.get(second)));
                    }
                    case ("-") -> {
                        if (romannum.get(first) <= romannum.get(second)) {
                            try {
                            throw new Exception("Результат <= 1");
                        } catch (Exception e) {
                                System.err.println(e.getMessage());
                                System.exit(1);
                            }
                        }
                        Operations subtraction = (a, b) -> a - b;
                        System.out.println(subtraction.calculate(romannum.get(first),romannum.get(second)));
                    }
                    case ("*") -> {
                        Operations multiplication = (a, b) -> a * b;
                        System.out.println(multiplication.calculate(romannum.get(first),romannum.get(second)));
                    }
                    case ("/") -> {
                        Operations division = (a, b) -> a / b;
                        System.out.println(convert(division.calculate(romannum.get(first), romannum.get(second))));
                    }
                }


    }
    private static String convert(int num){
        int a = arabicnum.floorKey(num);
//        System.out.println("res is " + num);
//        System.out.println("floorkey is " + a);
        if (num == a){
            return arabicnum.get(num);
        }
        return arabicnum.get(a) + convert(num - a);
    }
}
