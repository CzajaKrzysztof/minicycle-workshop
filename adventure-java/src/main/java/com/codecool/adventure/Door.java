package com.codecool.adventure;

public class Door {
    private boolean areOpened;
    private final String key;

    public Door(String key){
        this.key = key;
    }
    public boolean areOpened(){
        return areOpened;
    }

    public boolean areOpen() {
        return areOpened;
    }

    public String getKey() {
        return key;
    }
}