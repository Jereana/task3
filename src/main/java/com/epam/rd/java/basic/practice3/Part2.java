package com.epam.rd.java.basic.practice3;

public class Part2 {

    public static void main(String[] args) {
        String input = Util.getInput("part2.txt");
        System.out.println(convert(input));
    }

    public static String convert(String input) {
        String correctInput = normalizeInput(input);
        String[] inputString = correctInput.split("\\s*(\\s|,|!|'|-|\\.)\\s*");

        int maxWordLenght = 0;
        int minLength = 20;
        StringBuilder arrayMinSB = new StringBuilder();
        StringBuilder arrayMaxSB = new StringBuilder();

        for(String word: inputString)
        {
            if(( word.length() < minLength) &&  (arrayMinSB.indexOf(word) == -1)) {
                arrayMinSB.setLength(0);
                arrayMinSB.append(" ").append(word).append(",");
                minLength = word.length();
            } else if (( word.length() == minLength) && (arrayMinSB.indexOf(word) == -1)){
                arrayMinSB.append(" ").append(word).append(",");
            }
            if (maxWordLenght < word.length()) {
                maxWordLenght = word.length();
                arrayMaxSB.setLength(0);
                arrayMaxSB.append(" ").append(word).append(",");
            } else if (maxWordLenght == word.length() && (arrayMaxSB.indexOf(word) == -1)) {
                arrayMaxSB.append(" ").append(word).append(",");
            }
        }
        return "Min:" + (arrayMinSB.length() == 0 ? (arrayMinSB.toString()) : (arrayMinSB.toString().substring(0, arrayMinSB.length() - 1))) + "\n" +
                "Max:" + (arrayMaxSB.length() == 0 ? (arrayMaxSB.toString()) : (arrayMaxSB.toString().substring(0, arrayMaxSB.length() - 1)));
    }
    
    private static String normalizeInput(String input){
        return input.replace("\\R","\n");
    }
}
