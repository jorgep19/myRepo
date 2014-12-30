package com.company;

import java.util.*;

class Main {
    private static class CounterCatch {
        private char coin;
        private boolean isHeavy;

        public CounterCatch(char c, boolean b) {
            coin = c;
            isHeavy = b;
        }

        public String toString() {
            return String.format("%s is the counterfeit coin and it is %s.", coin, isHeavy? "heavy": "light");
        }
    }

    private static class Weighting {
        private char[] left;
        private char[] right;
        private char[] all;
        private String rightPosition;

        public Weighting(String s) {
            String[] split = s.split(" ");
            left = split[0].toCharArray();
            right = split[1].toCharArray();
            all = new char[left.length + right.length];
            System.arraycopy(left, 0, all, 0, left.length);
            for (int i = left.length, j =0; i < all.length; i++, j++) {
                all[i] = right[j];
            }
            rightPosition = split[2];
        }

        public boolean isEven() {
            return  rightPosition.equals("even");
        }

        public char[] getAll() {
            return all;
        }

        public char[] getLeft() {
            return left;
        }

        public char[] getRight() {
            return right;
        }

        public boolean isOnHeavySide(char c) {
            boolean isOnRight = false;

            for (char k: right) {
                if(k == c) {
                    isOnRight = true;
                    break;
                }
            }

            return (isOnRight && rightPosition.equals("down")) || (!isOnRight && !rightPosition.equals("down"));
        }

        public boolean isOnBothSide(char c) {
            boolean itIsOnLeft = false;
            boolean itIsOnRight = false;

            for (char k: left) {
                if(k == c) {
                    itIsOnLeft = true;
                    break;
                }
            }

            if(itIsOnLeft) {
                for (char k: right) {
                    if(k == c) {
                        itIsOnRight = true;
                        break;
                    }
                }
            }

            return itIsOnLeft && itIsOnRight;
        }

        public String getRightPosition() {
            return rightPosition;
        }
    }

    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);

        int testCaseCount = input.nextInt();
        input.nextLine(); // clear first line after the
        Weighting[] weightings = new Weighting[3];
        List<Weighting> evenWeightings = new ArrayList<Weighting>();
        List<Weighting> nonEvenWeightings = new ArrayList<Weighting>();
        Weighting w1;
        Weighting w2;
        Weighting w3;


        for(int i = 0; i < testCaseCount; i++) {
            evenWeightings.clear();
            nonEvenWeightings.clear();

            w1 = new Weighting(input.nextLine());
            weightings[0] = w1;
            w2 = new Weighting(input.nextLine());
            weightings[1] = w2;
            w3 = new Weighting(input.nextLine());
            weightings[2] = w3;

            for(Weighting w : weightings) {
                if(w.isEven()) {
                    evenWeightings.add(w);
                } else {
                    nonEvenWeightings.add(w);
                }
            }

            CounterCatch result = findBadCoin(evenWeightings, nonEvenWeightings);
            System.out.println(result);
        }
    }

    public static CounterCatch findBadCoin(List<Weighting> evens, List<Weighting> nonEvens) {
        List<Character> possibleBadCoins = new ArrayList<Character>();
        possibleBadCoins.addAll(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L'));

        List<Character> weightedPossibleBadCoins = new ArrayList<Character>();
        for (Weighting w : nonEvens) {
            for (char c : w.getAll()) {
                weightedPossibleBadCoins.add(c);
            }
        }

        List<Character> guaranteedGoodCoins = new ArrayList<Character>();
        for (Weighting w : evens) {
            for (char c : w.getAll()) {
                if(!w.isOnBothSide(c)) {
                    guaranteedGoodCoins.add(c);
                }
            }
        }

        List<Character> filteredBadCoins = new ArrayList<Character>(possibleBadCoins);
        for (char c: possibleBadCoins) {
            if ( guaranteedGoodCoins.contains(c) ) {
                filteredBadCoins.remove(filteredBadCoins.indexOf(c));
            }
        }

        if (filteredBadCoins.size() > 1) {
            for (char c: possibleBadCoins) {
                if (!weightedPossibleBadCoins.contains(c) && filteredBadCoins.contains(c)) {
                    filteredBadCoins.remove(filteredBadCoins.indexOf(c));
                }
            }
        }

        if(filteredBadCoins.size() > 1 && nonEvens.size() > 1) {
            List<Character> newPool = new ArrayList<Character>();

            // if all uneven measurements title the same way
            String p = nonEvens.get(0).getRightPosition();
            if (p.equals("down")) {
                for (Weighting w : nonEvens) {
                    for (char c : w.getLeft()) {
                        if(!newPool.contains(c)) {
                            newPool.add(c);
                        }
                    }
                }
            } else {
                for (Weighting w : nonEvens) {
                    for (char c : w.getRight()) {
                        newPool.add(c);
                    }
                }
            }

            for(char c : guaranteedGoodCoins) {
                if(newPool.contains(c)) {
                    newPool.remove(newPool.indexOf(c));
                }
            }
            filteredBadCoins = newPool;
        }

        char c = filteredBadCoins.get(0);
        boolean b = nonEvens.size() <= 0 || nonEvens.get(0).isOnHeavySide(c);
        return new CounterCatch(c,b);
    }
}
