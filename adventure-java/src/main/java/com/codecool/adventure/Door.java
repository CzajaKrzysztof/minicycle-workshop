package com.codecool.adventure;

public class Door {
    public boolean areOpened;
    private final String key;

    public Door(String key){
        areOpened = false;
        this.key = key;
    }

    public boolean areDoorOpen() {
        return areOpened;
    }

    public String getKey() {
        return key;
    }
}