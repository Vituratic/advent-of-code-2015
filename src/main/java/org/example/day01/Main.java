package org.example.day01;

import lombok.extern.slf4j.Slf4j;
import org.example.util.ResourceReader;

@Slf4j
class Main {

    public static void main(String[] args) {
        String input = ResourceReader.readFromResource("org/example/day01/input.txt");

        FloorCalculator floorCalculator = new FloorCalculator();
        int floor = floorCalculator.getFloor(input);
        log.info("Floor: " + floor);
        int basementPosition = floorCalculator.getBasementPosition(input);
        log.info("Basement entered at position: " + basementPosition);
    }
}
