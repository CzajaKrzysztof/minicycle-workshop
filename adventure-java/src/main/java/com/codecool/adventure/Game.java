package com.codecool.adventure;

import java.util.HashMap;
import java.util.Map;

public class Game {
    String roomName = "outside";
    Map<String, Room> rooms = new HashMap<>();


    Game() {
        createRooms();
    }

    private void createRooms() {
        HashMap<String, String> exitsOutside = new HashMap<>();
        exitsOutside.put("north", "cave");
        Room outside = new Room("Outside", "You're standing outside a huge cave.", exitsOutside);
        rooms.put("outside", outside);

        HashMap<String, String> exitsCave = new HashMap<>();
        exitsCave.put("north", "hall1");
        exitsCave.put("south", "outside");
        exitsCave.put("west", "armory");
        exitsCave.put("east", "concierge");
        Room cave = new Room("Cave", "You're in a cave.", exitsCave);
        rooms.put("cave", cave);

        HashMap<String, String> exitsArmory = new HashMap<>();
        exitsArmory.put("east", "cave");
        Room armory = new Room("Armory", "You are in a room with weapons.", exitsArmory);
        rooms.put("armory", armory);

        HashMap<String, String> exitsConcierge = new HashMap<>();
        exitsConcierge.put("west", "cave");
        Room concierge = new Room("Concierge", "Concierge desk.", exitsConcierge);
        rooms.put("concierge", concierge);

        HashMap<String, String> exitsHall = new HashMap<>();
        exitsHall.put("south", "cave");
        Room hall1 = new Room("Hall", "You are in a hall", exitsHall);
        rooms.put("hall1", hall1);

    }

    public void run() {
        describeRoom();
        boolean playing = true;
        while (playing) {
            System.out.println();
            String command = Ui.input("> ");
            switch (command) {
                case "l":
                case "look":
                    describeRoom();
                    break;

                case "q":
                case "quit":
                    System.out.println("Goodbye!");
                    playing = false;
                    break;

                case "n":
                case "north":
                    move("north");
                    describeRoom();
                    break;

                case "s":
                case "south":
                    move("south");
                    describeRoom();
                    break;

                case "e":
                case "east":
                    move("east");
                    describeRoom();
                    break;

                case "w":
                case "west":
                    move("west");
                    describeRoom();
                    break;

                default:
                    System.out.println("Unrecognized command: " + command);
                    break;
            }
        }
    }
    private boolean checkMovement(String direction){
        return rooms.get(roomName).exits.containsKey(direction);  
    }

    private void move(String direction){
        if(checkMovement(direction)){
            Room currentRoom = rooms.get(roomName);
            roomName = currentRoom.exits.get(direction); 
        }else{
            System.out.println("Cannot move there");
        }
    }

    private void describeRoom() {
        Room room = rooms.get(roomName);
        System.out.println();
        System.out.println(room.title);
        System.out.println();
        System.out.println(room.description);
        System.out.println("Possible exits:" + room.exits.toString());
    }
}
