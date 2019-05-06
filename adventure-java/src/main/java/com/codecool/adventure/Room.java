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
    public Map<String, Door> listOfDoors;
    public List<NonPlayerCharacter> listOfNPC;

    public Room(String title, String description){
        this.title = title;
        this.description = description;
        listOfItems = new ArrayList<>();
        exits = new HashMap<>();
        listOfDoors = new HashMap<>();
        listOfNPC = new ArrayList<>();
    }

    public void addItemToList(String item){
        listOfItems.add(item);
    }

    public void addDirection(String direction, String room) {
        exits.put(direction, room);
    }

    public void addDoors(String direction, Door doors){
        listOfDoors.put(direction, doors);
    }

    public void addNPC(NonPlayerCharacter npc){
        listOfNPC.add(npc);
    }


}

