package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    private static class Card {
        private char suit;
        private char rank;

        public Card(String s) {
            suit = s.charAt(0);
            rank = s.charAt(1);
        }

        public boolean matches(Card c) {
            return this.suit == c.suit || this.rank == c.rank;
        }

        public String toString() {
            return String.format("%s%s ", suit, rank);
        }
    }

    public static void main(String[] args) {
        List<Stack<Card>> piles = new ArrayList<Stack<Card>>();
        String line;
        String[] cardsInput;

        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            line = input.nextLine();

            if (line.equals("#") ) {
                break;
            }

            piles.clear();
            line += " " + input.nextLine();
            cardsInput = line.split(" ");

            for (String s : cardsInput) {
                Stack<Card> tack = new Stack<Card>();
                tack.add(new Card(s));
                piles.add(tack);
            }
            // done parsing

            int lastMoveIndex = 1;
            int indexToMove;
            int indexToMoveTo;
            while(piles.size() > 1) {
                indexToMove = -1;
                indexToMoveTo = -1;

                for (int i = lastMoveIndex; i < piles.size(); i++) {
                    if (i - 1 >= 0 && piles.get(i - 1).peek().matches(piles.get(i).peek())) {
                        indexToMove = i;
                        indexToMoveTo = i - 1;
                        if (i - 3 >= 0 && (piles.get(i - 3).peek().matches(piles.get(i).peek()))) {
                            indexToMoveTo = i - 3;
                        }
                        break;
                    }
                }

                if (indexToMove == -1 && indexToMoveTo == -1) {
                    break;
                }

                lastMoveIndex = indexToMoveTo - 1;
                Card c = piles.get(indexToMove).pop();
                piles.get(indexToMoveTo).push(c);
                if (piles.get(indexToMove).size() == 0) {
                    piles.remove(indexToMove);
                }
            }

            System.out.println(String.format("%d pile remaining:", piles.size()));
        }
    }
}