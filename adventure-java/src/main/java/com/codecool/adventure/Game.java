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
        HashMap<String, String> exits = new HashMap<>();
        exits.put("north", "cave");
        Room outside = new Room("Outside", "You're standing outside a huge cave.", exits);
        rooms.put("outside", outside);
        exits.clear();

        exits.put("north", "hall1");
        exits.put("south", "outside");
        exits.put("west", "armory");
        exits.put("east", "concierge");
        Room cave = new Room("Cave", "You're in a cave.", exits);
        rooms.put("cave", cave);
        exits.clear();

        exits.put("east", "cave");
        Room armory = new Room("Armory", "You are in a room with weapons.", exits);
        rooms.put("armory", armory);
        exits.clear();

        exits.put("west", "cave");
        Room concierge = new Room("Concierge", "Concierge desk.", exits);
        rooms.put("concierge", concierge);
        exits.clear();

        exits.put("south", "cave");
        Room hall1 = new Room("Hall", "You are in a hall", exits);
        rooms.put("hall", hall1);
        exits.clear();
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
                    moveNorth();
                    break;

                case "s":
                case "south":
                    moveSouth();
                    break;

                case "e":
                case "east":
                    moveEast();
                    break;

                case "w":
                case "west":
                    moveWest();
                    break;

                default:
                    System.out.println("Unrecognized command: " + command);
                    break;
            }
        }
    }
    private boolean checkMovement(String direction){
        if()
    }

    private void moveNorth(){
        for()
    }

    private void moveSouth(){

    }

    private void moveWest(){

    }

    private void moveEast(){

    }

    private void describeRoom() {
        Room room = rooms.get(roomName);
        System.out.println();
        System.out.println(room.title);
        System.out.println();
        System.out.println(room.description);
    }
}
