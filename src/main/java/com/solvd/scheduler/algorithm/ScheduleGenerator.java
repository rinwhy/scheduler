package com.solvd.scheduler.algorithm;

import com.solvd.scheduler.bin.CourseSlot;
import com.solvd.scheduler.bin.StudentGroup;
import com.solvd.scheduler.bin.Teacher;
import com.solvd.scheduler.bin.School;
import com.solvd.scheduler.bin.Subject;

import java.time.DayOfWeek;

public class ScheduleGenerator {


    public static void generateSinglePattern(StudentGroup studentGroup) {

        //set the subjects of the a group
        //loop through the subjects that need to be taught
        for (Subject subject : studentGroup.getSyllabus()) {
            //loop through the teachers and see which one teaches that subject
            for (Teacher teacher : School.getTeacherList()) {
                if (teacher.getTeachingSubject() == subject) {
                    //when matched check the teachers available slots
                    for (int i = 1; i <= School.getTotalPeriods(); i++) {
                        // if a class period is open for both the group and teacher then that slot will be taken by that subject
                        if (teacher.getTeacherSchedule().checkAvailability(i, DayOfWeek.MONDAY) &&
                                studentGroup.getGroupSchedule().checkAvailability(i, DayOfWeek.MONDAY)) {
                            CourseSlot courseSlot = new CourseSlot(DayOfWeek.MONDAY, i, subject, teacher, studentGroup);
                            teacher.getTeacherSchedule().setCourseSlot(i, DayOfWeek.MONDAY, courseSlot);
                            studentGroup.getGroupSchedule().setCourseSlot(i, DayOfWeek.MONDAY, courseSlot);
                            break;
                        } else if (teacher.getTeacherSchedule().checkAvailability(i, DayOfWeek.TUESDAY) &&
                                studentGroup.getGroupSchedule().checkAvailability(i, DayOfWeek.TUESDAY)) {
                            CourseSlot courseSlot = new CourseSlot(DayOfWeek.TUESDAY, i, subject, teacher, studentGroup);
                            teacher.getTeacherSchedule().setCourseSlot(i, DayOfWeek.TUESDAY, courseSlot);
                            studentGroup.getGroupSchedule().setCourseSlot(i, DayOfWeek.TUESDAY, courseSlot);
                            break;
                        } else if (teacher.getTeacherSchedule().checkAvailability(i, DayOfWeek.WEDNESDAY) &&
                                studentGroup.getGroupSchedule().checkAvailability(i, DayOfWeek.WEDNESDAY)) {
                            CourseSlot courseSlot = new CourseSlot(DayOfWeek.WEDNESDAY, i, subject, teacher, studentGroup);
                            teacher.getTeacherSchedule().setCourseSlot(i, DayOfWeek.WEDNESDAY, courseSlot);
                            studentGroup.getGroupSchedule().setCourseSlot(i, DayOfWeek.WEDNESDAY, courseSlot);
                            break;
                        } else if (teacher.getTeacherSchedule().checkAvailability(i, DayOfWeek.THURSDAY) &&
                                studentGroup.getGroupSchedule().checkAvailability(i, DayOfWeek.THURSDAY)) {
                            CourseSlot courseSlot = new CourseSlot(DayOfWeek.THURSDAY, i, subject, teacher, studentGroup);
                            teacher.getTeacherSchedule().setCourseSlot(i, DayOfWeek.THURSDAY, courseSlot);
                            studentGroup.getGroupSchedule().setCourseSlot(i, DayOfWeek.THURSDAY, courseSlot);
                            break;
                        } else if (teacher.getTeacherSchedule().checkAvailability(i, DayOfWeek.FRIDAY) &&
                                studentGroup.getGroupSchedule().checkAvailability(i, DayOfWeek.FRIDAY)) {
                            CourseSlot courseSlot = new CourseSlot(DayOfWeek.FRIDAY, i, subject, teacher, studentGroup);
                            teacher.getTeacherSchedule().setCourseSlot(i, DayOfWeek.FRIDAY, courseSlot);
                            studentGroup.getGroupSchedule().setCourseSlot(i, DayOfWeek.FRIDAY, courseSlot);
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void generateDoublePattern(StudentGroup studentGroup) {

        //set the subjects of the a group
        //loop through the subjects that need to be taught
        for (Subject subject : studentGroup.getSyllabus()) {
            //loop through the teachers and see which one teaches that subject
            for (Teacher teacher : School.getTeacherList()) {
                if (teacher.getTeachingSubject() == subject) {
                    //when matched check the teachers available slots
                    for (int i = 1; i <= School.getTotalPeriods(); i++) {
                        // if a class period is open for both the group and teacher on BOTH mondays and Tuesdays
                        if (teacher.getTeacherSchedule().checkAvailability(i, DayOfWeek.MONDAY) &&
                                studentGroup.getGroupSchedule().checkAvailability(i, DayOfWeek.MONDAY) &&
                                teacher.getTeacherSchedule().checkAvailability(i, DayOfWeek.WEDNESDAY) &&
                                studentGroup.getGroupSchedule().checkAvailability(i, DayOfWeek.WEDNESDAY)) {
                            CourseSlot courseSlot = new CourseSlot(DayOfWeek.MONDAY, i, subject, teacher, studentGroup);
                            teacher.getTeacherSchedule().setCourseSlot(i, DayOfWeek.MONDAY, courseSlot);
                            studentGroup.getGroupSchedule().setCourseSlot(i, DayOfWeek.MONDAY, courseSlot);

                            CourseSlot courseSlot2 = new CourseSlot(DayOfWeek.WEDNESDAY, i, subject, teacher, studentGroup);
                            teacher.getTeacherSchedule().setCourseSlot(i, DayOfWeek.WEDNESDAY, courseSlot2);
                            studentGroup.getGroupSchedule().setCourseSlot(i, DayOfWeek.WEDNESDAY, courseSlot2);
                            break;
                        } else if (teacher.getTeacherSchedule().checkAvailability(i, DayOfWeek.TUESDAY) &&
                                studentGroup.getGroupSchedule().checkAvailability(i, DayOfWeek.TUESDAY) &&
                                teacher.getTeacherSchedule().checkAvailability(i, DayOfWeek.THURSDAY) &&
                                studentGroup.getGroupSchedule().checkAvailability(i, DayOfWeek.THURSDAY)) {
                            CourseSlot courseSlot = new CourseSlot(DayOfWeek.TUESDAY, i, subject, teacher, studentGroup);
                            teacher.getTeacherSchedule().setCourseSlot(i, DayOfWeek.TUESDAY, courseSlot);
                            studentGroup.getGroupSchedule().setCourseSlot(i, DayOfWeek.TUESDAY, courseSlot);

                            CourseSlot courseSlot2 = new CourseSlot(DayOfWeek.THURSDAY, i, subject, teacher, studentGroup);
                            teacher.getTeacherSchedule().setCourseSlot(i, DayOfWeek.THURSDAY, courseSlot2);
                            studentGroup.getGroupSchedule().setCourseSlot(i, DayOfWeek.THURSDAY, courseSlot2);
                            break;
                        } else if (teacher.getTeacherSchedule().checkAvailability(i, DayOfWeek.FRIDAY) &&
                                studentGroup.getGroupSchedule().checkAvailability(i, DayOfWeek.FRIDAY)) {
                            CourseSlot courseSlot = new CourseSlot(DayOfWeek.FRIDAY, i, subject, teacher, studentGroup);
                            teacher.getTeacherSchedule().setCourseSlot(i, DayOfWeek.FRIDAY, courseSlot);
                            studentGroup.getGroupSchedule().setCourseSlot(i, DayOfWeek.FRIDAY, courseSlot);
                            break;
                        }
                    }
                }
            }
        }

    }

    public static void generateMWFPattern(StudentGroup studentGroup) {

        //set the subjects of the a group
        //loop through the subjects that need to be taught
        for (Subject subject : studentGroup.getSyllabus()) {
            //loop through the teachers and see which one teaches that subject
            for (Teacher teacher : School.getTeacherList()) {
                if (teacher.getTeachingSubject() == subject) {
                    //when matched check the teachers available slots
                    for (int i = 1; i <= School.getTotalPeriods(); i++) {
                        // if a class period is open for both the group and teacher on BOTH mondays and Tuesdays
                        if (teacher.getTeacherSchedule().checkAvailability(i, DayOfWeek.MONDAY) &&
                                studentGroup.getGroupSchedule().checkAvailability(i, DayOfWeek.MONDAY) &&
                                teacher.getTeacherSchedule().checkAvailability(i, DayOfWeek.WEDNESDAY) &&
                                studentGroup.getGroupSchedule().checkAvailability(i, DayOfWeek.WEDNESDAY) &&
                                teacher.getTeacherSchedule().checkAvailability(i, DayOfWeek.FRIDAY) &&
                                studentGroup.getGroupSchedule().checkAvailability(i, DayOfWeek.FRIDAY)) {
                            CourseSlot courseSlot = new CourseSlot(DayOfWeek.MONDAY, i, subject, teacher, studentGroup);
                            teacher.getTeacherSchedule().setCourseSlot(i, DayOfWeek.MONDAY, courseSlot);
                            studentGroup.getGroupSchedule().setCourseSlot(i, DayOfWeek.MONDAY, courseSlot);

                            CourseSlot courseSlot2 = new CourseSlot(DayOfWeek.WEDNESDAY, i, subject, teacher, studentGroup);
                            teacher.getTeacherSchedule().setCourseSlot(i, DayOfWeek.WEDNESDAY, courseSlot2);
                            studentGroup.getGroupSchedule().setCourseSlot(i, DayOfWeek.WEDNESDAY, courseSlot2);

                            CourseSlot courseSlot3 = new CourseSlot(DayOfWeek.FRIDAY, i, subject, teacher, studentGroup);
                            teacher.getTeacherSchedule().setCourseSlot(i, DayOfWeek.FRIDAY, courseSlot2);
                            studentGroup.getGroupSchedule().setCourseSlot(i, DayOfWeek.FRIDAY, courseSlot2);
                            break;
                        } else if (teacher.getTeacherSchedule().checkAvailability(i, DayOfWeek.TUESDAY) &&
                                studentGroup.getGroupSchedule().checkAvailability(i, DayOfWeek.TUESDAY) &&
                                teacher.getTeacherSchedule().checkAvailability(i, DayOfWeek.THURSDAY) &&
                                studentGroup.getGroupSchedule().checkAvailability(i, DayOfWeek.THURSDAY)) {
                            CourseSlot courseSlot = new CourseSlot(DayOfWeek.TUESDAY, i, subject, teacher, studentGroup);
                            teacher.getTeacherSchedule().setCourseSlot(i, DayOfWeek.TUESDAY, courseSlot);
                            studentGroup.getGroupSchedule().setCourseSlot(i, DayOfWeek.TUESDAY, courseSlot);

                            CourseSlot courseSlot2 = new CourseSlot(DayOfWeek.THURSDAY, i, subject, teacher, studentGroup);
                            teacher.getTeacherSchedule().setCourseSlot(i, DayOfWeek.THURSDAY, courseSlot2);
                            studentGroup.getGroupSchedule().setCourseSlot(i, DayOfWeek.THURSDAY, courseSlot2);
                            break;
                        }
                    }
                }
            }
        }
    }


}
