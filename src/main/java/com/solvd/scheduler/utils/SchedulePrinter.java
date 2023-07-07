package com.solvd.scheduler.utils;

import com.jakewharton.fliptables.FlipTable;
import com.solvd.scheduler.bin.StudentGroup;
import com.solvd.scheduler.bin.Teacher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * SchedulePrinter provides utility methods for printing schedules of teachers and student groups
 */
public class SchedulePrinter {
    private final static Logger LOGGER = LogManager.getLogger(SchedulePrinter.class);


    /**
     * Prints schedule based on the Teacher input
     *
     * @param teacher
     */
    public static void printTeacherSchedule(Teacher teacher) {
        LOGGER.info("Teachers Schedule\n");
        LOGGER.info("Name: " + teacher.getName() + "\nTeacher ID:" + teacher.getId() + "\n");
        String[] headers = {"Period", "Mon", "Tues", "Wed", "Thurs", "Fri"};
        String[][] values = teacher.getSchedule().getScheduleValues(teacher);
        LOGGER.info("\n" + FlipTable.of(headers, values)+ "\n\n");
    }

    /**
     * Prints schedule based on the StudentGroup input
     *
     * @param studentGroup
     */
    public static void printStudentSchedule(StudentGroup studentGroup) {
        LOGGER.info("Student Group Schedule\n");
        LOGGER.info("Group: " + studentGroup.getId() + "\n");
        String[] headers = {"Period", "Mon", "Tues", "Wed", "Thurs", "Fri"};
        String[][] values = studentGroup.getSchedule().getScheduleValues(studentGroup);
        LOGGER.info("\n" + FlipTable.of(headers, values) + "\n\n");
    }
}
