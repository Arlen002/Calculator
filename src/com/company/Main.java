package com.company;

import com.company.calculate.Calculate;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            input = input.replaceAll("\\s", "");
            if (input.equals("")) {
                try {
                    throw new RuntimeException("Туура эмес маалымат бнрдиниз?");
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                    return;
                }
            }

            //---------------------- declaration & initialization -------------

            String operator = Calculate.assignOperator(input);
            int indexOfOperator = Calculate.findIndexOfOperator(input);

            //-------------------- checking for valid operator -------------------

            if (!operator.matches(".*[-*/+].*")) {
                try {
                    throw new RuntimeException("+ - * / эле белгилери менен иштоого болот");
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                    return;
                }
            }

            //----------------- getting values of first and second operand --------

            String firstNumber = input.substring(0, indexOfOperator);
            String secondNumber = input.substring(indexOfOperator + 1);

            //---------------- calculation with roman numerals ---------------------

            if (firstNumber.matches(".*[IVXLCDM].*") && secondNumber.matches(".*[IVXLCDM].*")) {
                Calculate.calculateRoman(firstNumber, secondNumber, operator);

                //------------------- calculation with arabic numerals --------------------

            } else if (firstNumber.matches("[0-9]+") && secondNumber.matches("[0-9]+")) {
                Calculate.calculateArabic(firstNumber, secondNumber, operator);

                //------------------- checking if wrong type entered ---------------------

            } else {
                try {
                    throw new RuntimeException("Туура эмес маалымат!. Калькулятор бир эле учурда же араб же рим " +
                            "цифралары жана так сандар менен гана иштей алат .");
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

}



