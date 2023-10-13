package org.example.day06;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class LightGridInteractor {

    protected static final int LIGHT_OFF = 0;

    private static final int REGEX_INSTRUCTION_GROUP_INDEX = 1;
    private static final int REGEX_X1_GROUP_INDEX = 2;
    private static final int REGEX_Y1_GROUP_INDEX = 3;
    private static final int REGEX_X2_GROUP_INDEX = 4;
    private static final int REGEX_Y2_GROUP_INDEX = 5;

    protected final int[][] lightGrid = new int[1_000][1_000];

    protected int process(List<String> instructionLineList) {
        Pattern pattern = Pattern.compile("(.*?) (\\d+),(\\d+) through (\\d+),(\\d+)");
        for (String instructionLine : instructionLineList) {
            Matcher matcher = pattern.matcher(instructionLine);

            while (matcher.find()) {
                Instruction instruction = Instruction.fromInstructionLine(matcher.group(REGEX_INSTRUCTION_GROUP_INDEX));
                int x1 = Integer.parseInt(matcher.group(REGEX_X1_GROUP_INDEX));
                int y1 = Integer.parseInt(matcher.group(REGEX_Y1_GROUP_INDEX));
                int x2 = Integer.parseInt(matcher.group(REGEX_X2_GROUP_INDEX));
                int y2 = Integer.parseInt(matcher.group(REGEX_Y2_GROUP_INDEX));

                applyInstruction(x1, x2, y1, y2, instruction);
            }
        }
        return analyzeLightGrid();
    }

    protected abstract void applyInstruction(int x1, int x2, int y1, int y2, Instruction instruction);
    protected abstract int analyzeLightGrid();
}
