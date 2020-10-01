package com.epam.rd.java.basic.practice3;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {
    
    static final  String REGEXEMAIL = "(\\p{Ll}{1,})@(\\w+\\.)([a-z]{2,4})";
    static final  String REGEXLOGIN = "(?<![\\p{Lu}\\p{Ll}\\.@])(\\p{Ll}{3,})(?![@\\p{Ll}])";
    static final String REGEXNAME = "(\\p{Lu}{1}\\p{Ll}{1,})\\s(\\p{Lu}{1}\\p{Ll}{1,})";

    public static void main(String[] args) {
        String input = Util.getInput("part1.txt");
        convert1(input);
        convert2(input);
        convert3(input);
        convert4(input);
    }

    public static String convert1(String input) {
        String[] split = input.split("\\R");

        Pattern pEmail = Pattern.compile(REGEXEMAIL);
        Pattern pLogin = Pattern.compile(REGEXLOGIN);

        StringBuilder strb = new StringBuilder("");
        String result = "";

        for (int i = 0; i < split.length; i++) {
            Matcher mLogin = pLogin.matcher(split[i]);
            Matcher mEmail = pEmail.matcher(split[i]);
            if (mEmail.find() && mLogin.find()) {
                strb = strb.append(mLogin.group()).append(": ").append(mEmail.group()).append("\n");
            }
        }
        result = strb.toString();

        return result;
    }

    public static String convert2(String input) {
        String[] split = input.split("\\R");

        Pattern pEmail = Pattern.compile(REGEXEMAIL);
        Pattern pName = Pattern.compile(REGEXNAME);

        StringBuilder strb = new StringBuilder("");
        String result = "";

        for (int i = 0; i < split.length; i++) {
            Matcher mName = pName.matcher(split[i]);
            Matcher mEmail = pEmail.matcher(split[i]);
            if (mName.find() && mEmail.find()) {
                String [] temp = mName.group().split("\\s");
                strb = strb.append(temp[1] + " ").append(temp[0]).append(" (email: ").append(mEmail.group()).append(")").append("\n");
            }
        }
        result = strb.toString();

        return result;
    }

    public static String convert3(String input) {
        String[] split = input.split("\\R");

        Pattern p2 = Pattern.compile(REGEXEMAIL);
        Pattern p3 = Pattern.compile(REGEXLOGIN);

        StringBuilder sb = new StringBuilder("");
        String result = "";

        String[] array = new String[split.length];
        Arrays.fill(array, "");
        int count = 0;
        int index = 0;
        String temp;
        boolean empty = true;

        for (String s : split) {
            Matcher m2 = p2.matcher(s);
            Matcher m3 = p3.matcher(s);
            while (m2.find()) {
                temp = m2.group(2) + m2.group(3);
                while (m3.find()) {
                    if (!array[index].contains(temp)) {
                        if (empty) {
                            array[0] = temp + " ==> " + m3.group();
                            count++;
                            empty = false;
                        } else {
                            for (int i = 0; i < count; i++) {
                                if ((!array[i].contains(temp)) && ((count - 1) == i)) {
                                    array[count] = temp + " ==> " + m3.group();
                                    count++;
                                    break;
                                } else if (array[i].contains(temp)) {
                                    array[i] = array[i] + ", " + m3.group();
                                }
                            }
                        }
                    } else array[index] = array[index] + ", " + m3.group();
                }
            }
        }
        for (int i = 0; i < count; i++) {
            sb.append(array[i]).append("\n");
        }
        result = sb.toString();

        return result;
    }

    public static String convert4(String input) {
        String[] split = input.split("\\R");

        StringBuilder sb = new StringBuilder("");
        String result = "";

        sb.append(split[0]).append("Password").append("\n");
        for (int i = 1; i < split.length; i++) {
            sb.append(split[i]).append(";").append(randomPassword(4)).append("\n");
        }
        result = sb.toString();
        return result;
    }
    
    public static String randomPassword(int size) {
        StringBuilder strb2 = new StringBuilder("");
        String password = "";
        Random rand = new Random();
        int randNum = 0;

        for (int j = 0; j < size; j++) {
            randNum = rand.nextInt(10);
            strb2.append(randNum);
        }
        password = strb2.toString();
        return password;
    }
    
}