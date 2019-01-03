package com.example.a726020.marvelreader.data.entity;

public class Creators {

    private String name;
    private String role;

    public Creators(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public Creators() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return name + ", " + role;
    }
}
