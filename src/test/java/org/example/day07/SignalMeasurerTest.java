package org.example.day07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SignalMeasurerTest {

    private final SignalMeasurer signalMeasurer = new SignalMeasurer();

    @Test
    void testExamples() {
        List<String> circuit = List.of("123 -> x", "456 -> y", "x AND y -> d", "x OR y -> e", "x LSHIFT 2 -> f", "y RSHIFT 2 -> g",
                "NOT x -> h", "NOT y -> i");
        Map<String, Integer> results = signalMeasurer.measureCircuit(new HashMap<>(), circuit);
        Assertions.assertEquals(72, results.get("d"));
        Assertions.assertEquals(507, results.get("e"));
        Assertions.assertEquals(492, results.get("f"));
        Assertions.assertEquals(114, results.get("g"));
        Assertions.assertEquals(65412, results.get("h"));
        Assertions.assertEquals(65079, results.get("i"));
        Assertions.assertEquals(123, results.get("x"));
        Assertions.assertEquals(456, results.get("y"));
    }

}