package com.tbabayan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, Location> locations = new HashMap<Integer, Location>();

        Map<String, Integer> computerExits = new HashMap<>();
        locations.put(0, new Location(0, "You are sitting in front of the computer", computerExits));

        Map<String, Integer> endOfRowExits = new HashMap<>();
        endOfRowExits.put("N", 5);
        endOfRowExits.put("E", 3);
        endOfRowExits.put("S", 4);
        endOfRowExits.put("W", 2);
        locations.put(1, new Location(1, "You are standing at the end of a road, near a small brick", endOfRowExits));

        Map<String, Integer> hillExits = new HashMap<>();
        hillExits.put("N", 5);
        locations.put(2, new Location(2, "You are at the top of the hill", hillExits));

        Map<String, Integer> buildngExits = new HashMap<>();
        buildngExits.put("W", 1);
        locations.put(3, new Location(3, "You are inside of a building", buildngExits));

        Map<String, Integer> valleyExits = new HashMap<>();
        valleyExits.put("N", 1);
        valleyExits.put("W", 2);
        locations.put(4, new Location(4, "You are in a valley", valleyExits));

        Map<String, Integer> forestExits = new HashMap<>();
        forestExits.put("W", 2);
        forestExits.put("S", 1);
        locations.put(5, new Location(5, "You are in a forest", forestExits));


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
