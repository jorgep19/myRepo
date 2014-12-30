package com.jpdevs;

import java.util.*;

public class Main {
    private class Position{
        public int x;
        public int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static Main sol = new Main();
    private static int[] xMoves = { 0, 1, 0, -1 };
    private static int[] yMoves = { -1, 0, 1, 0 };
    private List<Integer> lengths = new ArrayList<Integer>();
    private int m;
    private boolean[][] visited;
    private char[][] field = {
            {'1','2'},
            {'3', '3'}
    };

    public static void main(String[] args) {
        sol = new Main();
        sol.solution();
    }

    private void solution() {
        Scanner input = new Scanner(System.in);
        String line;

        while(input.hasNext()) {
            m = input.nextInt();
            field = new char[m][m];
            visited = new boolean[m][m];
            for(int i = 0; i < m; i++) {
                line = input.nextLine();
                for(int j = 0; j < m; j++){
                    field[i][j] = line.charAt(j);
                }
            }

            System.out.println(sol.findShortest());
        }
    }

    private int findShortest() {
        int maxShortest = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < m; j++){
                if(field[i][j] == '1') {
                    lengths.add(findShortestFromOne(new Position(i, j)));
                }
            }
        }

        maxShortest = sol.getMaxShortest();

        return maxShortest;
    }

    private int getMaxShortest() {
        int max = lengths.get(0);
        int tmp;

        for(int i = 1; i < lengths.size(); i++) {
            tmp = lengths.get(i);

            if(max < tmp) {
                max = tmp;
            }
        }

        return max;
    }

    private int findShortestFromOne(Position init) {
        Queue<Position> q = new LinkedList<Position>();
        int newX;
        int newY;
        Position currentPos;
        q.add(init);

        while (!q.isEmpty()) {
            currentPos = q.peek();
            q.remove();

            if(!visited[currentPos.x][currentPos.y]) {

                visited[currentPos.x][currentPos.y] = true;
                if(field[currentPos.x][currentPos.y] == '3') {
                    return getDistance(init, currentPos);
                }

                for(int i = 0; i < xMoves.length; i++) {
                    newX = currentPos.x + xMoves[i];
                    newY = currentPos.y + yMoves[i];
                    if(newX > -1 && newX < m && newY > -1 && newY < m) {
                        q.add(new Position(newX, newY));

                    }
                }
            }
        }

        return 0;
    }

    private int getDistance(Position a, Position b) {
        int steps = a.x > b.x ? a.x - b.x : b.x - a.x;
        steps += a.y > b.y ? a.y - b.y : b.y - a.y;

        return steps;
    }
}
