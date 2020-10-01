package com.epam.rd.java.basic.practice3;

public class Part3 {

    public static void main(String[] args) {
        String input = Util.getInput("part3.txt");
        convert(input);
       
    }

    public static String convert(String input) {
       String[] inputString = input.split("\\R");
        StringBuilder strb = new StringBuilder("");
        StringBuilder sbRes = new StringBuilder("");
        String result = "";

        for (String subString : inputString) {
            String[] element = subString.split("\\s*(\\s|,|!|'|-|\\.)\\s*");
            for (String word : element) {
                if (word.length() >= 3) {
                    if (word.substring(0, 1).matches("\\p{Lu}{1}")) {
                        strb.append(word.substring(0, 1).toLowerCase()).append(word.substring(1)).append(" ");
                    } else if (word.substring(0, 1).matches("\\p{Ll}{1}")) {
                    strb.append(word.substring(0, 1).toUpperCase()).append(word.substring(1)).append(" ");
                    }
                } else strb.append(word).append(" ");
            }
            sbRes = strb.delete(strb.length()-1,strb.length());
            sbRes.append("\n");
        }
            result = (sbRes.delete(sbRes.length()-1,sbRes.length())).toString();
            return result;
        
    }
}
