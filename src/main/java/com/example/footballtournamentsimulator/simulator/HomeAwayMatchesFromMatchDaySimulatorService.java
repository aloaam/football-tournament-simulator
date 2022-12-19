package com.example.footballtournamentsimulator.simulator;

import com.example.footballtournamentsimulator.matchday.HomeAwayMatchesFromMatchDay;
import com.example.footballtournamentsimulator.simulator.simulatedteams.TeamForSimulationService;

public record HomeAwayMatchesFromMatchDaySimulatorService(TeamForSimulationService service) {

    public HomeAwayMatchesFromMatchDaySimulator createFrom(HomeAwayMatchesFromMatchDay matches) {
        return new HomeAwayMatchesFromMatchDaySimulator(
                service.convertTeam(matches.getMatch1HomeTeam()),
                service.convertTeam(matches.getMatch1AwayTeam()),
                service.convertTeam(matches.getMatch2HomeTeam()),
                service.convertTeam(matches.getMatch2AwayTeam()));
    }
}
