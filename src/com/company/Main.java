package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        if (str.matches("^\\d{1,2}[ ][\\+\\-\\*\\/][ ]\\d{1,2}$")) {
            ArabicNum.calculate(str);
        }
        else if (str.matches("^[IVX]{1,4}[ ][\\+\\-\\*\\/][ ][IVX]{1,4}$")) {
            RomanNum.calculate(str);
        }
        else {
            System.err.println("Формат строки не верный, попробуйте ещё раз.");
        }

    }
}
