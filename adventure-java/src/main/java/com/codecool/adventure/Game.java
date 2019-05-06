package com.codecool.adventure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    String roomName = "outside";
    Map<String, Room> rooms = new HashMap<>();
    List<String> inventory = new ArrayList<>();

    Game() {
        createRooms();
    }

    private void createRooms() {
        Room outside = new Room("Outside", "You're standing outside a huge cave.");
        outside.addDirection("north", "cave");
        rooms.put("outside", outside);

        Room cave = new Room("Cave", "You're in a cave.");
        cave.addDirection("north", "hall1");
        cave.addDirection("south", "outside");
        cave.addDirection("west", "armory");
        cave.addDirection("east", "concierge");
        rooms.put("cave", cave);
        cave.addDoors("west", new Door("Golden key"));

        Room armory = new Room("Armory", "You are in a room with weapons.");
        armory.addItemToList("Sword");
        armory.addDirection("east", "cave");
        rooms.put("armory", armory);

        Room concierge = new Room("Concierge", "Concierge desk.");
        concierge.addDirection("west", "cave");
        concierge.addItemToList("Golden key");
        rooms.put("concierge", concierge);

        Room hall1 = new Room("Hall", "You are in a hall");
        hall1.addDirection("south", "cave");
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

                case "inventory":
                case "i":
                    printInventory();
                    break;

                case "pick":
                case "p":
                    pickUpItem();
                    break;

                case "use":
                case "u":
                    useKey();
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
                case "h":
                case "help":
                    printHelpCommand();
                    break;

                default:
                    System.out.println("Unrecognized command: " + command);
                    break;
            }
        }
    }

    private void printInventory(){
        System.out.println(Arrays.toString(inventory.toArray()));
    }
    private void printHelpCommand(){
        System.out.println("Available command:");
        System.out.println("l - info about actual room");
        System.out.println("i - show inventory");
        System.out.println("pick or p - pick item");
        System.out.println("q - quit game");
        System.out.println("north or n - move in north direction");
        System.out.println("south or s - move in south direction");
        System.out.println("west or w - move in west direction");
        System.out.println("east or e - move in east direction");
    }

    private void pickUpItem(){
        System.out.println("Enter item which you want to pick up: ");
        String answer = Ui.input("");
        for(String item : rooms.get(roomName).listOfItems){
            if(answer.equals(item)){
                inventory.add(item);
            }
        }
        rooms.get(roomName).listOfItems.remove(answer);
    }

    private void useKey() {
        System.out.println("Inventory: ");
        printInventory();
        System.out.println("Pick item to use: ");
        String key = Ui.input("");
        System.out.println(rooms.get(roomName).listOfDoors.keySet().toString());
        System.out.println("Pick door to open: ");
        String doorString = Ui.input("");
        Door door = rooms.get(roomName).listOfDoors.get(doorString);
        door.areOpened = true;
    }

    private boolean checkMovement(String direction){
        if(rooms.get(roomName).exits.containsKey(direction)) {
            if(rooms.get(roomName).listOfDoors.containsKey(direction)) {
                Door door = rooms.get(roomName).listOfDoors.get(direction);
                if(door.areDoorOpen()) {
                    return true;
                } else {
                    System.out.println("You need " + door.getKey() + " to open.");
                }
            } else {
                return true;
            }
        } else {
            System.out.println("Cannot move there");
        }
        return false;  
    }

    private void move(String direction){
        if(checkMovement(direction)){
            Room currentRoom = rooms.get(roomName);
            roomName = currentRoom.exits.get(direction); 
        }
    }

    private void describeRoom() {
        Room room = rooms.get(roomName);
        System.out.println();
        System.out.println(room.title);
        System.out.println();
        System.out.println(room.description);
        System.out.println("Possible exits:" + room.exits.keySet().toString());
        System.out.println("There are items on the floor: " + room.listOfItems.toString());
    }
}
