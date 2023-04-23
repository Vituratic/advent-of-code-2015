package org.example.day03;

import java.util.HashSet;
import java.util.Set;

class GiftedHousesCalculator {
    public int getHousesWithAtLeastOnePresent(String input) {
        Point santa = new Point(0, 0);
        Set<Point> visitedHouses = new HashSet<>();
        visitedHouses.add(new Point(santa));

        for (char character : input.toCharArray()) {
            switch (character) {
                case '>' -> santa.moveRight();
                case '<' -> santa.moveLeft();
                case '^' -> santa.moveUp();
                case 'v' -> santa.moveDown();
                default -> throw new IllegalArgumentException("Unsupported direction");
            }
            visitedHouses.add(new Point(santa));
        }

        return visitedHouses.size();
    }

    public int getHousesWithAtLeastOnePresentWithRoboSanta(String input) {
        Point santa = new Point(0, 0);
        Point roboSanta = new Point(0, 0);
        HashSet<Point> visitedHouses = new HashSet<>();
        visitedHouses.add(new Point(santa)); // robo-santa starts at the same point, so no necessity to add

        for (int i = 0; i < input.length(); i++) {
            if (i % 2 == 0) {
                movePointBasedOnDirection(input.charAt(i), santa);
                visitedHouses.add(new Point(santa));
            } else {
                movePointBasedOnDirection(input.charAt(i), roboSanta);
                visitedHouses.add(new Point(roboSanta));
            }
        }
        return visitedHouses.size();
    }

    private void movePointBasedOnDirection(char direction, Point point) {
        switch (direction) {
            case '>' -> point.moveRight();
            case '<' -> point.moveLeft();
            case '^' -> point.moveUp();
            case 'v' -> point.moveDown();
            default -> throw new IllegalArgumentException("Unsupported direction");
        }
    }
}
