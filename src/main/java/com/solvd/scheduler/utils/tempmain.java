package com.solvd.scheduler.utils;

import com.solvd.scheduler.bin.Subject;
import com.solvd.scheduler.bin.Teacher;
import com.solvd.scheduler.service.SubjectService;
import com.solvd.scheduler.service.TeacherService;

import java.util.ArrayList;
import java.util.List;

public class tempmain {
    public static void main(String[] args) {
        /*List<Integer> temp= InputUtil.getInputs();
        System.out.println(temp);
        List<Teacher> teachers;
        teachers = utils.TeacherBuilder.buildTeachers(temp.get(0));
        teachers.forEach(teacher -> {
            System.out.println(teacher.getId() + " " + teacher.getName() + " " + teacher.getTeachingSubject());
        });*/


////        testing service layer
//        SubjectService subjectService = new SubjectService();
//        subjectService.insert(Subject.ENGLISH);
//        Subject temp = subjectService.getById(3);


        TeacherService ts = new TeacherService();
        Teacher teacher1 = new Teacher(1, "Marie Phelps", Subject.MATH);

        ts.insert(teacher1);
        ts.getById(1);



    }
}
