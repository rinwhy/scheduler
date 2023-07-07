package com.solvd.scheduler.utils;

import com.solvd.scheduler.algorithm.ScheduleGenerator;
import com.solvd.scheduler.bin.*;
import com.solvd.scheduler.service.CourseSlotService;
import com.solvd.scheduler.service.SchedulingService;
import com.solvd.scheduler.service.StudentGroupService;
import com.solvd.scheduler.service.TeacherService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class TestingAuto {

    private final static Logger LOGGER = LogManager.getLogger(TestingAuto.class);


    public static void main(String[] args) {

    Automation automation = new Automation();

        //GUI display Schdeule Generator
        LOGGER.info("Schedule Generator\n");

        automation.setupDB();
        ScheduleGenerator.generateMWFPattern();

        InputUtil.menuSelection();

    }
}
