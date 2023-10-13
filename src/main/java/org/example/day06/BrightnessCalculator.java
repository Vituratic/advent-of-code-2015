package org.example.day06;

class BrightnessCalculator extends LightGridInteractor {

    @Override
    protected void applyInstruction(int x1, int x2, int y1, int y2, Instruction instruction) {
        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                switch (instruction) {
                    case TURN_ON:
                        lightGrid[x][y] += 1;
                        break;
                    case TURN_OFF:
                        lightGrid[x][y] = Math.max(lightGrid[x][y] - 1, 0);
                        break;
                    case TOGGLE:
                        lightGrid[x][y] += 2;
                        break;
                }
            }
        }
    }

    @Override
    protected int analyzeLightGrid() {
        int totalBrightness = 0;
        for (int x = 0; x < 1_000; x++) {
            for (int y = 0; y < 1_000; y++) {
                totalBrightness += lightGrid[x][y];
            }
        }
        return totalBrightness;
    }
}
