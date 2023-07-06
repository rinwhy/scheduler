package com.solvd.scheduler.utils;

import com.solvd.scheduler.bin.CourseSlot;
import com.solvd.scheduler.bin.Schedule;
import com.solvd.scheduler.bin.StudentGroup;
import com.solvd.scheduler.bin.Teacher;
import com.solvd.scheduler.service.CourseSlotService;
import com.solvd.scheduler.service.SchedulingService;
import com.solvd.scheduler.service.StudentGroupService;
import com.solvd.scheduler.service.TeacherService;

import java.util.Arrays;
import java.util.List;

public class TestingAuto {
    public static void main(String[] args) {
        Automation.automation(InputUtil.getInputs());

        /*TeacherService teacherService = new TeacherService();
        List<Teacher> teachers = teacherService.getAll();
        teachers.forEach(teacher -> {
            teacher.printSchedule();
        });
        StudentGroupService studentGroupService = new StudentGroupService();
        List<StudentGroup> groups = studentGroupService.getAll();
        groups.forEach(group ->{
            group.printSchedule();
        });*/
    }
}
