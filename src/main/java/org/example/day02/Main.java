package org.example.day02;

import lombok.extern.slf4j.Slf4j;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Slf4j
class Main {

    public static void main(String[] args) throws Exception {
        URL resourceUrl = Main.class.getClassLoader().getResource("org/example/day02/input.txt");
        Path path = Paths.get(resourceUrl.toURI());
        List<String> input = Files.readAllLines(path);

        WrappingPaperCalculator wrappingPaperCalculator = new WrappingPaperCalculator();
        int totalRequiredAmountOfSquareFeet = 0;

        for (String line : input) {
            List<Integer> numbers = Arrays.stream(line.split("x")).map(Integer::parseInt).toList();
            int requiredAmountOfSquareFeet = wrappingPaperCalculator.getRequiredAmountOfSquareFeet(numbers.get(0), numbers.get(1), numbers.get(2));
            totalRequiredAmountOfSquareFeet += requiredAmountOfSquareFeet;
        }

        log.info("Total required amount of square feet: {}", totalRequiredAmountOfSquareFeet);
    }
}
