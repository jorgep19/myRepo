package com.company;

import java.util.*;

public class Problem {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String category;
        Integer count;
        int pieCount;
        HashMap<String, Integer> desserts = new HashMap<String, Integer>();
        List<String> sortedCategories;

        while(input.hasNext()) {
            category = input.nextLine();
            count = desserts.get(category);

            if(count == null) {
                desserts.put(category, 1);
            } else {
                desserts.put(category, count + 1);
            }
        }

        sortedCategories = new ArrayList<String>(desserts.keySet());
        Collections.sort(sortedCategories);

        for(String c : sortedCategories) {
            if(c.contains("slice")) {
                count = desserts.get(c);
                if(count/4 != 0) {
                    System.out.println(String.format("%d|%s",
                            count/4,
                            c.substring(0, c.lastIndexOf('e') - 5)));
                }

                if (count%4 != 0) {
                    System.out.println(String.format("%d|%s",count%4, c));
                }
            } else {
                System.out.println(String.format("%d|%s", desserts.get(c), c));
            }
        }
    }
}
