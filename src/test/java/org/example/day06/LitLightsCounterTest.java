package org.example.day06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class LitLightsCounterTest {

    private LitLightsCounter litLightsCounter;

    @BeforeEach
    void setup() {
        litLightsCounter = new LitLightsCounter();
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void testExamples(String instruction, int expectedAmountOfLitLights) {
        int actualAmountOfLitLights = litLightsCounter.process(List.of(instruction));
        Assertions.assertEquals(expectedAmountOfLitLights, actualAmountOfLitLights);
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
                Arguments.of("turn on 0,0 through 999,999", 1_000_000),
                Arguments.of("toggle 0,0 through 999,0", 1_000),
                Arguments.of("turn off 499,499 through 500,500", 0)
        );
    }
}
