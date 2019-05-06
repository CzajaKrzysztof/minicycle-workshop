package com.codecool.adventure;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Room {
    public final String description;
    public final String title;
    public final Map<String, String> exits;
    public List<String> listOfItems;

    public Room(String title, String description, HashMap<String, String> exits){
        this.title = title;
        this.description = description;
        this.exits = exits;
        
    }
    public Room(String title, String description, HashMap<String, String> exits, ArrayList<String> listOfItems){
        this(title, description, exits);
        this.listOfItems = listOfItems;
    }
}

