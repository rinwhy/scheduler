package com.solvd.scheduler.utils;

import com.solvd.scheduler.bin.Schedule;
import com.solvd.scheduler.bin.School;
import com.solvd.scheduler.bin.StudentGroup;
import com.solvd.scheduler.service.StudentGroupService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;


/**
 * Provides methods for building and storing student groups
 */
public class StudentGroupBuilder {

    /**
     * Assigns an empty schedule to each student group - based on a set# of periods
     * Assigns a random number of students to each group - min 50 max 100
     * @param numGroups Used to create the amount of groups asked for by user
     */
    public static void buildStudentGroup(int numGroups){
        List<StudentGroup> groups = new ArrayList<>();
        Random rand = new Random();
        int max=30,min=10;
        IntStream.range(0,numGroups).forEach(index -> {
            StudentGroup group = new StudentGroup();
            group.setSchedule(new Schedule(School.getTotalPeriods()));
            group.setNumStudents(rand.nextInt(max - min + 1) + min);
            groups.add(group);
        });
        storeStudentGroupInDB(groups);

    }


    /**
     * Used to save each group in the list to the database
     * @param groups Groups to save
     */
    private static void storeStudentGroupInDB(List<StudentGroup> groups){
        StudentGroupService studentGroupService = new StudentGroupService();
        groups.forEach(group->{
            studentGroupService.insert(group);
        });
    }
}
