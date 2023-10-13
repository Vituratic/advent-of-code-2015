package org.example.day04;

import org.apache.commons.codec.digest.DigestUtils;

class AdventCoinMiner {
    public int findLowestPositiveNumberForAmountOfStartingZeroes(String secretKey, int amountOfLeadingZeroes) {
        String startingString = "0".repeat(amountOfLeadingZeroes);
        int answer = 1;
        while (true) {
            String hex = DigestUtils.md5Hex(secretKey + answer++).toUpperCase();
            if (hex.startsWith(startingString)) {
                return answer - 1;
            }
        }
    }
}
