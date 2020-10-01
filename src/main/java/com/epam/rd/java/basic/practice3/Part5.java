package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part5 {

    public static void main(String[] args) {
        decimal2Roman(55);
        roman2Decimal("X");
    }

    public static int roman2Decimal(String roman) {
        Pattern pRoman = Pattern.compile("^(M{0,3})(D?C{0,3}|C)(L?X{0,3}|X[LC])(V?I{0,3}|I[VX])$");
        Matcher mRoman = pRoman.matcher(roman);
        int resultNumber = 0;
        int group3;
        int group4 = 0;
        if (mRoman.find()) {
            int group2 = return1RomanToInt(mRoman.group(2));
            switch (mRoman.group(3).length()) {
                case 1:
                    group3 = return1RomanToInt(mRoman.group(3));
                    break;
                case 2:
                    group3 = return2RomanToInt(mRoman.group(3));
                    break;
                case 3:
                    group3 = returnSum(mRoman.group(3));
                    break;
                case 4:
                    group3 = returnSum(mRoman.group(3));
                    break;
                default:
                    group3 = 0;
            }
            if (mRoman.group(4).length() == 1) {
                group4 = return1RomanToInt(mRoman.group(4));
            } else if (mRoman.group(4).length() == 2) {
                group4 = return2RomanToInt(mRoman.group(4));
            } else if (mRoman.group(4).length() > 2) {
                group4 = returnSum(mRoman.group(4));
            }
            resultNumber = group2 + group3 + group4;
        }
        return resultNumber;
    }

    public static int return2RomanToInt(String roman){
        if (roman.length() != 2) {
            return 0;
        }
        String firstNumber = roman.substring(0,1);
        String secondNumber = roman.substring(1);
        int number1;
        int number2;
        int resultNumber= 0;

       number1 = return1RomanToInt(firstNumber);
       number2 = return1RomanToInt(secondNumber);
        if (number1 < number2) {
            resultNumber = number2 - number1;
        } else resultNumber = number1 + number2;
       return resultNumber;
    }

    public static int return1RomanToInt(String romanString){
        if (romanString.length() != 1) {
            return 0;
        }
        int number;
        switch (romanString){
            case "I": number = 1;
            break;
            case "V": number = 5;
                break;
            case "X": number = 10;
                break;
            case "L": number = 50;break;
            case "C": number = 100;
                break;
            default: number = 0;
                break;
        }
        return number;
    }

    public static int returnSum(String romanString) {
        int resultNumber = 0;
       for (int i = 0; i < romanString.length(); i++) {
            resultNumber = resultNumber + return1RomanToInt(romanString.substring(i, i + 1));
       }
       return resultNumber;
    }

    public static String decimal2Roman(int dec) {
       if(dec <= 0 || dec > 100){
            return null;
        }
        StringBuilder RomanNumber = new StringBuilder();

        int c1Num = dec / 100;
        RomanNumber.append(findC(c1Num));
        int c2Num = dec % 100;

        int l1Num = c2Num / 50;
        RomanNumber.append(findL(l1Num));
        int l2Num = c2Num % 50;

        int x1Num = l2Num / 10;
        RomanNumber.append(findX(x1Num));

        int x2Num = l2Num % 10;

        RomanNumber.append(basic(x2Num));
        return RomanNumber.toString();
    }

    private static String findC(int inNum) {
        StringBuilder aNum = new StringBuilder("");

        if (inNum == 4) return "CD";

        if ((inNum != 0) && (inNum < 4)) {

            int i = 0;
            while (i < inNum) {
                aNum.append("C");
                i++;
            }
            return aNum.toString();
        }
        else return "";
    }

    private static String findX(int inNum) {
        if (inNum == 4) return "XL";
        else if ((inNum != 0) && (inNum < 4)) {
            StringBuilder aNum = new StringBuilder("");
            int i = 0;
            while (i < inNum) {
                aNum.append("X");
                i++;
            }
            return aNum.toString();
        }
        else return "";
    }

    private static String findL(int ostatok) {
        if (ostatok == 0) return "";
        if (ostatok == 4) return "XC";
        return "L";
    }

    private static String basic(int in) {
       String number;
        switch (in) {
            case 0:
                number = "";
                break;
            case 1:
                number = "I";
                break;
            case 2:
                number = "II";
                break;
            case 3:
                number = "III";
                break;
            case 4:
                number = "IV";
                break;
            case 5:
                number = "V";
                break;
            case 6:
                number = "VI";
                break;
            case 7:
                number = "VII";
                break;
            case 8:
                number = "VIII";
                break;
            case 9:
                number = "IX";
                break;
            default:
                number = "";
                break;
        }
        return number;

    }
}