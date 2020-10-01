package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {

    public static void main(String[] args) {
        String input = Util.getInput("part6.txt");
        convert(input);
    }

    public static String convert(String input) {
        StringBuilder repetedWords = new StringBuilder();
        Pattern repetedWo = Pattern.compile("(\\b[\\p{L}]+\\b)(?=[\\s\\S]*?\\b(\\1)\\b)");
        Matcher mRepeted = repetedWo.matcher(input);
        boolean isFirst = true;
        while (mRepeted.find()) {
            if (isFirst) {
                isFirst = false;
                repetedWords.append("(\\b)(");
            } else {
                repetedWords.append("|");
            }
            repetedWords.append(mRepeted.group());
        }
        repetedWords.append(")(\\b)");

        return input.replaceAll(repetedWords.toString(),"_$0");
    }
}
