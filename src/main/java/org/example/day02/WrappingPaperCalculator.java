package org.example.day02;

class WrappingPaperCalculator {
    public int getRequiredAmountOfSquareFeet(int length, int width, int height) {
        int firstSide = length * width;
        int secondSide = width * height;
        int thirdSide = height * length;

        int smallestSideAsSlack = Math.min(Math.min(firstSide, secondSide), thirdSide);

        int area = 2 * firstSide + 2 * secondSide + 2 * thirdSide;
        return area + smallestSideAsSlack;
    }
}
