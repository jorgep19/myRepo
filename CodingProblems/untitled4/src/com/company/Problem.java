package com.company;

import java.util.Scanner;

public class Problem {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int w;
        int n;
        double[] positions;

        while(input.hasNext()) {
            w = input.nextInt();
            n = input.nextInt();
            positions = new double[n];

            for(int i = 0; i < n; i++) {
                positions[i] = input.nextDouble();
            }
        }
    }
}
