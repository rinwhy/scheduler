package com.solvd.scheduler.utils;

import com.solvd.scheduler.bin.Subject;
import com.solvd.scheduler.bin.Teacher;
import com.solvd.scheduler.service.SubjectService;

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
        SubjectService subjectService = new SubjectService();
        Subject temp = subjectService.getById(1);
        System.out.println(temp);

    }
}
