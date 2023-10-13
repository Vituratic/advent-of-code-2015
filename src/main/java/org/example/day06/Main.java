package org.example.day06;

import lombok.extern.slf4j.Slf4j;
import org.example.util.ResourceReader;

import java.util.List;

@Slf4j
class Main {

    public static void main(String[] args) {
        List<String> input = ResourceReader.readAllLinesFromResource("org/example/day06/input.txt");
        LitLightsCounter litLightsCounter = new LitLightsCounter();
        int amountOfLitLights = litLightsCounter.process(input);
        log.info("Amount of lit lights: {}", amountOfLitLights);

        BrightnessCalculator brightnessCalculator = new BrightnessCalculator();
        int totalBrightness = brightnessCalculator.process(input);
        log.info("Total brightness: {}", totalBrightness);
    }
}
