package org.example.day07;

import lombok.extern.slf4j.Slf4j;
import org.example.util.ResourceReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
class Main {

    public static void main(String[] args) {
        List<String> input = ResourceReader.readAllLinesFromResource("org/example/day07/input.txt");
        SignalMeasurer signalMeasurer = new SignalMeasurer();
        Map<String, Integer> result = signalMeasurer.measureCircuit(new HashMap<>(), input);
        int a = result.get("a");
        log.info("Signal provided to wire a: {}", a);

        result.clear();
        result.put("b", a);
        input.removeIf(line -> line.endsWith("-> b"));
        input.add(a + " -> b");
        Map<String, Integer> result2 = signalMeasurer.measureCircuit(result, input);
        log.info("New signal provided to wire a: {}", result2.get("a"));
    }
}
