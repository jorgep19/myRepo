package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class Problem {
    private static class Pair {
        public int key;
        public int value;

        public Pair(int x, int y) {
            key = x;
            value = y;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int L;
        int[] lPool;
        int M;
        int[] mPool;
        int N;
        int[] nPool;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum;
        Integer current;
        Pair max;

        while(input.hasNext()) {
            L = input.nextInt();
            lPool = new int[L];
            M = input.nextInt();
            mPool = new int[M];
            N = input.nextInt();
            nPool = new int[N];
            max = new Pair(0, 0);

            for (int i = 0; i < L; i++) {
                lPool[i] = input.nextInt();
            }

            for (int i = 0; i < M; i++) {
                mPool[i] = input.nextInt();
            }

            for (int i = 0; i < N; i++) {
                nPool[i] = input.nextInt();
            }

            for (int l = 0; l < L; l++) {
                for (int m = 0; m < M; m++) {
                    for (int n = 0; n < N; n++) {
                        sum = lPool[l] + mPool[m] + nPool[n];
                        current = map.get(sum);

                        if(current == null) {
                            map.put(sum, 1);
                        } else {
                            map.put(sum, current + 1);
                        }
                    }
                }
            }

            for(Integer key : map.keySet()) {
                if(map.get(key) > max.value) {
                   max =  new Pair(key, map.get(key));
                }
            }

            System.out.println(max.key);
        }
    }
}
