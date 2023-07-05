package com.solvd.scheduler.utils;

import com.solvd.scheduler.bin.Schedule;
import com.solvd.scheduler.bin.School;
import com.solvd.scheduler.bin.StudentGroup;
import com.solvd.scheduler.service.StudentGroupService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class StudentGroupBuilder {
    public static void buildStudentGroup(int numGroups){
        List<StudentGroup> groups = new ArrayList<>();
        Random rand = new Random();
        int max=100,min=50;
        IntStream.range(0,numGroups).forEach(index -> {
            StudentGroup group = new StudentGroup();
            group.setSchedule(new Schedule(School.getTotalPeriods()));
            group.setNumStudents(rand.nextInt(max - min + 1) + min);
            groups.add(group);
        });
        storeStudentGroupInDB(groups);

    }

    private static void storeStudentGroupInDB(List<StudentGroup> groups){
        StudentGroupService studentGroupService = new StudentGroupService();
        groups.forEach(group->{
            studentGroupService.insert(group);
        });
    }
}
