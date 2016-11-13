package com.example.franksowah.homework2;

/**
 * Created by FrankSowah on 10/21/16.
 */

public class Player {

    private int id;
    private String name;
    private String email;


    public Player(int id, String name, String email) {
        this.id = id;
        this.email = email;
        this.name = name;
    }

    public String getId() {
        return "" + id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

}
