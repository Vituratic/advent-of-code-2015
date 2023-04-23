package org.example.day02;

import java.util.ArrayList;
import java.util.List;

class RibbonCalculator {
    public int getRequiredRibbonLength(int length, int width, int height) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(length);
        numbers.add(width);
        numbers.add(height);
        numbers.sort(Integer::compareTo);

        int presentWrapperLength = 2 * numbers.get(0) + 2 * numbers.get(1);
        int bowLength = length * width * height;

        return presentWrapperLength + bowLength;
    }
}
