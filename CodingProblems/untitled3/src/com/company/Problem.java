package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem {

    private static List<Integer> primes;

    public static void main(String[] args) {
        primes = new ArrayList<Integer>();
        primes.add(1);
        primes.add(2);
        Scanner input = new Scanner(System.in);

        int k; // smaller
        int j;
        int start;
        int current;
        int sum;
        boolean isPrime = false;

        while(input.hasNext()) {
            k = input.nextInt();
            j = input.nextInt();
            sum = 0;

            // zero is not a prime number
            for(int x = 3; x <= j; x++) {
                if(primes.get(primes.size()-1) < x) {
                    for(int y = 2; y < x; y++) {
                        if(x % y == 0) {
                            isPrime = false;
                            break;
                        }
                        isPrime = true;
                    }
                    if(isPrime) {
                        primes.add(x);
                    }
                }
            }

            start = primes.indexOf(k);
            current = -1;
            while(current != j) {
                current = primes.get(start);
                sum += current;
                start++;
            }

            System.out.println(sum);
        }
    }
}
