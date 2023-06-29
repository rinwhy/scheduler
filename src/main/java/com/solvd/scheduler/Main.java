package com.solvd.scheduler;

import com.solvd.scheduler.bin.CourseSlot;
import com.solvd.scheduler.bin.StudentGroup;
import com.solvd.scheduler.bin.Teacher;
import com.solvd.scheduler.bin.school.Subject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static final int periods = 4;

    public static void main(String[] args) {

        //create our teachers
        Teacher teacher1 = new Teacher(1, Subject.MATH);
        Teacher teacher2 = new Teacher(2, Subject.SCIENCE);
        Teacher teacher3 = new Teacher(3, Subject.ENGLISH);
        Teacher teacher4 = new Teacher(4, Subject.HISTORY);
        Teacher teacher5 = new Teacher(5, Subject.FOREIGN_LANGUAGE);
        Teacher teacher6 = new Teacher(6, Subject.TECHNOLOGY);
        Teacher teacher7 = new Teacher(7, Subject.ART);
        Teacher teacher8 = new Teacher(8, Subject.PHYSICAL_EDUCATION);

        List<Teacher> teacherList = new ArrayList<>();
        Collections.addAll(teacherList, teacher1, teacher2, teacher3, teacher4, teacher5, teacher6, teacher7, teacher8);

        //create our groups
        StudentGroup group1 = new StudentGroup(1);
        StudentGroup group2 = new StudentGroup(2);
        StudentGroup group3 = new StudentGroup(3);



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

        //add the subjects to a groups syllabus
        group1.setSyllabus(subjects);

        //set the subjects of the a group
        //loop through the subjects that need to be taught
        for (Subject subject : group1.getSyllabus()) {
            //loop through the teachers and see which one teaches that subject
            for (Teacher teacher : teacherList) {
                if (teacher.getTeachingSubject() == subject) {
                    //when matched check the teachers available slots
                    for (int i = 1; i <= periods; i++) {
                        // if a class period is open for both the group and teacher then that slot will be taken by that subject
                        if(teacher.getTeacherSchedule().checkAvailabilityMWF(i) &&
                            group1.getGroupSchedule().checkAvailabilityMWF(i)) {

                            CourseSlot courseSlot = new CourseSlot();
                            courseSlot.setSlotAssigned(true);
                            courseSlot.setSubject(subject);
                            courseSlot.setDay("MWF");
                            courseSlot.setTeacherAssigned(teacher);

                            teacher.getTeacherSchedule().setMWFCourseSlot(i,courseSlot);
                            group1.getGroupSchedule().setMWFCourseSlot(i,courseSlot);

                            break;
                        }

                        if(teacher.getTeacherSchedule().checkAvailabilityTueThur(i) &&
                                group1.getGroupSchedule().checkAvailabilityTueThur(i)) {

                            CourseSlot courseSlot = new CourseSlot();
                            courseSlot.setSlotAssigned(true);
                            courseSlot.setSubject(subject);
                            courseSlot.setDay("Tues/Thurs");
                            courseSlot.setTeacherAssigned(teacher);

                            teacher.getTeacherSchedule().setTueCourseSlot(i,courseSlot);
                            group1.getGroupSchedule().setTueCourseSlot(i,courseSlot);
                            break;
                        }
                    }
                }
            }
        }



        //add the subjects to a groups syllabus
        group2.setSyllabus(subjects);

        //set the subjects of the a group
        //loop through the subjects that need to be taught
        for (Subject subject : group2.getSyllabus()) {
            //loop through the teachers and see which one teaches that subject
            for (Teacher teacher : teacherList) {
                if (teacher.getTeachingSubject() == subject) {
                    //when matched check the teachers available slots
                    for (int i = 1; i <= periods; i++) {
                        // if a class period is open for both the group and teacher then that slot will be taken by that subject
                        if(teacher.getTeacherSchedule().checkAvailabilityMWF(i) &&
                                group2.getGroupSchedule().checkAvailabilityMWF(i)) {

                            CourseSlot courseSlot = new CourseSlot();
                            courseSlot.setSlotAssigned(true);
                            courseSlot.setSubject(subject);
                            courseSlot.setDay("MWF");
                            courseSlot.setTeacherAssigned(teacher);

                            teacher.getTeacherSchedule().setMWFCourseSlot(i,courseSlot);
                            group2.getGroupSchedule().setMWFCourseSlot(i,courseSlot);

                            break;
                        }

                        if(teacher.getTeacherSchedule().checkAvailabilityTueThur(i) &&
                                group2.getGroupSchedule().checkAvailabilityTueThur(i)) {

                            CourseSlot courseSlot = new CourseSlot();
                            courseSlot.setSlotAssigned(true);
                            courseSlot.setSubject(subject);
                            courseSlot.setDay("Tues/Thurs");
                            courseSlot.setTeacherAssigned(teacher);

                            teacher.getTeacherSchedule().setTueCourseSlot(i,courseSlot);
                            group2.getGroupSchedule().setTueCourseSlot(i,courseSlot);
                            break;
                        }
                    }
                }
            }
        }




        //add the subjects to a groups syllabus
        group3.setSyllabus(subjects);

        //set the subjects of the a group
        //loop through the subjects that need to be taught
        for (Subject subject : group3.getSyllabus()) {
            //loop through the teachers and see which one teaches that subject
            for (Teacher teacher : teacherList) {
                if (teacher.getTeachingSubject() == subject) {
                    //when matched check the teachers available slots
                    for (int i = 1; i <= periods; i++) {
                        // if a class period is open for both the group and teacher then that slot will be taken by that subject
                        if(teacher.getTeacherSchedule().checkAvailabilityMWF(i) &&
                                group3.getGroupSchedule().checkAvailabilityMWF(i)) {

                            CourseSlot courseSlot = new CourseSlot();
                            courseSlot.setSlotAssigned(true);
                            courseSlot.setSubject(subject);
                            courseSlot.setDay("MWF");
                            courseSlot.setTeacherAssigned(teacher);

                            teacher.getTeacherSchedule().setMWFCourseSlot(i,courseSlot);
                            group3.getGroupSchedule().setMWFCourseSlot(i,courseSlot);

                            break;
                        }

                        if(teacher.getTeacherSchedule().checkAvailabilityTueThur(i) &&
                                group3.getGroupSchedule().checkAvailabilityTueThur(i)) {

                            CourseSlot courseSlot = new CourseSlot();
                            courseSlot.setSlotAssigned(true);
                            courseSlot.setSubject(subject);
                            courseSlot.setDay("Tues/Thurs");
                            courseSlot.setTeacherAssigned(teacher);

                            teacher.getTeacherSchedule().setTueCourseSlot(i,courseSlot);
                            group3.getGroupSchedule().setTueCourseSlot(i,courseSlot);
                            break;
                        }
                    }
                }
            }
        }

//
//        group1.getGroupSchedule().printSchedule();
//        System.out.println("\n\n");
//        group2.getGroupSchedule().printSchedule();
//        System.out.println("\n\n");
//        group3.getGroupSchedule().printSchedule();
//        System.out.println("\n\n");

        teacher1.getTeacherSchedule().printSchedule();
        System.out.println("\n\n");
        teacher2.getTeacherSchedule().printSchedule();

        System.out.println("\n\n");
        teacher3.getTeacherSchedule().printSchedule();

        System.out.println("\n\n");
        teacher4.getTeacherSchedule().printSchedule();

        System.out.println("\n\n");
        teacher5.getTeacherSchedule().printSchedule();
        System.out.println("\n\n");
        teacher6.getTeacherSchedule().printSchedule();
        System.out.println("\n\n");
        teacher7.getTeacherSchedule().printSchedule();
        System.out.println("\n\n");
        teacher8.getTeacherSchedule().printSchedule();



    }
}