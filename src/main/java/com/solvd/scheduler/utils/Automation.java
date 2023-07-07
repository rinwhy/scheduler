package com.solvd.scheduler.utils;

import com.solvd.scheduler.algorithm.ScheduleGenerator;
import com.solvd.scheduler.bin.Schedule;
import com.solvd.scheduler.bin.School;
import com.solvd.scheduler.bin.StudentGroup;
import com.solvd.scheduler.bin.Subject;
import com.solvd.scheduler.bin.Teacher;
import com.solvd.scheduler.service.CourseSlotService;
import com.solvd.scheduler.service.StudentGroupService;
import com.solvd.scheduler.service.SubjectService;
import com.solvd.scheduler.service.TeacherService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;


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
        initCourseSlots();
    }

    private void initSubjects() {
        //adding subjects to DB
        SubjectService subjectService = new SubjectService();
        List<Subject> subjects = new ArrayList<>(Arrays.asList(Subject.values()));
        if(subjectService.getNumberOfSubjects() == 0) {
            subjects.forEach(subjectService::insert);
        }
        School.getSyllabus().addAll(subjects);

    }

    private void initCourseSlots(){
        CourseSlotService courseSlotService = new CourseSlotService();
        if(courseSlotService.getNumberOfCourseSlots() !=0){
            courseSlotService.deleteAll();
        }
    }

    private void initTeachers() {
        TeacherService teacherService = new TeacherService();
        List<Teacher> teachers;


        //get input for amount of teachers
        int numTeachers = InputUtil.getAmountOfTeachers();


        //get number of teachers already in database
        int numTeachersInDB = teacherService.getNumberOfTeachers();


        //if the database has the amount of teachers user requested, retreive teacher from database
        if(numTeachers <= numTeachersInDB){
            List<Teacher> temp = new ArrayList<>();
            IntStream.rangeClosed(1,numTeachers).forEach(index ->{
                Teacher teacher = teacherService.getById(index);
                temp.add(teacher);
            });
            teachers = temp;
        }else {

            //creates and stores the extra teachers in database
            teachers = TeacherBuilder.buildTeachers(numTeachers-numTeachersInDB);
            TeacherBuilder.storeTeachersInDB(teachers);

            //retrieves teachers with DB ids
            teachers = teacherService.getAll();
        }

        teachers.forEach(teacher -> {
            teacher.setSchedule(new Schedule(School.getTotalPeriods()));
        });

        School.setTeacherList(teachers);
    }

    private void initGroups() {
        StudentGroupService studentGroupService = new StudentGroupService();
        List<StudentGroup> groups;

        //get input for amount of student groups
        int numGroups = InputUtil.getAmountOfGroups();

        //get number of groups already in database
        int numGroupsInDB = studentGroupService.getNumberOfStudentGroups();


        //if database has number groups user request, retrieve from database
        if(numGroups <= numGroupsInDB){
            List<StudentGroup> temp = new ArrayList<>();
            IntStream.rangeClosed(1,numGroups).forEach(index ->{
                temp.add(studentGroupService.getById(index));
            });
            groups = temp;
        }else {
            //creates and stores groups in database
            List<StudentGroup> groupList = StudentGroupBuilder.buildStudentGroup(numGroups-numGroupsInDB);
            StudentGroupBuilder.storeStudentGroupInDB(groupList);

            //retrieves groups with DB ids
            groups = studentGroupService.getAll();
        }

        groups.forEach(group -> {
            group.setSchedule(new Schedule(School.getTotalPeriods()));
        });
        School.setStudentGroupList(groups);
    }
}
