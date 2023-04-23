package org.example.day03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class GiftedHousesCalculatorTest {

    private GiftedHousesCalculator giftedHousesCalculator;

    @BeforeEach
    void setup() {
        giftedHousesCalculator = new GiftedHousesCalculator();
    }

    @ParameterizedTest
    @MethodSource("provideDataForGetHousesWithAtLeastOnePresent")
    void testGetHousesWithAtLeastOnePresent(String input, int expectedAmount) {
        int actualAmount = giftedHousesCalculator.getHousesWithAtLeastOnePresent(input);
        Assertions.assertEquals(expectedAmount, actualAmount);
    }

    private static Stream<Arguments> provideDataForGetHousesWithAtLeastOnePresent () {
        return Stream.of(
                Arguments.of(">", 2),
                Arguments.of("^>v<", 4),
                Arguments.of("^v^v^v^v^v", 2)
        );
    }

    @ParameterizedTest
    @MethodSource("provideDataForGetHousesWithAtLeastOnePresentWithRoboSanta")
    void testGetHousesWithAtLeastOnePresentWithRoboSanta(String input, int expectedAmount) {
        int actualAmount = giftedHousesCalculator.getHousesWithAtLeastOnePresentWithRoboSanta(input);
        Assertions.assertEquals(expectedAmount, actualAmount);
    }

    private static Stream<Arguments> provideDataForGetHousesWithAtLeastOnePresentWithRoboSanta() {
        return Stream.of(
                Arguments.of("^v", 3),
                Arguments.of("^>v<", 3),
                Arguments.of("^v^v^v^v^v", 11)
        );
    }
}
