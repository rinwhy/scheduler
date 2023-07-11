package com.solvd.scheduler;

import com.solvd.scheduler.algorithm.ScheduleGenerator;
import com.solvd.scheduler.utils.SetUpDB;
import com.solvd.scheduler.utils.InputUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private final static Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        LOGGER.info("Schedule Generator\n");

        SetUpDB setUpDB = new SetUpDB();
        setUpDB.initialize();

        //Generate the schedule
        ScheduleGenerator.generateMWFPattern();

        //User menu for selection
        InputUtil.menuSelection();

    }
}
