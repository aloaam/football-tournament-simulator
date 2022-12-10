package com.example.footballtournamentsimulator.match;

public enum MatchPoints {

    WIN(3),
    TIE(1);

    public final int points;

    MatchPoints(int points) {
        this.points = points;
    }
}
