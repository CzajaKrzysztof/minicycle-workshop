package com.codecool.adventure;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NonPlayerCharacter {
    private String name;
    private List<String> sentences;

    public NonPlayerCharacter(String name) {
        this.name = name;
        sentences = new ArrayList<>();
    }

    public void addSentence(String sentence) {
        sentences.add(sentence);
    }

    public String talk() {
        Random rand = new Random(); 
        return sentences.get(rand.nextInt(sentences.size())); 
    }

    public String toString() {
        return name;
    }
}