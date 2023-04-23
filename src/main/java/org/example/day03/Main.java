package org.example.day03;

import lombok.extern.slf4j.Slf4j;
import org.example.util.ResourceReader;

@Slf4j
class Main {

    public static void main(String[] args) {
        String input = ResourceReader.readFromResource("org/example/day03/input.txt");
        GiftedHousesCalculator giftedHousesCalculator = new GiftedHousesCalculator();
        int housesWithAtLeastOnePresent = giftedHousesCalculator.getHousesWithAtLeastOnePresent(input);
        log.info("Houses with at least one present: {}", housesWithAtLeastOnePresent);
    }
}
