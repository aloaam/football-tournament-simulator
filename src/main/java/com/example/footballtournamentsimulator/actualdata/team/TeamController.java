package com.example.footballtournamentsimulator.actualdata.team;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/teams")
@Slf4j
public class TeamController {


    private final TeamService service;

    public TeamController(TeamService service) {
        this.service = service;
    }

    @GetMapping
    public List<Team> getTeamsInGroups() {
        return service.getTeamsGroupedByTournamentGroup();
    }

}
