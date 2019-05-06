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

    public Room(String title, String description){
        this.title = title;
        this.description = description;
        listOfItems = new ArrayList<>();
        exits = new HashMap<>();
    }

    public void addItemToList(String item){
        listOfItems.add("Sword");
    }

    public void addDirection(String direction, String room) {
        exits.put(direction, room);
    }
}

