package com.solvd.scheduler.utils;

import com.solvd.scheduler.algorithm.ScheduleGenerator;
import com.solvd.scheduler.bin.Schedule;
import com.solvd.scheduler.bin.School;
import com.solvd.scheduler.bin.StudentGroup;
import com.solvd.scheduler.bin.Subject;
import com.solvd.scheduler.bin.Teacher;
import com.solvd.scheduler.service.StudentGroupService;
import com.solvd.scheduler.service.SubjectService;
import com.solvd.scheduler.service.TeacherService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Automation {
    public static void automation(List<Integer> inputs){
        SubjectService subjectService = new SubjectService();
        TeacherService teacherService = new TeacherService();
        StudentGroupService studentGroupService = new StudentGroupService();
        List<Subject> subjects = new ArrayList<>();
        Arrays.stream(Subject.values()).forEach(subjects::add);
        subjects.forEach(subjectService::insert);
        School.getSyllabus().addAll(subjects);

        TeacherBuilder.buildTeachers(inputs.get(0));
        StudentGroupBuilder.buildStudentGroup(inputs.get(1));
        List<Teacher> teachers = teacherService.getAll();
        teachers.forEach(teacher -> {
            teacher.setSchedule(new Schedule(School.getTotalPeriods()));
        });
        School.setTeacherList(teachers);

        List<StudentGroup> groups = studentGroupService.getAll();
        groups.forEach(group -> {
            group.setSchedule(new Schedule(School.getTotalPeriods()));
        });
        groups.forEach(ScheduleGenerator::generateMWFPattern);

        teachers.forEach(Teacher::printSchedule);
        groups.forEach(StudentGroup::printSchedule);

    }
}
