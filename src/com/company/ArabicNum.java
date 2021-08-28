package com.company;

public class ArabicNum {
    public static void calculate(String str) {

        try {
            String first_num = str.split(" ")[0];
            String second_num = str.split(" ")[2];
            String operation = str.split(" ")[1];

            int first = Integer.parseInt(first_num);
            int second = Integer.parseInt(second_num);

            if (first < 0 || first > 10 || second < 0 || second > 10) {
                try {
                    throw new Exception("Значения должны быть от 1(I) до 10(X)");
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                    System.exit(0);
                }
            }

            switch (operation) {
                case ("+") -> {
                    Operations addition = Integer::sum;
                    System.out.println(addition.calculate(first, second));
                }
                case ("-") -> {
                    Operations subtraction = (a, b) -> a - b;
                    System.out.println(subtraction.calculate(first, second));
                }
                case ("*") -> {
                    Operations multiplication = (a, b) -> a * b;
                    System.out.println(multiplication.calculate(first, second));
                }
                case ("/") -> {
                    Operations division = (a, b) -> a / b;
                    System.out.println(division.calculate(first, second));
                }
            }
        } catch (Exception e) {
            System.out.println("Что-то пошло не так.");
            System.exit(0);
        }
    }
}
