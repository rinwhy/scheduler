package com.solvd.scheduler.algorithm;

import com.solvd.scheduler.bin.CourseSlot;
import com.solvd.scheduler.bin.StudentGroup;
import com.solvd.scheduler.bin.Teacher;
import com.solvd.scheduler.bin.School;
import com.solvd.scheduler.bin.Subject;

import java.time.DayOfWeek;

public class ScheduleGenerator {


    public static void generateSinglePattern(StudentGroup studentGroup) {

        //set the subjects of a group
        //loop through the subjects that need to be taught
        for (Subject subject : School.getSyllabus()) {
            //loop through the teachers and see which one teaches that subject
            for (Teacher teacher : School.getTeacherList()) {
                if (teacher.getTeachingSubject() == subject) {
                    //when matched check the teachers available slots
                    for (int i = 1; i <= School.getTotalPeriods(); i++) {
                        // if a class period is open for both the group and teacher then that slot will be taken by that subject
                        if (teacher.getTeacherSchedule().checkAvailability(DayOfWeek.MONDAY, i) &&
                                studentGroup.getGroupSchedule().checkAvailability(DayOfWeek.MONDAY, i)) {
                            CourseSlot courseSlot = new CourseSlot(DayOfWeek.MONDAY, i, subject, teacher, studentGroup);
                            teacher.getTeacherSchedule().setCourseSlot(courseSlot);
                            studentGroup.getGroupSchedule().setCourseSlot(courseSlot);
                            break;
                        } else if (teacher.getTeacherSchedule().checkAvailability(DayOfWeek.TUESDAY, i) &&
                                studentGroup.getGroupSchedule().checkAvailability(DayOfWeek.TUESDAY, i)) {
                            CourseSlot courseSlot = new CourseSlot(DayOfWeek.TUESDAY, i, subject, teacher, studentGroup);
                            teacher.getTeacherSchedule().setCourseSlot(courseSlot);
                            studentGroup.getGroupSchedule().setCourseSlot(courseSlot);
                            break;
                        } else if (teacher.getTeacherSchedule().checkAvailability(DayOfWeek.WEDNESDAY, i) &&
                                studentGroup.getGroupSchedule().checkAvailability(DayOfWeek.WEDNESDAY, i)) {
                            CourseSlot courseSlot = new CourseSlot(DayOfWeek.WEDNESDAY, i, subject, teacher, studentGroup);
                            teacher.getTeacherSchedule().setCourseSlot(courseSlot);
                            studentGroup.getGroupSchedule().setCourseSlot(courseSlot);
                            break;
                        } else if (teacher.getTeacherSchedule().checkAvailability(DayOfWeek.THURSDAY, i) &&
                                studentGroup.getGroupSchedule().checkAvailability(DayOfWeek.THURSDAY, i)) {
                            CourseSlot courseSlot = new CourseSlot(DayOfWeek.THURSDAY, i, subject, teacher, studentGroup);
                            teacher.getTeacherSchedule().setCourseSlot(courseSlot);
                            studentGroup.getGroupSchedule().setCourseSlot(courseSlot);
                            break;
                        } else if (teacher.getTeacherSchedule().checkAvailability(DayOfWeek.FRIDAY, i) &&
                                studentGroup.getGroupSchedule().checkAvailability(DayOfWeek.FRIDAY, i)) {
                            CourseSlot courseSlot = new CourseSlot(DayOfWeek.FRIDAY, i, subject, teacher, studentGroup);
                            teacher.getTeacherSchedule().setCourseSlot(courseSlot);
                            studentGroup.getGroupSchedule().setCourseSlot(courseSlot);
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
        for (Subject subject : School.getSyllabus()) {
            //loop through the teachers and see which one teaches that subject
            for (Teacher teacher : School.getTeacherList()) {
                if (teacher.getTeachingSubject() == subject) {
                    //when matched check the teachers available slots
                    for (int i = 1; i <= School.getTotalPeriods(); i++) {
                        // if a class period is open for both the group and teacher on BOTH mondays and Tuesdays
                        if (teacher.getTeacherSchedule().checkAvailability(DayOfWeek.MONDAY, i) &&
                                studentGroup.getGroupSchedule().checkAvailability(DayOfWeek.MONDAY, i) &&
                                teacher.getTeacherSchedule().checkAvailability(DayOfWeek.WEDNESDAY, i) &&
                                studentGroup.getGroupSchedule().checkAvailability(DayOfWeek.WEDNESDAY, i)) {
                            CourseSlot courseSlot = new CourseSlot(DayOfWeek.MONDAY, i, subject, teacher, studentGroup);
                            teacher.getTeacherSchedule().setCourseSlot(courseSlot);
                            studentGroup.getGroupSchedule().setCourseSlot(courseSlot);

                            CourseSlot courseSlot2 = new CourseSlot(DayOfWeek.WEDNESDAY, i, subject, teacher, studentGroup);
                            teacher.getTeacherSchedule().setCourseSlot(courseSlot2);
                            studentGroup.getGroupSchedule().setCourseSlot(courseSlot2);
                            break;
                        } else if (teacher.getTeacherSchedule().checkAvailability(DayOfWeek.TUESDAY, i) &&
                                studentGroup.getGroupSchedule().checkAvailability(DayOfWeek.TUESDAY, i) &&
                                teacher.getTeacherSchedule().checkAvailability(DayOfWeek.THURSDAY, i) &&
                                studentGroup.getGroupSchedule().checkAvailability(DayOfWeek.THURSDAY, i)) {
                            CourseSlot courseSlot = new CourseSlot(DayOfWeek.TUESDAY, i, subject, teacher, studentGroup);
                            teacher.getTeacherSchedule().setCourseSlot(courseSlot);
                            studentGroup.getGroupSchedule().setCourseSlot(courseSlot);

                            CourseSlot courseSlot2 = new CourseSlot(DayOfWeek.THURSDAY, i, subject, teacher, studentGroup);
                            teacher.getTeacherSchedule().setCourseSlot(courseSlot2);
                            studentGroup.getGroupSchedule().setCourseSlot(courseSlot2);
                            break;
                        } else if (teacher.getTeacherSchedule().checkAvailability(DayOfWeek.FRIDAY, i) &&
                                studentGroup.getGroupSchedule().checkAvailability(DayOfWeek.FRIDAY, i)) {
                            CourseSlot courseSlot = new CourseSlot(DayOfWeek.FRIDAY, i, subject, teacher, studentGroup);
                            teacher.getTeacherSchedule().setCourseSlot(courseSlot);
                            studentGroup.getGroupSchedule().setCourseSlot(courseSlot);
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
        for (Subject subject : School.getSyllabus()) {
            //loop through the teachers and see which one teaches that subject
            for (Teacher teacher : School.getTeacherList()) {
                if (teacher.getTeachingSubject() == subject) {
                    //when matched check the teachers available slots
                    for (int i = 1; i <= School.getTotalPeriods(); i++) {
                        // if a class period is open for both the group and teacher on BOTH mondays and Tuesdays
                        if (teacher.getTeacherSchedule().checkAvailability(DayOfWeek.MONDAY, i) &&
                                studentGroup.getGroupSchedule().checkAvailability(DayOfWeek.MONDAY, i) &&
                                teacher.getTeacherSchedule().checkAvailability(DayOfWeek.WEDNESDAY, i) &&
                                studentGroup.getGroupSchedule().checkAvailability(DayOfWeek.WEDNESDAY, i) &&
                                teacher.getTeacherSchedule().checkAvailability(DayOfWeek.FRIDAY, i) &&
                                studentGroup.getGroupSchedule().checkAvailability(DayOfWeek.FRIDAY, i)) {
                            CourseSlot courseSlot = new CourseSlot(DayOfWeek.MONDAY, i, subject, teacher, studentGroup);
                            teacher.getTeacherSchedule().setCourseSlot(courseSlot);
                            studentGroup.getGroupSchedule().setCourseSlot(courseSlot);

                            CourseSlot courseSlot2 = new CourseSlot(DayOfWeek.WEDNESDAY, i, subject, teacher, studentGroup);
                            teacher.getTeacherSchedule().setCourseSlot(courseSlot2);
                            studentGroup.getGroupSchedule().setCourseSlot(courseSlot2);

                            CourseSlot courseSlot3 = new CourseSlot(DayOfWeek.FRIDAY, i, subject, teacher, studentGroup);
                            teacher.getTeacherSchedule().setCourseSlot(courseSlot3);
                            studentGroup.getGroupSchedule().setCourseSlot(courseSlot3);
                            break;
                        } else if (teacher.getTeacherSchedule().checkAvailability(DayOfWeek.TUESDAY, i) &&
                                studentGroup.getGroupSchedule().checkAvailability(DayOfWeek.TUESDAY, i) &&
                                teacher.getTeacherSchedule().checkAvailability(DayOfWeek.THURSDAY, i) &&
                                studentGroup.getGroupSchedule().checkAvailability(DayOfWeek.THURSDAY, i)) {
                            CourseSlot courseSlot = new CourseSlot(DayOfWeek.TUESDAY, i, subject, teacher, studentGroup);
                            teacher.getTeacherSchedule().setCourseSlot(courseSlot);
                            studentGroup.getGroupSchedule().setCourseSlot(courseSlot);

                            CourseSlot courseSlot2 = new CourseSlot(DayOfWeek.THURSDAY, i, subject, teacher, studentGroup);
                            teacher.getTeacherSchedule().setCourseSlot(courseSlot2);
                            studentGroup.getGroupSchedule().setCourseSlot(courseSlot2);
                            break;
                        }
                    }
                }
            }
        }
    }


}
