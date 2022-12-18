package com.example.footballtournamentsimulator.simulator;

import com.example.footballtournamentsimulator.matchday.HomeAwayMatchesFromMatchDay;
import com.example.footballtournamentsimulator.simulator.simulatedteams.TeamForSimulation;
import com.example.footballtournamentsimulator.simulator.simulatedteams.TeamForSimulationService;
import lombok.Getter;

@Getter
public class HomeAwayMatchesFromMatchDaySimulator {

    private final TeamForSimulation match1HomeTeam;
    private final TeamForSimulation match1AwayTeam;
    private final TeamForSimulation match2HomeTeam;
    private final TeamForSimulation match2AwayTeam;

    public HomeAwayMatchesFromMatchDaySimulator(HomeAwayMatchesFromMatchDay matches, TeamForSimulationService service) {
        this.match1HomeTeam = service.convertTeam(matches.getMatch1HomeTeam());
        this.match1AwayTeam = service.convertTeam(matches.getMatch1AwayTeam());
        this.match2HomeTeam = service.convertTeam(matches.getMatch2HomeTeam());
        this.match2AwayTeam = service.convertTeam(matches.getMatch2AwayTeam());
    }
}
