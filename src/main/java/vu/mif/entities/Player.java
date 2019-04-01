package vu.mif.entities;

import java.io.Serializable;

public class Player implements Serializable {
    private String name;

    public Player() {

    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
