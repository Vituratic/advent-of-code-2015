package org.example.day02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class WrappingPaperCalculatorTest {

    private WrappingPaperCalculator wrappingPaperCalculator;

    @BeforeEach
    void setup() {
        wrappingPaperCalculator = new WrappingPaperCalculator();
    }

    @ParameterizedTest
    @MethodSource("provideGetRequiredAmountOfSquareFeet")
    void testGetRequiredAmountOfSquareFeet(int length, int width, int height, int expectedArea) {
        int actualArea = wrappingPaperCalculator.getRequiredAmountOfSquareFeet(length, width, height);
        Assertions.assertEquals(expectedArea, actualArea);
    }

    private static Stream<Arguments> provideGetRequiredAmountOfSquareFeet() {
        return Stream.of(
                Arguments.of(2, 3, 4, 58),
                Arguments.of(1, 1, 10, 43)
        );
    }
}
