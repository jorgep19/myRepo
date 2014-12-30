package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String word;
        String palim;
        int shortestLength;

        while(input.hasNext()) {
            word = input.nextLine();
            palim = makePalim(word);
            shortestLength = calculateShortestPalim(palim, word);

            System.out.println(shortestLength);
        }
    }

    private static String makePalim(String s) {
        char[] original = s.toCharArray();
        char[] palim = new char[(original.length*2)];

        int j = 0;
        for(int i = (original.length -1); i >= 0; --i) {
            palim[j] = original[i];
            palim[palim.length-1-j] = original[i];
            ++j;
        }

        return new String(palim);
    }

    private static int calculateShortestPalim(String s, String o) {
        StringBuilder sb1 = new StringBuilder();
        sb1.append(s);
        String fromStart = sb1.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(s);
        String fromMiddle = sb2.toString();
        int i = 0;
        int j = (o.length()-1);

        while(i < sb1.length() || j > -1) {
            sb1.deleteCharAt(i);
            if(isPalim(sb1.toString())) {
                fromStart = sb1.toString();
            }

            sb2.deleteCharAt(j);
            if(isPalim(sb2.toString())) {
                fromMiddle = sb2.toString();
            }

            ++i;
            --j;
        }

        return fromMiddle.length() < fromStart.length() ? fromMiddle.length() : fromStart.length();
    }

    private static boolean isPalim(String s) {
        for(int i = 0; i < s.length()/2; i++) {
            if( s.charAt(i) != s.charAt(s.length()-1-i) ) {
                return false;
            }
        }

        return true;
    }
}
