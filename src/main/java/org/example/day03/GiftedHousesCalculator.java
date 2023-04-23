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
}
