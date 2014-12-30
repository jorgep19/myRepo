package com.company;

public class Main {

    public static void main(String[] args) {
//	    int x = 5;
//        System.out.println((x&1) == 0);
//        System.out.println(5>>1);
//        System.out.println(5<<1);
//        System.out.println(2^1);
        int x = 11;
        int rem;
        StringBuilder sb = new StringBuilder();

        do {
            rem = x %2;
            sb.append(rem);
            x = x/2;
        } while(x > 0);

        System.out.println(sb.reverse());
    }
}
