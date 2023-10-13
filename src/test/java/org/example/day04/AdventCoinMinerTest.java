package org.example.day04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class AdventCoinMinerTest {

    private final AdventCoinMiner miner = new AdventCoinMiner();

    @ParameterizedTest
    @MethodSource("provideArguments")
    void testMinerFromExamples(String secretKey, int expectedAnswer) {
        int actualAnswer = miner.findLowestPositiveNumberForAmountOfStartingZeroes(secretKey, 5);

        Assertions.assertEquals(expectedAnswer, actualAnswer);
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
                Arguments.of("abcdef", 609043),
                Arguments.of("pqrstuv", 1048970)
        );
    }
}
