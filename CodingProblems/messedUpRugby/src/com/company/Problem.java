package com.company;

import java.util.*;

public class Problem {
    private static final int POINTS_FROM_KICK = 2;
    private static final int POINTS_FROM_TRIE = 3;
    private static final int POINTS_FROM_CONVERSION = 7;
    private static final int[] SCORE_TYPES = {
            POINTS_FROM_KICK,
            POINTS_FROM_TRIE,
            POINTS_FROM_CONVERSION
    };
    private LinkedList<Integer> path;
    private List<State> states;


    public static void main(String[] args) {
        Problem sol = new Problem();
        Scanner input = new Scanner(System.in);
        int score;

        while(input.hasNext()) {
            score = input.nextInt();
            sol.path = new LinkedList<Integer>();
            sol.states = new ArrayList<State>();

            sol.calculateScoreCombinations(score, 0);

            Collections.sort(sol.states);
            for(State s: sol.states) {
                System.out.println(s);
            }
        }
    }

    private void calculateScoreCombinations(int score, int j) {
        if(score < 0){
            return;
        }

        if(score == 0) {
            State current = new State();
            for(Integer i : path) {
                current.score(i);
            }

            states.add(current);
            return;
        }

        for(int i = j; i < SCORE_TYPES.length; i++) {
            path.add(SCORE_TYPES[i]);
            calculateScoreCombinations(score - SCORE_TYPES[i], i);
            path.removeLast();
        }
    }

    private class State implements Comparable<State> {
        private int conversionCount;
        private int triesCount;
        private int kicksCount;

        public State() {
            conversionCount = 0;
            triesCount = 0;
            kicksCount = 0;
        }

        public void score(int points){
            switch (points) {
                case POINTS_FROM_KICK:
                    scoreKick();
                    break;
                case POINTS_FROM_TRIE:
                    scoreTrie();
                    break;
                case POINTS_FROM_CONVERSION:
                    scoreConversion();
                    break;
            }
        }

        public void scoreKick() {
            kicksCount++;
        }

        public void scoreTrie() {
            triesCount++;
        }

        public void scoreConversion() {
            conversionCount++;
        }

        public String toString(){
            return String.format(
                    "%d %d %d",
                    conversionCount,
                    triesCount,
                    kicksCount);
        }

        @Override
        public int compareTo(State o) {
            int result;
            if(conversionCount == o.conversionCount) {
                if(triesCount == o.triesCount) {
                    if(kicksCount == o.kicksCount) {
                        result = 0;
                    } else if (kicksCount > o.kicksCount) {
                        result = 1;
                    } else {
                        result = -1;
                    }
                } else if (triesCount > o.triesCount) {
                    result = 1;
                } else {
                    result = -1;
                }

            } else if(conversionCount > o.conversionCount) {
                result = 1;
            } else {
                result = -1;
            }

            return result;
        }
    }
}
