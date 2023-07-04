package com.solvd.scheduler.utils;

import com.solvd.scheduler.bin.StudentGroup;
import com.solvd.scheduler.bin.Subject;
import com.solvd.scheduler.bin.Teacher;
import com.solvd.scheduler.service.StudentGroupService;
import com.solvd.scheduler.service.SubjectService;
import com.solvd.scheduler.service.TeacherService;

public class TestingServices {
    public static void main(String[] args) {

        TeacherService ts = new TeacherService();
        SubjectService ss = new SubjectService();
        StudentGroupService sgs = new StudentGroupService();


//testing Subject Service
//
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

        //Deleting from Student Group


//        //Updating a student Group
//        StudentGroup studentGroupUpdated = new StudentGroup(1, 'Z', 29);
//        sgs.update(studentGroupUpdated);


        //Get all student groups
        sgs.getAll().forEach(groups -> System.out.println(groups.toString()));
    }
}
