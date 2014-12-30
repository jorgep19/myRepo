package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Problem {

    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
        int n;
        boolean[] cells;
        StringBuilder sb = new StringBuilder();
        String result;

        while(input.hasNext()) {
            n = input.nextInt();
            sb.setLength(0);
            cells = new boolean[n];
            Arrays.fill(cells, Boolean.FALSE);

            for(int i = 0; i < n; i++) {
                for(int cellNum = 0; cellNum < n; cellNum++) {
                    if((cellNum+1) % (i+1) == 0)   {
                        cells[cellNum] = !cells[cellNum];
                    }
                }
            }

            for(int cellNum = 0; cellNum < n; cellNum++) {
                if(cells[cellNum]) {
                    sb.append(cellNum+1);
                    sb.append(',');
                }
            }

            result = sb.toString();
            if(result.length() > 0) {
                System.out.println(result.substring(0, result.length() - 1));
            }
        }
    }
}
