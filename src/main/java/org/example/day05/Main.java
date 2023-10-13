package org.example.day05;

import lombok.extern.slf4j.Slf4j;
import org.example.util.ResourceReader;

import java.util.List;

@Slf4j
class Main {

    public static void main(String[] args) {
        List<String> inputList = ResourceReader.readAllLinesFromResource("org/example/day05/input.txt");
        NiceStringFinder niceStringFinder = new NiceStringFinder();
        int amountOfNiceStringsPartOne = 0;
        int amountOfNiceStringsPartTwo = 0;
        for (String input : inputList) {
            if (niceStringFinder.isStringNicePartOne(input)) {
                amountOfNiceStringsPartOne++;
            }
            if (niceStringFinder.isStringNicePartTwo(input)) {
                amountOfNiceStringsPartTwo++;
            }
        }
        log.info("Amount of nice strings part one: {}", amountOfNiceStringsPartOne);
        log.info("Amount of nice strings part two: {}", amountOfNiceStringsPartTwo);
    }
}
