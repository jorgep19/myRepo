package com.company;

public class Main {

    public static void main(String[] args) {
        int n = 9;
        System.out.println(squareFloorInLinear(n));
        System.out.println(squareFloorInLog(n));
    }

    public static int squareFloorInLinear(int n) {
        int i = 0;

        while(i*i <= n) {
            ++i;
        }

        return --i;
    }

    public static int squareFloorInLog(int n) {
        int min = 0;
        int max = n;
        int val = -1;
        int previousRange;
        int previousLarger = -1;
        int middle = 0;

        while(min <= max) {
            previousRange = ((max-min) / 2);
            middle = min + previousRange;

            if(middle * middle == n){
                val = middle;
                break;
            } else if(middle * middle < n) {
                if(previousLarger == middle+previousRange){
                    val = middle;
                }
                min = middle + 1;
            } else {
                previousLarger = middle;
                max = middle-1;
            }
        }

        return (middle == val ? val : --previousLarger);
    }
}
