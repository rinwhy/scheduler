package com.solvd.scheduler.utils;

import com.jakewharton.fliptables.FlipTable;
import com.solvd.scheduler.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class ScheduleOutputter {
    private final static Logger LOGGER = LogManager.getLogger(ScheduleOutputter.class);

    public static void printSchedule(String[][] values){
        String[] headers = {"Time", "Mon", "Tues", "Wed", "Thurs", "Fri"};
        LOGGER.info("\n"+FlipTable.of(headers, values));
    }
}
