package org.example.day07;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class SignalMeasurer {
    public Map<String, Integer> measureCircuit(Map<String, Integer> results, List<String> circuit) {
        List<String> processed = new ArrayList<>(circuit.size());

        for (int i = 0; i < circuit.size(); i++) {
            String instructionLine = circuit.get(i);
            if (processed.size() != circuit.size() && i == circuit.size() - 1) {
                i = -1;
            }
            if (processed.contains(instructionLine)) continue;
            if (instructionLine.matches("\\w+ -> \\w+")) executeAssignment(instructionLine, results, processed);
            if (instructionLine.contains("AND")) executeAnd(instructionLine, results, processed);
            if (instructionLine.contains("OR")) executeOr(instructionLine, results, processed);
            if (instructionLine.contains("NOT")) executeNot(instructionLine, results, processed);
            if (instructionLine.contains("LSHIFT")) executeLShift(instructionLine, results, processed);
            if (instructionLine.contains("RSHIFT")) executeRShift(instructionLine, results, processed);
        }

        return results;
    }

    private String getTarget(String instructionLine) {
        return instructionLine.substring(instructionLine.indexOf("-> ") + 3);
    }

    private void executeAssignment(String instructionLine, Map<String, Integer> results, List<String> processed) {
        String leftSide = instructionLine.substring(0, instructionLine.indexOf(' '));
        if (leftSide.matches("\\d+")) {
            results.put(getTarget(instructionLine), Integer.parseInt(leftSide));
        } else {
            if (results.get(leftSide) == null) return;
            results.put(getTarget(instructionLine), results.get(leftSide));
        }
        processed.add(instructionLine);
    }

    private void executeAnd(String instructionLine, Map<String, Integer> results, List<String> processed) {
        String leftSide = instructionLine.substring(0, instructionLine.indexOf(' '));
        String rightSide = instructionLine.substring(instructionLine.indexOf("AND ") + 4, instructionLine.indexOf(" ->"));

        //left side is numeric
        if (leftSide.matches("\\d+") && !rightSide.matches("\\d+")) {
            if (results.get(rightSide) == null) return;
            results.put(getTarget(instructionLine), Integer.parseInt(leftSide) & results.get(rightSide));
        }
        //right side is numeric
        else if (!leftSide.matches("\\d+") && rightSide.matches("\\d+")) {
            if (results.get(leftSide) == null) return;
            results.put(getTarget(instructionLine), results.get(leftSide) & Integer.parseInt(rightSide));
        }
        //both sides are numeric
        else if (leftSide.matches("\\d+") && rightSide.matches("\\d+")) {
            results.put(getTarget(instructionLine), Integer.parseInt(leftSide) & Integer.parseInt(rightSide));
        }
        //no side is numeric
        else {
            if (results.get(leftSide) == null || results.get(rightSide) == null) return;
            int instructionResult = results.get(leftSide) & results.get(rightSide);
            results.put(getTarget(instructionLine), instructionResult);
        }
        processed.add(instructionLine);
    }

    private void executeOr(String instructionLine, Map<String, Integer> results, List<String> processed) {
        String leftSide = instructionLine.substring(0, instructionLine.indexOf(' '));
        String rightSide = instructionLine.substring(instructionLine.indexOf("OR ") + 3, instructionLine.indexOf(" ->"));

        //left side is numeric
        if (leftSide.matches("\\d+") && !rightSide.matches("\\d+")) {
            if (results.get(rightSide) == null) return;
            results.put(getTarget(instructionLine), Integer.parseInt(leftSide) | results.get(rightSide));
        }
        //right side is numeric
        else if (!leftSide.matches("\\d+") && rightSide.matches("\\d+")) {
            if (results.get(leftSide) == null) return;
            results.put(getTarget(instructionLine), results.get(leftSide) | Integer.parseInt(rightSide));
        }
        //both sides are numeric
        else if (leftSide.matches("\\d+") && rightSide.matches("\\d+")) {
            results.put(getTarget(instructionLine), Integer.parseInt(leftSide) | Integer.parseInt(rightSide));
        }
        //no side is numeric
        else {
            if (results.get(leftSide) == null || results.get(rightSide) == null) return;
            int instructionResult = results.get(leftSide) | results.get(rightSide);
            results.put(getTarget(instructionLine), instructionResult);
        }
        processed.add(instructionLine);
    }

    private void executeNot(String instructionLine, Map<String, Integer> results, List<String> processed) {
        String leftSide = instructionLine.substring(instructionLine.indexOf("NOT ") + 4, instructionLine.indexOf(' ') + 3).trim();
        if (results.get(leftSide) == null) return;
        int value = ~results.get(leftSide);
        if (value < 0) value += 65536;
        results.put(getTarget(instructionLine), value);
        processed.add(instructionLine);
    }

    private void executeLShift(String instructionLine, Map<String, Integer> results, List<String> processed) {
        String leftSide = instructionLine.substring(0, instructionLine.indexOf(' '));
        String rightSide = instructionLine.substring(instructionLine.indexOf("LSHIFT ") + 7, instructionLine.indexOf(" ->"));
        if (results.get(leftSide) == null) return;
        results.put(getTarget(instructionLine), results.get(leftSide) << Integer.parseInt(rightSide));
        processed.add(instructionLine);
    }

    private void executeRShift(String instructionLine, Map<String, Integer> results, List<String> processed) {
        String leftSide = instructionLine.substring(0, instructionLine.indexOf(' '));
        String rightSide = instructionLine.substring(instructionLine.indexOf("RSHIFT ") + 7, instructionLine.indexOf(" ->"));
        if (results.get(leftSide) == null) return;
        results.put(getTarget(instructionLine), results.get(leftSide) >> Integer.parseInt(rightSide));
        processed.add(instructionLine);
    }
}
