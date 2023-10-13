package org.example.day04;

import lombok.extern.slf4j.Slf4j;
import org.example.util.ResourceReader;

@Slf4j
public class Main {

    public static void main(String[] args) {
        String input = ResourceReader.readFromResource("org/example/day04/input.txt");
        AdventCoinMiner miner = new AdventCoinMiner();
        int lowestPositiveNumberFive = miner.findLowestPositiveNumberForAmountOfStartingZeroes(input, 5);
        log.info("Lowest positive number leading to MD5 hash starting with 00000: {}", lowestPositiveNumberFive);

        int lowestPositiveNumberSix = miner.findLowestPositiveNumberForAmountOfStartingZeroes(input, 6);
        log.info("Lowest positive number leading to MD5 hash starting with 000000: {}", lowestPositiveNumberSix);
    }
}
