package org.example.day06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class BrightnessCalculatorTest {

    private final BrightnessCalculator brightnessCalculator = new BrightnessCalculator();

    @ParameterizedTest
    @MethodSource("provideArguments")
    void testExamples(String instruction, int expectedBrightness) {
        int actualBrightness = brightnessCalculator.process(List.of(instruction));
        Assertions.assertEquals(expectedBrightness, actualBrightness);
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
                Arguments.of("turn on 0,0 through 0,0", 1),
                Arguments.of("toggle 0,0 through 999,999", 2_000_000)
        );
    }
}
