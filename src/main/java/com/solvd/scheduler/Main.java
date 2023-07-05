package com.solvd.scheduler;

import com.solvd.scheduler.bin.StudentGroup;
import com.solvd.scheduler.bin.Teacher;
import com.solvd.scheduler.algorithm.ScheduleGenerator;
import com.solvd.scheduler.bin.School;
import com.solvd.scheduler.bin.Subject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        //input our subjects that need to be taught
        List<Subject> subjects = new ArrayList<>();
        subjects.add(Subject.MATH);
        subjects.add(Subject.SCIENCE);
        subjects.add(Subject.ENGLISH);
        subjects.add(Subject.HISTORY);
        subjects.add(Subject.FOREIGN_LANGUAGE);
        subjects.add(Subject.TECHNOLOGY);
        subjects.add(Subject.ART);
        subjects.add(Subject.PHYSICAL_EDUCATION);
        School.getSyllabus().addAll(subjects);





        //create our teachers
        Teacher teacher1 = new Teacher(1, "Marie Phelps", Subject.MATH);
        Teacher teacher2 = new Teacher(2, "Zane Barlow", Subject.SCIENCE);
        Teacher teacher3 = new Teacher(3, "Katelyn Cordova", Subject.ENGLISH);
        Teacher teacher4 = new Teacher(4, "Elif Hammond", Subject.HISTORY);
        Teacher teacher5 = new Teacher(5, "Emmie Robinson", Subject.FOREIGN_LANGUAGE);
        Teacher teacher6 = new Teacher(6, "Sidney Robertson", Subject.TECHNOLOGY);
        Teacher teacher7 = new Teacher(7, "Colin Giles", Subject.ART);
        Teacher teacher8 = new Teacher(8, "Shakira Stone", Subject.PHYSICAL_EDUCATION);
        Collections.addAll(School.getTeacherList(), teacher1, teacher2, teacher3, teacher4, teacher5, teacher6, teacher7, teacher8);


        //create our groups
        StudentGroup group1 = new StudentGroup('A', 20);
        StudentGroup group2 = new StudentGroup('B', 20);
        StudentGroup group3 = new StudentGroup('C', 20);
        StudentGroup group4 = new StudentGroup('D', 20);
        StudentGroup group5 = new StudentGroup('E', 20);
        StudentGroup group6 = new StudentGroup('F', 20);
        StudentGroup group7 = new StudentGroup('G', 20);
        StudentGroup group8 = new StudentGroup('H', 20);
        StudentGroup group9 = new StudentGroup('I', 20);

//        //add the subjects to a groups syllabus
//        group1.setSyllabus(subjects);
//        group2.setSyllabus(subjects);
//        group3.setSyllabus(subjects);
//        group4.setSyllabus(subjects);
//        group5.setSyllabus(subjects);
//        group6.setSyllabus(subjects);
//        group7.setSyllabus(subjects);
//        group8.setSyllabus(subjects);
//        group9.setSyllabus(subjects);


//        //generate the single schedule
//        ScheduleGenerator.generateSinglePattern(group1);
//        ScheduleGenerator.generateSinglePattern(group2);
//        ScheduleGenerator.generateSinglePattern(group3);
//        ScheduleGenerator.generateSinglePattern(group4);
//        ScheduleGenerator.generateSinglePattern(group5);
//        ScheduleGenerator.generateSinglePattern(group6);
//        ScheduleGenerator.generateSinglePattern(group7);
//        ScheduleGenerator.generateSinglePattern(group8);
//        ScheduleGenerator.generateSinglePattern(group9);


//        //generate the double day pattern   M/W  ... T/Thur ... fri
//        ScheduleGenerator.generateDoublePattern(group1);
//        ScheduleGenerator.generateDoublePattern(group2);
//        ScheduleGenerator.generateDoublePattern(group3);
//        ScheduleGenerator.generateDoublePattern(group4);
//        ScheduleGenerator.generateDoublePattern(group5);
//        ScheduleGenerator.generateDoublePattern(group6);
//        ScheduleGenerator.generateDoublePattern(group7);
//        ScheduleGenerator.generateDoublePattern(group8);
//        ScheduleGenerator.generateDoublePattern(group9);

        //generate the MWF pattern
        ScheduleGenerator.generateMWFPattern(group1);
        ScheduleGenerator.generateMWFPattern(group2);
        ScheduleGenerator.generateMWFPattern(group3);
        ScheduleGenerator.generateMWFPattern(group4);
        ScheduleGenerator.generateMWFPattern(group5);
        ScheduleGenerator.generateMWFPattern(group6);
        ScheduleGenerator.generateMWFPattern(group7);
        ScheduleGenerator.generateMWFPattern(group8);


        group1.printSchedule();
        System.out.println("\n\n");
        group2.printSchedule();
        System.out.println("\n\n");
        group3.printSchedule();
        System.out.println("\n\n");
        group4.printSchedule();
        System.out.println("\n\n");
        group5.printSchedule();
        System.out.println("\n\n");
        group6.printSchedule();
        System.out.println("\n\n");
        group7.printSchedule();
        System.out.println("\n\n");
        group8.printSchedule();
        System.out.println("\n\n");




        System.out.println("\n_____________________________________________________________________________________________________________________\n");

        teacher1.printSchedule();
        System.out.println("\n\n");
        teacher2.printSchedule();
        System.out.println("\n\n");
        teacher3.printSchedule();
        System.out.println("\n\n");
        teacher4.printSchedule();
        System.out.println("\n\n");
        teacher5.printSchedule();
        System.out.println("\n\n");
        teacher6.printSchedule();
        System.out.println("\n\n");
        teacher7.printSchedule();
        System.out.println("\n\n");
        teacher8.printSchedule();
        System.out.println("\n\n");


    }
}
