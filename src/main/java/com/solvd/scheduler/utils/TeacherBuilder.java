package com.solvd.scheduler.utils;

import com.github.javafaker.Faker;
import com.solvd.scheduler.bin.Schedule;
import com.solvd.scheduler.bin.School;
import com.solvd.scheduler.bin.Subject;
import com.solvd.scheduler.bin.Teacher;
import com.solvd.scheduler.service.TeacherService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Provides utility for building and storing Teachers
 */
public class TeacherBuilder {

    /**
     * Builds the desired number of Teachers, with randomly generated properties
     * Subjects are assigned in a cyclic manner based on the index
     * @param numTeachers Number of teachers to build
     */
    public static List<Teacher> buildTeachers(int numTeachers) {
        List<Teacher> teachers = new ArrayList<>();
        List<Subject> subjects = Arrays.asList(Subject.values());
        IntStream.range(0, numTeachers).forEach(index -> {
            Teacher teach = new Teacher();
            Faker faker = new Faker();
            HashMap<Integer, String> ratings = new HashMap<>();
            teach.setSubject(subjects.get(index % subjects.size()));
            teach.setName(faker.name().fullName());
            teach.setSchedule(new Schedule(School.getTotalPeriods()));
            teachers.add(teach);
        });
        return teachers;
    }


    /**
     * Loops through Teachers list and stores each to database
     * @param teachers Teachers to be stored
     */
    public static void storeTeachersInDB(List<Teacher> teachers) {
        TeacherService teacherService = new TeacherService();
        teachers.forEach(teacherService::insert);
    }
}
