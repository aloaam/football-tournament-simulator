package com.example.footballtournamentsimulator.matchday;

import com.example.footballtournamentsimulator.simulator.grroupmatchday.GroupMatchDay;
import com.example.footballtournamentsimulator.simulator.grroupmatchday.GroupMatchDaySimulation;
import com.example.footballtournamentsimulator.simulator.grroupmatchday.MatchWithOutcome;
import com.example.footballtournamentsimulator.simulator.simulatedteams.TeamForSimulationService;

//TODO: Alo - this component is here because i dont know yet how to inject a service into the record and/or
// because i dont know how to detach entities in JPA so that i can change them without affecting the Db.
public record GroupMatchSimulationService(TeamForSimulationService service) {

    public GroupMatchDaySimulation createFrom(GroupMatchDay matches) {
        return new GroupMatchDaySimulation(
                matches.getGroupName(),
                new MatchWithOutcome(
                        service.convertTeam(matches.getMatch1HomeTeam()),
                        service.convertTeam(matches.getMatch1AwayTeam())),
                new MatchWithOutcome(
                        service.convertTeam(matches.getMatch2HomeTeam()),
                        service.convertTeam(matches.getMatch2AwayTeam()))
        );
    }
}
