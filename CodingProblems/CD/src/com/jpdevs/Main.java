package com.jpdevs;

import java.util.Scanner;

public class Main {
    private static Main m = new Main();
    private int jackCDCount;
    private int jillCDCount;
    private int[] jackCDs;
    private int[] jillCDs;

    public static void main(String[] args) {
        m.solution();
    }

    private void solution(){
        Scanner input = new Scanner(System.in);

        do {
            jackCDCount = input.nextInt();
            jillCDCount = input.nextInt();

            jackCDs = new int[jackCDCount];
            jillCDs = new int[jillCDCount];

            for(int i = 0; i < jackCDCount; i++) {
                jackCDs[i] = input.nextInt();
            }

            for(int i = 0; i < jillCDCount; i++) {
                jillCDs[i] = input.nextInt();
            }

            System.out.println(m.getDuplicateCDsCount());

        } while(jackCDCount != 0 && jillCDCount != 0);
    }

    private int getDuplicateCDsCount() {
        int duplicateCount = 0;
        int jack = 0;
        int jill = 0;

        while(jack < jackCDCount && jill < jillCDCount) {
            if(jackCDs[jack] == jillCDs[jill]) {
                duplicateCount++;
                jack++;
                jill++;
            } else if (jackCDs[jack] > jillCDs[jill]) {
                jill++;
            } else {
                jack++;
            }
        }

        return duplicateCount;
    }
}
