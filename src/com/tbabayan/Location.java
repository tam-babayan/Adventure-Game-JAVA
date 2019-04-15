package com.tbabayan;

import java.util.HashMap;
import java.util.Map;

public final class Location {

    private final int locationID;
    private final String description;
    private Map<String, Integer> exits;


    // constructor
    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        this.exits = new HashMap<>(exits);
        this.exits.put("Q", 0);
    }

    // getters
    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits);
    }
}
