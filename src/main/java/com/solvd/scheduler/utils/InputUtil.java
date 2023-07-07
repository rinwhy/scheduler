package com.solvd.scheduler.utils;

import com.solvd.scheduler.bin.School;
import com.solvd.scheduler.bin.StudentGroup;
import com.solvd.scheduler.bin.Subject;
import com.solvd.scheduler.bin.Teacher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

/**
 * InputUtil contains utility methods for retrieving user input
 * <p>
 * Retrieves user input and performs validation to perform actions with other parts of the program
 */
public class InputUtil {

    private final static Logger LOGGER = LogManager.getLogger(InputUtil.class);
    private static final Scanner SCANNER = new Scanner(System.in);


    public static int getAmountOfTeachers() {
        int numSubjects = Subject.values().length;
        int numTeach = 0;
        int input;
        boolean loop = true;

        while (loop) {
            try{
                LOGGER.info("Please enter number of Teachers (Must be at least " + numSubjects + " number of Teachers): \n");
                input = Integer.parseInt(SCANNER.nextLine());
                if(input >= numSubjects)
                 {
                     loop = false;
                     numTeach = input;
                 } else {
                    LOGGER.info("Input must be within range\n");
                }
            } catch (NumberFormatException e) {
                LOGGER.warn("NumberFormat Exception: The input must be an int!\n");
            }
        }
        return numTeach;
    }

    public static int getAmountOfGroups() {
        int numOfPeriods = School.getTotalPeriods();
        int numOfGroups = 0;
        int input;
        boolean loop = true;

        while (loop) {
            try{
                LOGGER.info("Please enter number of Student Groups (Must be 1-" + numOfPeriods * 2 + " number of Student Groups):\n");
                input = Integer.parseInt(SCANNER.nextLine());
                if(input >= 1 && input <= numOfPeriods * 2)
                {
                    loop = false;
                    numOfGroups = input;
                } else {
                    LOGGER.info("Input must be within range\n");
                }
            } catch (NumberFormatException e) {
                LOGGER.warn("NumberFormat Exception: The input must be an int!\n");
            }
        }
        return numOfGroups;
    }


    public static void menuSelection() {

        boolean isRunning = true;
        int input;

        while (isRunning) {
            try {
                LOGGER.info("Please Enter\n 1 Print a Teacher Schedule\n " +
                        "2 Print a Student Groups Schedule \n " +
                        "3 Print All Teachers Schedules:\n " +
                        "4 Print All Student Groups Schedules:\n\n" +
                        "0 quit:\n");

                input = Integer.parseInt(SCANNER.nextLine());
                if(input >=0 && input<=4) {
                    switch (input) {
                        case 0:
                            isRunning = false;
                            break;
                        case 1:
                            getTeacherSchedule();
                                break;
                        case 2:
                            getStudentGroupSchedule();
                                break;
                        case 3:
                            School.getTeacherList().forEach(Teacher::printSchedule);
                            break;
                        case 4:
                            School.getStudentGroupList().forEach(StudentGroup::printSchedule);
                            break;
                        default:
                            break;
                    }
                }
                else {
                    LOGGER.info("Make a proper selection\n");
                }
            }catch (NumberFormatException e) {
                LOGGER.warn("NumberFormat Exception: The input must be an int!\n");
            }
        }
    }

    private static void getTeacherSchedule() {
        boolean loop = true;
        int input;

        while(loop) {
            try {
                LOGGER.info("Enter a teacher id: ");
                input = Integer.parseInt(SCANNER.nextLine());
                if (input >= 1 && input <= School.getTeacherList().size()) {
                    School.getTeacherList().get(input - 1).printSchedule();
                    loop=false;
                } else {
                    LOGGER.info("Enter a correct id\n");
                }
            } catch (NumberFormatException e) {
                LOGGER.warn("NumberFormat Exception: The input must be an int!\n");
            }
        }
    }

    private static void getStudentGroupSchedule() {
        boolean loop = true;
        int input;

        while(loop) {
            try {
                LOGGER.info("Enter a Group id: ");
                input = Integer.parseInt(SCANNER.nextLine());
                if (input >= 1 && input <= School.getStudentGroupList().size()) {
                    School.getStudentGroupList().get(input - 1).printSchedule();
                    loop=false;
                } else {
                    LOGGER.info("Enter a correct id\n");
                }
            } catch (NumberFormatException e) {
                LOGGER.warn("NumberFormat Exception: The input must be an int!\n");
            }
        }
    }


}
