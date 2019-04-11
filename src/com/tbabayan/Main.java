package com.tbabayan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, Location> locations = new HashMap<Integer, Location>();

        // initialize 6 Location classes and add to locations Map
        locations.put(0, new Location(0, "You are sitting in front of the computer"));
        locations.put(1, new Location(1, "You are standing at the end of a road, near a small brick"));
        locations.put(2, new Location(2, "You are at the top of the hill"));
        locations.put(3, new Location(3, "You are inside of a building"));
        locations.put(4, new Location(4, "You are in a valley"));
        locations.put(5, new Location(5, "You are in a forest"));

        // define available exit directions
        locations.get(1).addExit("N", 5);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("W", 2);
        locations.get(2).addExit("N", 5);
        locations.get(3).addExit("W", 1);
        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);
        locations.get(5).addExit("W", 2);
        locations.get(5).addExit("S", 1);

        // define vocabulary of user commands
        Map<String, String> vocabulary = new HashMap<String, String>();
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");
        vocabulary.put("QUIT", "Q");

        // change the location based on user input
        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0) {

                break;
            }
            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are: ");
            for (String exit : exits.keySet()) {
                System.out.print(exit + " ");
            }
            System.out.println();
            String direction = scanner.nextLine().toUpperCase();
            if (direction.length() > 1) {
                String [] words = direction.split(" ");
                for (String word : words) {
                    if (vocabulary.containsKey(word)) {
                        direction = vocabulary.get(word);

                        break;
                    }
                }
            }
            if (exits.containsKey(direction)) {
                loc = exits.get(direction);
            } else {
                System.out.println("You can not go in that direction");
            }
        }

    }
}
