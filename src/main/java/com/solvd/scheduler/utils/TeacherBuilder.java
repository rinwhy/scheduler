package com.solvd.scheduler.utils;

import com.github.javafaker.Faker;
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

    public static List<Teacher> buildTeachers(int numTeachers){
        List<Teacher> teachers = new ArrayList<>();
        List<Subject> subjects = Arrays.asList(Subject.values());
        IntStream.range(0,numTeachers).forEach(index -> {
            Teacher teach = new Teacher();
            Faker faker = new Faker();
            HashMap<Integer, String> ratings = new HashMap<>();
            teach.setSubject(subjects.get(index % subjects.size()));
            teach.setName(faker.name().fullName());
            //the id should be auto incremented in sql table
            //            teach.setId(index+1);
            teachers.add(teach);

            TeacherService teacherService = new TeacherService();
            teacherService.insert(teach);
        });
        return teachers;
    }
}
