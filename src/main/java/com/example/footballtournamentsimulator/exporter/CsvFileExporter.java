package com.example.footballtournamentsimulator.exporter;

import com.example.footballtournamentsimulator.actualdata.team.Team;
import com.example.footballtournamentsimulator.actualdata.team.TeamService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


//TODO: Alo - finish this as the example, create a class object, which will hold the value and the format.
public class CsvFileExporter {

    private final TeamService teamService;

    public CsvFileExporter(TeamService teamService) {
        this.teamService = teamService;
    }

    public File export() throws IOException {


        final File report = File.createTempFile("group_report", ".csv");
        final FileWriter writer = new FileWriter(report);


        final List<Team> teams = teamService.getTeamsGroupedByTournamentGroup();
        final CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader(
                Headers.GROUP.name(),
                Headers.TEAM.name(),
                Headers.POINTS.name());
        try (final CSVPrinter printer = new CSVPrinter(writer, csvFormat)) {
            teams.forEach(
                    team -> {
                        try {
                            printer.printRecord(
                                    team.getTournamentGroupId().getGroupName(),
                                    team.getTeamName(),
                                    team.getPoints());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
            );
            System.out.println(report.getAbsolutePath());
        }

        return null;
    }

    private enum Headers {
        GROUP,
        TEAM,
        POINTS
    }
}


