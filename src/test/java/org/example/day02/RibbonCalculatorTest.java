package org.example.day02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RibbonCalculatorTest {

    private RibbonCalculator ribbonCalculator;

    @BeforeEach
    void setup() {
        ribbonCalculator = new RibbonCalculator();
    }

    @ParameterizedTest
    @MethodSource("provideDataForGetRequiredRibbonLength")
    void testGetRequiredRibbonLength(int length, int width, int height, int expectedLength) {
        int actualLength = ribbonCalculator.getRequiredRibbonLength(length, width, height);
        Assertions.assertEquals(expectedLength, actualLength);
    }

    private static Stream<Arguments> provideDataForGetRequiredRibbonLength() {
        return Stream.of(
                Arguments.of(2, 3, 4, 34),
                Arguments.of(1, 1, 10, 14)
        );
    }
}
