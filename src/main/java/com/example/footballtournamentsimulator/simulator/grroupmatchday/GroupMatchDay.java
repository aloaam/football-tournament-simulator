package com.example.footballtournamentsimulator.simulator.grroupmatchday;

import com.example.footballtournamentsimulator.actualdata.matchday.MatchDay;
import com.example.footballtournamentsimulator.actualdata.team.Team;
import com.example.footballtournamentsimulator.actualdata.tournamentgroup.TournamentGroupName;
import lombok.Getter;


/**
 * This component holds the mathe's info for a group match-day.
 */
//TODO: Alo - see if its really useful or if its just used for the simulation.
@Getter
public class GroupMatchDay {

    private final TournamentGroupName groupName;
    private final Team match1HomeTeam;
    private final Team match1AwayTeam;
    private final Team match2HomeTeam;
    private final Team match2AwayTeam;

    public GroupMatchDay(MatchDay matchDay) {
        this.groupName = matchDay.group().getGroupName();
        this.match1HomeTeam = matchDay.match1().getHomeTeam();
        this.match1AwayTeam = matchDay.match1().getAwayTeam();
        this.match2HomeTeam = matchDay.match2().getHomeTeam();
        this.match2AwayTeam = matchDay.match2().getAwayTeam();
    }
}
