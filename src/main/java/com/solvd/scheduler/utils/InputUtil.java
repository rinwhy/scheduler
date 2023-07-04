package com.solvd.scheduler.utils;

import com.solvd.scheduler.bin.Subject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputUtil {
    private final static Logger LOGGER = LogManager.getLogger(InputUtil.class);
    public static List<Integer> getInputs(){
        List<Integer> inputs = new ArrayList<>();
        Scanner reader = new Scanner(System.in);
        int numTeach, numStudentsGroup, numPeriods;
        int numSubjects = Subject.values().length;


        LOGGER.info("Please enter number of Teachers (Must be at least " + numSubjects
                +" number of Teachers): ");
        numTeach = reader.nextInt();
        while (numTeach < numSubjects){
            LOGGER.info("The number inputted is invalid, Please reenter a valid number:" );
            numTeach = reader.nextInt();
        }
        inputs.add(numTeach);
        LOGGER.info("Please enter number of Student Groups (Must be " + numTeach
                + "-" + numTeach*4 + " number of Student Group): ");

        // Range of student Groups, from min to max
        // (  1 > (numOfPeriods*2)


        numStudentsGroup = reader.nextInt();
        while (numStudentsGroup < numTeach || numStudentsGroup > numTeach*4){
            LOGGER.info("The number inputted is invalid, Please reenter a valid number:" );
            numStudentsGroup = reader.nextInt();
        }
        inputs.add(numStudentsGroup);
        /*LOGGER.info("Please enter number of periods: " );
        numPeriods = reader.nextInt();
        while (numPeriods <1){
            LOGGER.info("The number inputted is invalid, Please reenter a valid number:" );
            numPeriods = reader.nextInt();
        }
        inputs.add(numPeriods);*/
        reader.close();
        return inputs;
    }

}
