package org.example.day06;

public enum Instruction {

    TURN_OFF,
    TURN_ON,
    TOGGLE;

    public static Instruction fromInstructionLine(String instructionLine) {
        if (instructionLine.startsWith("turn off")) return TURN_OFF;
        if (instructionLine.startsWith("turn on")) return TURN_ON;
        if (instructionLine.startsWith("toggle")) return TOGGLE;
        throw new IllegalArgumentException("illegal argument: " + instructionLine);
    }
}
