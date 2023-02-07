package com.hassen.models;

public enum Orientation {

    S("SOUTH"),
    N("NORTH"),
    E("EAST"),
    W("WEAST");

    private String direction;

    Orientation(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }
}
