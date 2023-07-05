package com.solvd.scheduler.algorithm;

import com.solvd.scheduler.bin.CourseSlot;
import com.solvd.scheduler.bin.StudentGroup;
import com.solvd.scheduler.bin.Teacher;
import com.solvd.scheduler.bin.School;
import com.solvd.scheduler.bin.Subject;
import com.solvd.scheduler.service.CourseSlotService;

import java.time.DayOfWeek;

public class ScheduleGenerator {


    public static void generateSinglePattern(StudentGroup studentGroup) {

        //set the subjects of a group
        //loop through the subjects that need to be taught
        for (Subject subject : School.getSyllabus()) {
            //loop through the teachers and see which one teaches that subject
            for (Teacher teacher : School.getTeacherList()) {
                if (teacher.getSubject() == subject) {
                    //when matched check the teachers available slots
                    for (int i = 1; i <= School.getTotalPeriods(); i++) {
                        // if a class period is open for both the group and teacher then that slot will be taken by that subject
                        if (teacher.getSchedule().checkAvailability(DayOfWeek.MONDAY, i) &&
                                studentGroup.getSchedule().checkAvailability(DayOfWeek.MONDAY, i)) {
                            CourseSlot courseSlot = new CourseSlot(DayOfWeek.MONDAY, i, subject, teacher, studentGroup);

                            pushToDB(courseSlot);

                            teacher.getSchedule().setCourseSlot(courseSlot);
                            studentGroup.getSchedule().setCourseSlot(courseSlot);
                            break;
                        } else if (teacher.getSchedule().checkAvailability(DayOfWeek.TUESDAY, i) &&
                                studentGroup.getSchedule().checkAvailability(DayOfWeek.TUESDAY, i)) {
                            CourseSlot courseSlot = new CourseSlot(DayOfWeek.TUESDAY, i, subject, teacher, studentGroup);

                            pushToDB(courseSlot);

                            teacher.getSchedule().setCourseSlot(courseSlot);
                            studentGroup.getSchedule().setCourseSlot(courseSlot);
                            break;
                        } else if (teacher.getSchedule().checkAvailability(DayOfWeek.WEDNESDAY, i) &&
                                studentGroup.getSchedule().checkAvailability(DayOfWeek.WEDNESDAY, i)) {
                            CourseSlot courseSlot = new CourseSlot(DayOfWeek.WEDNESDAY, i, subject, teacher, studentGroup);

                            pushToDB(courseSlot);

                            teacher.getSchedule().setCourseSlot(courseSlot);
                            studentGroup.getSchedule().setCourseSlot(courseSlot);
                            break;
                        } else if (teacher.getSchedule().checkAvailability(DayOfWeek.THURSDAY, i) &&
                                studentGroup.getSchedule().checkAvailability(DayOfWeek.THURSDAY, i)) {
                            CourseSlot courseSlot = new CourseSlot(DayOfWeek.THURSDAY, i, subject, teacher, studentGroup);

                            pushToDB(courseSlot);

                            teacher.getSchedule().setCourseSlot(courseSlot);
                            studentGroup.getSchedule().setCourseSlot(courseSlot);
                            break;
                        } else if (teacher.getSchedule().checkAvailability(DayOfWeek.FRIDAY, i) &&
                                studentGroup.getSchedule().checkAvailability(DayOfWeek.FRIDAY, i)) {
                            CourseSlot courseSlot = new CourseSlot(DayOfWeek.FRIDAY, i, subject, teacher, studentGroup);

                            pushToDB(courseSlot);

                            teacher.getSchedule().setCourseSlot(courseSlot);
                            studentGroup.getSchedule().setCourseSlot(courseSlot);
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
                if (teacher.getSubject() == subject) {
                    //when matched check the teachers available slots
                    for (int i = 1; i <= School.getTotalPeriods(); i++) {
                        // if a class period is open for both the group and teacher on BOTH mondays and Tuesdays
                        if (teacher.getSchedule().checkAvailability(DayOfWeek.MONDAY, i) &&
                                studentGroup.getSchedule().checkAvailability(DayOfWeek.MONDAY, i) &&
                                teacher.getSchedule().checkAvailability(DayOfWeek.WEDNESDAY, i) &&
                                studentGroup.getSchedule().checkAvailability(DayOfWeek.WEDNESDAY, i)) {
                            CourseSlot courseSlot = new CourseSlot(DayOfWeek.MONDAY, i, subject, teacher, studentGroup);

                            pushToDB(courseSlot);

                            teacher.getSchedule().setCourseSlot(courseSlot);
                            studentGroup.getSchedule().setCourseSlot(courseSlot);
                            CourseSlot courseSlot2 = new CourseSlot(DayOfWeek.WEDNESDAY, i, subject, teacher, studentGroup);

                            pushToDB(courseSlot2);

                            teacher.getSchedule().setCourseSlot(courseSlot2);
                            studentGroup.getSchedule().setCourseSlot(courseSlot2);
                            break;
                        } else if (teacher.getSchedule().checkAvailability(DayOfWeek.TUESDAY, i) &&
                                studentGroup.getSchedule().checkAvailability(DayOfWeek.TUESDAY, i) &&
                                teacher.getSchedule().checkAvailability(DayOfWeek.THURSDAY, i) &&
                                studentGroup.getSchedule().checkAvailability(DayOfWeek.THURSDAY, i)) {
                            CourseSlot courseSlot = new CourseSlot(DayOfWeek.TUESDAY, i, subject, teacher, studentGroup);

                            pushToDB(courseSlot);

                            teacher.getSchedule().setCourseSlot(courseSlot);
                            studentGroup.getSchedule().setCourseSlot(courseSlot);

                            CourseSlot courseSlot2 = new CourseSlot(DayOfWeek.THURSDAY, i, subject, teacher, studentGroup);

                            pushToDB(courseSlot2);

                            teacher.getSchedule().setCourseSlot(courseSlot2);
                            studentGroup.getSchedule().setCourseSlot(courseSlot2);
                            break;
                        } else if (teacher.getSchedule().checkAvailability(DayOfWeek.FRIDAY, i) &&
                                studentGroup.getSchedule().checkAvailability(DayOfWeek.FRIDAY, i)) {
                            CourseSlot courseSlot = new CourseSlot(DayOfWeek.FRIDAY, i, subject, teacher, studentGroup);

                            pushToDB(courseSlot);

                            teacher.getSchedule().setCourseSlot(courseSlot);
                            studentGroup.getSchedule().setCourseSlot(courseSlot);
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
                if (teacher.getSubject() == subject) {
                    //when matched check the teachers available slots
                    for (int i = 1; i <= School.getTotalPeriods(); i++) {
                        // if a class period is open for both the group and teacher on BOTH mondays and Tuesdays
                        if (teacher.getSchedule().checkAvailability(DayOfWeek.MONDAY, i) &&
                                studentGroup.getSchedule().checkAvailability(DayOfWeek.MONDAY, i) &&
                                teacher.getSchedule().checkAvailability(DayOfWeek.WEDNESDAY, i) &&
                                studentGroup.getSchedule().checkAvailability(DayOfWeek.WEDNESDAY, i) &&
                                teacher.getSchedule().checkAvailability(DayOfWeek.FRIDAY, i) &&
                                studentGroup.getSchedule().checkAvailability(DayOfWeek.FRIDAY, i)) {
                            CourseSlot courseSlot = new CourseSlot(DayOfWeek.MONDAY, i, subject, teacher, studentGroup);

                            System.out.println("FROM SCHEDULE: " + courseSlot.toString());
                            pushToDB(courseSlot);

                            teacher.getSchedule().setCourseSlot(courseSlot);
                            studentGroup.getSchedule().setCourseSlot(courseSlot);

                            CourseSlot courseSlot2 = new CourseSlot(DayOfWeek.WEDNESDAY, i, subject, teacher, studentGroup);

                            System.out.println("FROM SCHEDULE: " + courseSlot2.toString());

                            pushToDB(courseSlot2);

                            teacher.getSchedule().setCourseSlot(courseSlot2);
                            studentGroup.getSchedule().setCourseSlot(courseSlot2);

                            CourseSlot courseSlot3 = new CourseSlot(DayOfWeek.FRIDAY, i, subject, teacher, studentGroup);

                            System.out.println("FROM SCHEDULE: " + courseSlot3.toString());

                            pushToDB(courseSlot3);

                            teacher.getSchedule().setCourseSlot(courseSlot3);
                            studentGroup.getSchedule().setCourseSlot(courseSlot3);
                            break;
                        } else if (teacher.getSchedule().checkAvailability(DayOfWeek.TUESDAY, i) &&
                                studentGroup.getSchedule().checkAvailability(DayOfWeek.TUESDAY, i) &&
                                teacher.getSchedule().checkAvailability(DayOfWeek.THURSDAY, i) &&
                                studentGroup.getSchedule().checkAvailability(DayOfWeek.THURSDAY, i)) {
                            CourseSlot courseSlot = new CourseSlot(DayOfWeek.TUESDAY, i, subject, teacher, studentGroup);

                            System.out.println("FROM SCHEDULE: " + courseSlot.toString());
                            pushToDB(courseSlot);

                            teacher.getSchedule().setCourseSlot(courseSlot);
                            studentGroup.getSchedule().setCourseSlot(courseSlot);

                            CourseSlot courseSlot2 = new CourseSlot(DayOfWeek.THURSDAY, i, subject, teacher, studentGroup);

                            System.out.println("FROM SCHEDULE: " + courseSlot2.toString());

                            pushToDB(courseSlot2);

                            teacher.getSchedule().setCourseSlot(courseSlot2);
                            studentGroup.getSchedule().setCourseSlot(courseSlot2);
                            break;
                        }
                    }
                }
            }
        }
    }

    private static void pushToDB(CourseSlot cs){
        CourseSlotService courseSlotService = new CourseSlotService();
        courseSlotService.insert(cs);
    }

}
