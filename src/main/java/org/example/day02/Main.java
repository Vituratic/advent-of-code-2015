package org.example.day02;

import lombok.extern.slf4j.Slf4j;
import org.example.util.ResourceReader;

import java.util.Arrays;
import java.util.List;

@Slf4j
class Main {

    public static void main(String[] args) {
        List<String> input = ResourceReader.readAllLinesFromResource("org/example/day02/input.txt");

        WrappingPaperCalculator wrappingPaperCalculator = new WrappingPaperCalculator();
        RibbonCalculator ribbonCalculator = new RibbonCalculator();
        int totalRequiredAmountOfSquareFeet = 0;
        int totalRequiredAmountOfRibbon = 0;

        for (String line : input) {
            List<Integer> numbers = Arrays.stream(line.split("x")).map(Integer::parseInt).toList();
            int requiredAmountOfSquareFeet = wrappingPaperCalculator.getRequiredAmountOfSquareFeet(numbers.get(0), numbers.get(1), numbers.get(2));
            int requiredAmountOfRibbon = ribbonCalculator.getRequiredRibbonLength(numbers.get(0), numbers.get(1), numbers.get(2));
            totalRequiredAmountOfSquareFeet += requiredAmountOfSquareFeet;
            totalRequiredAmountOfRibbon += requiredAmountOfRibbon;
        }

        log.info("Total required amount of square feet: {}", totalRequiredAmountOfSquareFeet);
        log.info("Total required amount of ribbon: {}", totalRequiredAmountOfRibbon);
    }
}
