package com.solvd.scheduler.utils;

import com.github.javafaker.Faker;
import com.solvd.scheduler.bin.Schedule;
import com.solvd.scheduler.bin.School;
import com.solvd.scheduler.bin.Subject;
import com.solvd.scheduler.bin.Teacher;
import com.solvd.scheduler.service.TeacherService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

public class TeacherBuilder {
    private final static Logger LOGGER = LogManager.getLogger(TeacherBuilder.class);

    public static void buildTeachers(int numTeachers){
        List<Teacher> teachers = new ArrayList<>();
        List<Subject> subjects = Arrays.asList(Subject.values());
        IntStream.range(0,numTeachers).forEach(index -> {
            Teacher teach = new Teacher();
            Faker faker = new Faker();
            HashMap<Integer, String> ratings = new HashMap<>();
            teach.setSubject(subjects.get(index % subjects.size()));
            teach.setName(faker.name().fullName());
            teach.setSchedule(new Schedule(School.getTotalPeriods()));
            //the id should be auto incremented in sql table
            //            teach.setId(index+1);
            teachers.add(teach);

            TeacherService teacherService = new TeacherService();
            teacherService.insert(teach);

        });
        storeTeachersInDB(teachers);
        School.setTeacherList(teachers);
    }

    private static void storeTeachersInDB(List<Teacher> teachers){
        TeacherService teacherService = new TeacherService();
        teachers.forEach(teacher -> {
            teacherService.insert(teacher);
        });
    }
}
