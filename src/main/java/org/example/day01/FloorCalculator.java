package org.example.day01;

class FloorCalculator {

    public int getFloor(String inputData) {
        int result = 0;
        for (char character : inputData.toCharArray()) {
            if (character == '(') {
                result++;
            } else {
                result--;
            }
        }
        return result;
    }

    /**
     *
     * @param inputData
     * @return the position where the basement gets entered on 1-basis
     */
    public int getBasementPosition(String inputData) {
        int floor = 0;
        for (int i = 0; i < inputData.length(); i++) {
            if (inputData.charAt(i) == '(') {
                floor++;
            } else {
                floor--;
            }
            if (floor < 0) {
                return i + 1;
            }
        }
        return 0;
    }
}
