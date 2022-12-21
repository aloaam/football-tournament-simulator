package com.example.footballtournamentsimulator.actualdata.match;

/**
 * Works as config for knowing which is the max day, in the meantime I learn how to do config files.
 */
public enum MAX_MATCH_DAY {

    MAX_MATCH_DAY(6);

    private int maxMatchDay;

    MAX_MATCH_DAY(int maxMatchDay) {
        this.maxMatchDay = maxMatchDay;
    }

    public int getMaxMatchDay() {
        return maxMatchDay;
    }
}
