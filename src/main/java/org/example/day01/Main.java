package org.example.day01;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
class Main {

    public static void main(String[] args) throws IOException, URISyntaxException {
        URL resourceUrl = Main.class.getClassLoader().getResource("org/example/day01/input.txt");
        Path path = Paths.get(resourceUrl.toURI());
        String input = Files.readString(path);

        FloorCalculator floorCalculator = new FloorCalculator();
        int floor = floorCalculator.getFloor(input);
        log.info("Floor: " + floor);
        int basementPosition = floorCalculator.getBasementPosition(input);
        log.info("Basement entered at position: " + basementPosition);
    }
}
