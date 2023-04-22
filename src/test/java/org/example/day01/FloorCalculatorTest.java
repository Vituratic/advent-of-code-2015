package org.example.day01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FloorCalculatorTest {

    private FloorCalculator floorCalculator;

    @BeforeEach
    void setup() {
        floorCalculator = new FloorCalculator();
    }

    @ParameterizedTest
    @MethodSource("provideGetFloorData")
    void testGetFloor(String inputData, int expectedFloor) {
        int actualFloor = floorCalculator.getFloor(inputData);
        Assertions.assertEquals(expectedFloor, actualFloor);
    }

    private static Stream<Arguments> provideGetFloorData() {
        return Stream.of(
                Arguments.of("(())", 0),
                Arguments.of("()()", 0),
                Arguments.of("(((", 3),
                Arguments.of("(()(()(", 3),
                Arguments.of("))(((((", 3),
                Arguments.of("())", -1),
                Arguments.of("))(", -1),
                Arguments.of(")))", -3),
                Arguments.of(")())())", -3)
        );
    }

    @ParameterizedTest
    @MethodSource("provideGetBasementPositionData")
    void testGetBasementPosition(String inputData, int expectedFloor) {
        int actualFloor = floorCalculator.getBasementPosition(inputData);
        Assertions.assertEquals(expectedFloor, actualFloor);
    }

    private static Stream<Arguments> provideGetBasementPositionData() {
        return Stream.of(
                Arguments.of(")", 1),
                Arguments.of("()())", 5)
        );
    }

}
