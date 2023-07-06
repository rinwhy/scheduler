package com.solvd.scheduler.utils;

import com.solvd.scheduler.bin.School;
import com.solvd.scheduler.bin.Subject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * InputUtil contains utility methods for retrieving user input
 *
 * Retrieves user input and performs validation to perform actions with other parts of the program
 */
public class InputUtil {
    private final static Logger LOGGER = LogManager.getLogger(InputUtil.class);

    public static List<Integer> getInputs() {
        List<Integer> inputs = new ArrayList<>();
        Scanner reader = new Scanner(System.in);
        int numTeach, numStudentsGroup, schedule, table;
        int numPeriods = School.getTotalPeriods();
        int numSubjects = Subject.values().length;
        LOGGER.info("Please enter number of Teachers (Must be at least " + numSubjects
                + " number of Teachers): ");
        numTeach = reader.nextInt();
        while (numTeach < numSubjects) {
            LOGGER.info("The number inputted is invalid, Please reenter a valid number:");
            numTeach = reader.nextInt();
        }
        inputs.add(numTeach);
        LOGGER.info("Please enter number of Student Groups (Must be 1"
                + "-" + numPeriods * 2 + " number of Student Group): ");


        // Range of student Groups, from min to max
        // (  1 > (numOfPeriods*2)
        numStudentsGroup = reader.nextInt();


        while (numStudentsGroup < 1 || numStudentsGroup > numPeriods * 2) {
            LOGGER.info("The number inputted is invalid, Please reenter a valid number:");
            numStudentsGroup = reader.nextInt();
        }
        inputs.add(numStudentsGroup);

        LOGGER.info("Please Enter 1 to see Teacher Schedule, 2 for Students Schedule, and 3 for All:");
        schedule = reader.nextInt();


        while (schedule < 1 || schedule > 3) {
            LOGGER.info("The number inputted is invalid, Please reenter a valid number:");
            schedule = reader.nextInt();
        }
        inputs.add(schedule);


        if (schedule == 1) {
            LOGGER.info("Please Enter 1-" + numTeach
                    + " for a specific Teacher Schedule or 0 for all:");
            table = reader.nextInt();
            while (table < 1 || table > numTeach) {
                LOGGER.info("The number inputted is invalid, Please reenter a valid number:");
                table = reader.nextInt();
            }
        } else if (schedule == 2) {
            LOGGER.info("Please Enter 1-" + numStudentsGroup
                    + " for a specific Student Group Schedule or 0 for all:");
            table = reader.nextInt();
            while (table < 1 || table > numStudentsGroup) {
                LOGGER.info("The number inputted is invalid, Please reenter a valid number:");
                table = reader.nextInt();
            }
        } else {
            table = -1;
        }


        inputs.add(table);
        reader.close();
        return inputs;
    }

}
