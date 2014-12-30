package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem {

    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
        int n;
        int k;
        int currentIndex;
        List<Integer> people = new ArrayList<Integer>();

        while(input.hasNext()) {
            n = input.nextInt();
            k = input.nextInt();
            currentIndex = -1;

            for(int i = 0; i < n; i++) {
                people.add(i+1);
            }

            while(people.size() != 1) {

                for(int j = 0; j < k; j++) {
                    currentIndex = currentIndex + 1 < people.size() ?
                                    currentIndex + 1 :
                                    0;
                }
                people.remove(currentIndex);
                --currentIndex;
            }

            System.out.println(people.get(0));
            people.clear();
        }
    }
}
