package com.hassen.models;

public enum Instruction {

    D("DROITE"),
    G("GAUCHE"),
    A("AVANCER");

    private String instruction;

    Instruction( String instruction) {
        this.instruction = instruction;
    }

    public String getInstruction() {
        return instruction;
    }
}
