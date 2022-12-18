package com.example.footballtournamentsimulator.matchday;

import com.example.footballtournamentsimulator.team.Team;
import lombok.Getter;

@Getter
public class HomeAwayMatchesFromMatchDay {

    private final Team match1HomeTeam;
    private final Team match1AwayTeam;
    private final Team match2HomeTeam;
    private final Team match2AwayTeam;

    public HomeAwayMatchesFromMatchDay(MatchDay matchDay) {
        this.match1HomeTeam = matchDay.match1().getHomeTeam();
        this.match1AwayTeam = matchDay.match1().getAwayTeam();
        this.match2HomeTeam = matchDay.match2().getHomeTeam();
        this.match2AwayTeam = matchDay.match2().getAwayTeam();
    }
}
