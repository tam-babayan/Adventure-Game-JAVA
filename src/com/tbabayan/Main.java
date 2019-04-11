package com.tbabayan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Map<Integer, Location> locations = new HashMap<Integer, Location>();

        Scanner scanner = new Scanner(System.in);

        locations.put(0, new Location(0, "You are sitting in front of the computer"));
        locations.put(1, new Location(1, "You are standing at the end of a road, near a small brick"));
        locations.put(2, new Location(2, "You are at the top of the hill"));
        locations.put(3, new Location(3, "You are inside of a building"));
        locations.put(4, new Location(4, "You are in a valley"));
        locations.put(5, new Location(5, "You are ina forest"));

        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0) {
                break;
            }
            loc = scanner.nextInt();
            if (!locations.containsKey(loc)) {
                System.out.println("You can not go in that direction");
            }
        }


    }
}
