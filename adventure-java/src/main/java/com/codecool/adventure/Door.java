package com.codecool.adventure;

public class Door {
    private boolean areOpened;
    private final String key;

    public Door(String key, boolean areOpened){
        this.key = key;
        this.areOpened = areOpened;
    }
}