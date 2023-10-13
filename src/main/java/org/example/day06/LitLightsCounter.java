package org.example.day06;

class LitLightsCounter extends LightGridInteractor {

    private static final int LIGHT_ON = 1;

    protected void applyInstruction(int x1, int x2, int y1, int y2, Instruction instruction) {
        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                switch (instruction) {
                    case TURN_ON:
                        lightGrid[x][y] = LIGHT_ON;
                        break;
                    case TURN_OFF:
                        lightGrid[x][y] = LIGHT_OFF;
                        break;
                    case TOGGLE:
                        if (lightGrid[x][y] == LIGHT_ON) {
                            lightGrid[x][y] = LIGHT_OFF;
                        } else {
                            lightGrid[x][y] = LIGHT_ON;
                        }
                        break;
                }
            }
        }
    }

    @Override
    protected int analyzeLightGrid() {
        int amountOfLitLights = 0;
        for (int x = 0; x < 1_000; x++) {
            for (int y = 0; y < 1_000; y++) {
                if (lightGrid[x][y] == LIGHT_ON) {
                    amountOfLitLights++;
                }
            }
        }
        return amountOfLitLights;
    }
}
