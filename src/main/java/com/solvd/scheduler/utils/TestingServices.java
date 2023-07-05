package com.solvd.scheduler.utils;

import com.solvd.scheduler.algorithm.ScheduleGenerator;
import com.solvd.scheduler.bin.CourseSlot;
import com.solvd.scheduler.bin.Schedule;
import com.solvd.scheduler.bin.School;
import com.solvd.scheduler.bin.StudentGroup;
import com.solvd.scheduler.bin.Subject;
import com.solvd.scheduler.bin.Teacher;
import com.solvd.scheduler.service.CourseSlotService;
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

/*
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
        System.out.println("\n\n");*/

        CourseSlotService cs = new CourseSlotService();
        //List<CourseSlot> temp= cs.getByTeacherId(1);
        /*System.out.println(temp);
        List<CourseSlot> temp2 = cs.getByStudentGroupId(1);
        System.out.println(temp2);*/
        /*SchedulingService schedulingService = new SchedulingService();
        Schedule schedule = schedulingService.getByTeacherId(1);
        System.out.println(schedule.toString());
        Teacher teacher = new Teacher();
        teacher.setSchedule(schedule);
        SchedulePrinter.printTeacherSchedule(teacher);*/


        List<Subject> subjects = new ArrayList<>();
        subjects.add(Subject.MATH);
        subjects.add(Subject.SCIENCE);
        subjects.add(Subject.ENGLISH);
        subjects.add(Subject.HISTORY);
        subjects.add(Subject.FOREIGN_LANGUAGE);
        subjects.add(Subject.TECHNOLOGY);
        subjects.add(Subject.ART);
        subjects.add(Subject.PHYSICAL_EDUCATION);
        subjects.forEach(ss::insert);
        School.getSyllabus().addAll(subjects);

        TeacherService teacherService = new TeacherService();
        Teacher teacher1 = new Teacher( "Marie Phelps", Subject.MATH);
        Teacher teacher2 = new Teacher( "Zane Barlow", Subject.SCIENCE);
        Teacher teacher3 = new Teacher( "Katelyn Cordova", Subject.ENGLISH);
        Teacher teacher4 = new Teacher("Elif Hammond", Subject.HISTORY);
        Teacher teacher5 = new Teacher( "Emmie Robinson", Subject.FOREIGN_LANGUAGE);
        Teacher teacher6 = new Teacher( "Sidney Robertson", Subject.TECHNOLOGY);
        Teacher teacher7 = new Teacher( "Colin Giles", Subject.ART);
        Teacher teacher8 = new Teacher( "Shakira Stone", Subject.PHYSICAL_EDUCATION);
        Collections.addAll(School.getTeacherList(), teacher1, teacher2, teacher3, teacher4, teacher5, teacher6, teacher7, teacher8);
        School.getTeacherList().forEach(teacherService::insert);
        List<Teacher> teachers = teacherService.getAll();
        teachers.forEach(teacher -> {
            teacher.setSchedule(new Schedule(School.getTotalPeriods()));
        });
        School.setTeacherList(teachers);



        StudentGroup group1 = new StudentGroup('A', 20);
        StudentGroupService studentGroupService = new StudentGroupService();

        studentGroupService.insert(group1);

        List<StudentGroup> groups = sgs.getAll();
        groups.forEach(group -> {
            group.setSchedule(new Schedule(School.getTotalPeriods()));
        });
        ScheduleGenerator.generateMWFPattern(groups.get(0));

        CourseSlot temp = cs.getById(1);
        System.out.println("\n\n\n");
        groups.get(0).printSchedule();
        teachers.forEach(Teacher::printSchedule);
        //cs.insert(temp);


        //FROM SCHEDULE: CourseSlot{slotAssigned=false, day=MONDAY, subject=Subject{Ordinal ID=0  subjectName='Math'}, teacherAssigned=Teacher{id=0, name='Marie Phelps', subject=Subject{Ordinal ID=0  subjectName='Math'}}}
        //FROM SCHEDULE: CourseSlot{slotAssigned=false, day=WEDNESDAY, subject=Subject{Ordinal ID=0  subjectName='Math'}, teacherAssigned=Teacher{id=0, name='Marie Phelps', subject=Subject{Ordinal ID=0  subjectName='Math'}}}
        //FROM SCHEDULE: CourseSlot{slotAssigned=false, day=FRIDAY, subject=Subject{Ordinal ID=0  subjectName='Math'}, teacherAssigned=Teacher{id=0, name='Marie Phelps', subject=Subject{Ordinal ID=0  subjectName='Math'}}}


        //CourseSlot cs1 = temp.get(0);
        //cs1.setId(5);
        //cs1.setPeriod(3);
        //System.out.println(cs1);
        //cs.insert(cs1);
        //cs.update(cs1);
        //cs.deleteById(5);


    }
}
