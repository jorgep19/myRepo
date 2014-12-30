package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> sortedCategories;
        String currentCategory;
        Integer count;
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        while (input.hasNext()) {
            currentCategory = input.nextLine();
            count = map.get(currentCategory);

            if(count == null) {
                map.put(currentCategory, 1);
            } else {
                map.put(currentCategory, (count +1) );
            }
        }

        sortedCategories = new ArrayList<String>(map.keySet());
        Collections.sort(sortedCategories, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.toUpperCase().compareTo(o2.toUpperCase());
            }
        });

        for(String category : sortedCategories){
            if(category.toLowerCase().contains("sock")) {
                count = map.get(category);
                if(count >= 2){
                    System.out.println(
                            String.format(
                                    "%d|%s",
                                    (map.get(category)/2),
                                    category
                            )
                    );
                }

                if (count > 0 && count % 2 != 0) {
                    System.out.println(
                            String.format(
                                    "0|%s",
                                    category
                            )
                    );
                }
            } else {
                System.out.println(
                        String.format(
                            "%d|%s",
                            map.get(category),
                            category
                        )
                );
            }
        }
    }
}
