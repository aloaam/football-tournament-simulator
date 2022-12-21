package com.example.footballtournamentsimulator.actualdata.datagenerator;

import com.example.footballtournamentsimulator.actualdata.datagenerator.groupstage.GroupStageGenerator;
import com.example.footballtournamentsimulator.actualdata.datagenerator.knockoutstage.KnockOutMatchGenerator;
import lombok.extern.slf4j.Slf4j;

/**
 * Creates data to store in the DB.
 */
@Slf4j
public class TournamentDataGenerator implements DataGenerator {

    private final GroupStageGenerator groupStageGenerator;
    private final KnockOutMatchGenerator knockOutMatchGenerator;

    public TournamentDataGenerator(GroupStageGenerator groupStageGenerator, KnockOutMatchGenerator knockOutMatchGenerator) {
        this.groupStageGenerator = groupStageGenerator;
        this.knockOutMatchGenerator = knockOutMatchGenerator;
    }


    @Override
    public void generate() {
        log.info("Generating data in the DB...");
        groupStageGenerator.generate();
        knockOutMatchGenerator.generate();
        log.info("Data in the DB generated.");
    }

}
