package com.solvd.scheduler.utils;

import com.solvd.scheduler.algorithm.ScheduleGenerator;
import com.solvd.scheduler.bin.School;
import com.solvd.scheduler.bin.StudentGroup;
import com.solvd.scheduler.bin.Subject;
import com.solvd.scheduler.bin.Teacher;
import com.solvd.scheduler.service.SchedulingService;
import com.solvd.scheduler.service.StudentGroupService;
import com.solvd.scheduler.service.SubjectService;
import com.solvd.scheduler.service.TeacherService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestingServices {
    public static void main(String[] args) {

        TeacherService ts = new TeacherService();
        SubjectService ss = new SubjectService();
        StudentGroupService sgs = new StudentGroupService();
        SchedulingService schedulingService = new SchedulingService();


//testing Subject Service

//        //Get Subject by ID
//        System.out.println(ss.getById(2).toString());
//        //Deleting a subject by ID
//        ss.deleteByName(Subject.MATH);
//        //inserting a Subject
//        ss.insert(Subject.MATH);
//        // get all subjects
//        ss.getAll().forEach(subject -> System.out.println(subject.toString()));



// testing Teacher Service

//        //get teacher by ID
//        System.out.println(ts.getById(1).toString());
//        //insert a teacher
//        Teacher teacherToInsert = new Teacher("Zane Barlow", Subject.SCIENCE);
//        ts.insert(teacherToInsert);
//        //delete a teacher by id
//        ts.deleteById(4);
//        //update teacher by id
//        Teacher teacherUpdated =  new Teacher(5, "Zane UPDATED", Subject.HISTORY);
//        ts.update(teacherUpdated);
//        //get all teachers
//        ts.getAll().forEach(teacher -> System.out.println(teacher.toString()));



//Testing Student Group Service

//        //Get student group by ID
//        System.out.println(sgs.getById(1).toString());
//        //Inserting into Student Group
//        StudentGroup studentGroupInsert = new StudentGroup('F', 33);
//        sgs.insert(studentGroupInsert);
//        //Deleting by group id
//        sgs.deleteById(6);
//        //Deleting by group letter
//        sgs.deleteByGroupLetter('E');
//        //Updating a student Group
//        StudentGroup studentGroupUpdated = new StudentGroup(1, 'Z', 29);
//        sgs.update(studentGroupUpdated);
//        //Get all student groups
//        sgs.getAll().forEach(groups -> System.out.println(groups.toString()));



//Testing Schedule service
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

        Teacher teacher1 = new Teacher(1, "Marie Phelps", Subject.MATH);
        Collections.addAll(School.getTeacherList(), teacher1);
        StudentGroup group1 = new StudentGroup('A', 20);
        ScheduleGenerator.generateMWFPattern(group1);




        group1.printSchedule();
        System.out.println("\n\n");
        teacher1.printSchedule();
        System.out.println("\n\n");
    }
}
