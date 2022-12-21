package com.example.footballtournamentsimulator;

public enum KnockOutPhasePoints {

    ROUND_OF_16(1),
    QUARTER_FINALS(3),
    SEMI_FINALS(6),
    FINAL(9),
    CHAMPION(12);

    private int points;

    KnockOutPhasePoints(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }
}
