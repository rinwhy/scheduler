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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


/**
 * Automates the process of generating and printing schedules
 *
 * User input is used to filter for specific information
 */
public class Automation {
    private final static Logger LOGGER = LogManager.getLogger(Automation.class);


    public void setupDB(){
        initSubjects();
        initTeachers();
        initGroups();
    }

    private void initSubjects() {
        //adding subjects to DB
        SubjectService subjectService = new SubjectService();
        List<Subject> subjects = new ArrayList<>(Arrays.asList(Subject.values()));

//        List<Subject> subjects = new ArrayList<>();
//        Arrays.stream(Subject.values()).forEach(subjects::add);
        subjects.forEach(subjectService::insert);
        School.getSyllabus().addAll(subjects);
    }


    private void initTeachers() {
        TeacherService teacherService = new TeacherService();

        //get input for amount of teachers
        int numTeachers = InputUtil.getAmountOfTeachers();

        //creates and stores teachers in database
        List<Teacher> teachers = TeacherBuilder.buildTeachers(numTeachers);
        TeacherBuilder.storeTeachersInDB(teachers);

        //retrieves teachers with DB ids
        teachers = teacherService.getAll();
        teachers.forEach(teacher -> {
            teacher.setSchedule(new Schedule(School.getTotalPeriods()));
        });
        School.setTeacherList(teachers);
    }

    private void initGroups() {
        StudentGroupService studentGroupService = new StudentGroupService();

        //get input for amount of student groups
        int numGroups = InputUtil.getAmountOfGroups();

        //creates and stores groups in database
        List<StudentGroup> groupList = StudentGroupBuilder.buildStudentGroup(numGroups);
        StudentGroupBuilder.storeStudentGroupInDB(groupList);

        //retrieves groups with DB ids
        List<StudentGroup> groups = studentGroupService.getAll();
        groups.forEach(group -> {
            group.setSchedule(new Schedule(School.getTotalPeriods()));
        });
        School.setStudentGroupList(groups);
    }






//
//    public static void automation(){
//
//        if(schedule == 1){
//            if(specific == 0) {
//                teachers.forEach(Teacher::printSchedule);
//            }else{
//                teachers.get(specific-1).printSchedule();
//            }
//        }else if(schedule ==2){
//            if(specific == 0) {
//                groups.forEach(StudentGroup::printSchedule);
//            }else{
//                groups.get(specific-1).printSchedule();
//            }
//        }else {
//            teachers.forEach(Teacher::printSchedule);
//            groups.forEach(StudentGroup::printSchedule);
//        }
//
//        int terminate=1;
//        Scanner reader = new Scanner(System.in);
//        while (terminate == 1) {
//            LOGGER.info("Press 1 to get another Schedule or 2 to terminate app: ");
//            terminate = reader.nextInt();
//            while (terminate < 1 || terminate > 2) {
//                System.out.println(terminate);
//                LOGGER.info("TEST: The number inputted is invalid, Please reenter a valid number:");
//                terminate = reader.nextInt();
//            }
//            if(terminate == 1){
//                inputs = InputUtil.selectTable(inputs, reader);
//                schedule = inputs.get(2);
//                specific = inputs.get(3);
//                if(schedule == 1){
//                    if(specific == 0) {
//                        teachers.forEach(Teacher::printSchedule);
//                    }else{
//                        teachers.get(specific-1).printSchedule();
//                    }
//                }else if(schedule ==2){
//                    if(specific == 0) {
//                        groups.forEach(StudentGroup::printSchedule);
//                    }else{
//                        groups.get(specific-1).printSchedule();
//                    }
//                }else {
//                    teachers.forEach(Teacher::printSchedule);
//                    groups.forEach(StudentGroup::printSchedule);
//                }
//            }
//        }
//        reader.close();
//
//    }
}
