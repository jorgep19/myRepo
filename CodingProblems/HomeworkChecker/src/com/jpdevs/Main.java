package com.jpdevs;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line;
        String[] splittedLine;
        char operator;
        int a;
        int b;
        int c;
        int correctCount = 0;

        while (input.hasNext()) {
            line = input.nextLine();
            if (line.contains("?")) {
                continue;
            }

            splittedLine = line.split("/|\\+|\\-|\\=");
            a = Integer.parseInt(splittedLine[0]);
            if (line.contains("+")) {
                operator = line.charAt(line.indexOf('+'));
            } else {
                operator = line.charAt(line.indexOf('-'));
            }
            b = Integer.parseInt(splittedLine[1]);
            c = Integer.parseInt(splittedLine[2]);

            if(operator == '+') {
                if(a+b == c) {
                    correctCount++;
                }
            } else {
                if(a-b == c) {
                    correctCount++;
                }
            }
        }

        System.out.println(correctCount);
    }
}
