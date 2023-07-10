package com.solvd.scheduler;

import com.solvd.scheduler.algorithm.ScheduleGenerator;
import com.solvd.scheduler.utils.Automation;
import com.solvd.scheduler.utils.InputUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private final static Logger LOGGER = LogManager.getLogger(Main.class);


    public static void main(String[] args) {

        Automation automation = new Automation();

        //GUI display Schdeule Generator
        LOGGER.info("Schedule Generator\n");

        automation.setupDB();
        ScheduleGenerator.generateMWFPattern();
//        ScheduleGenerator.generateSinglePattern();
        InputUtil.menuSelection();



    }
}
