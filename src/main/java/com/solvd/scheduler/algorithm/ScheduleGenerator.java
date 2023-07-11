package com.solvd.scheduler.algorithm;

import com.solvd.scheduler.bin.CourseSlot;
import com.solvd.scheduler.bin.StudentGroup;
import com.solvd.scheduler.bin.Teacher;
import com.solvd.scheduler.bin.School;
import com.solvd.scheduler.service.CourseSlotService;
import java.time.DayOfWeek;
import java.util.List;

/**
 * ScheduleGenerator class provides methods for generating schedules for student groups based on available teachers and subjects
 * Patterns supported Single, Double and MWF(Mon-Wed-Fri)
 * Schedules are stored in respective Teacher and StudentGroup tables in database
 */
public class ScheduleGenerator {

    /**
     * Generates a schedule for a student group using an MW-F (Monday-Wednesday-Friday) pattern
     * Each subject is assigned to a teacher who teaches that subject, and available slots are assigned for each course on Monday, Wednesday, and Friday
     * The generated schedule is stored in the teacher and student group objects
     * CourseSlots are stored in the database in their respective tables
     */
    public static void generateMWFPattern() {

        //for each group
        School.getStudentGroupList().forEach(studentGroup -> {
            //loop through the subjects that need to be taught
            School.getSyllabus().forEach(subject -> {
                //locate the teacher who can teach this subject
                School.getTeacherList().forEach(teacher -> {
                    if (teacher.getSubject() == subject) {
                        //build out the schedule checking for conflicts and inserting into schedule when both teacher and group are available
                        for (int i = 1; i <= School.getTotalPeriods(); i++) {
                            if (checkTeacherStudentAvailability(teacher, studentGroup, DayOfWeek.MONDAY, i) &&
                                    checkTeacherStudentAvailability(teacher, studentGroup, DayOfWeek.WEDNESDAY, i) &&
                                    checkTeacherStudentAvailability(teacher, studentGroup, DayOfWeek.FRIDAY, i)) {
                                CourseSlot courseSlot = new CourseSlot(DayOfWeek.MONDAY, i, subject, teacher, studentGroup);
                                setScheduleSlot(teacher, studentGroup, courseSlot);

                                CourseSlot courseSlot2 = new CourseSlot(DayOfWeek.WEDNESDAY, i, subject, teacher, studentGroup);
                                setScheduleSlot(teacher, studentGroup, courseSlot2);

                                CourseSlot courseSlot3 = new CourseSlot(DayOfWeek.FRIDAY, i, subject, teacher, studentGroup);
                                setScheduleSlot(teacher, studentGroup, courseSlot3);
                                break;
                            } else if (checkTeacherStudentAvailability(teacher, studentGroup, DayOfWeek.TUESDAY, i) &&
                                    checkTeacherStudentAvailability(teacher, studentGroup, DayOfWeek.THURSDAY, i)) {
                                CourseSlot courseSlot = new CourseSlot(DayOfWeek.TUESDAY, i, subject, teacher, studentGroup);
                                setScheduleSlot(teacher, studentGroup, courseSlot);

                                CourseSlot courseSlot2 = new CourseSlot(DayOfWeek.THURSDAY, i, subject, teacher, studentGroup);
                                setScheduleSlot(teacher, studentGroup, courseSlot2);
                                break;
                            }
                        }
                    }
                });
            });
        });
    }





    /**
     * Generates a schedule for a student group using a single pattern
     * Each subject is assigned to a teacher who teaches that subject, and an available slot is assigned for each course
     * The generated schedule is stored in the teacher and student group objects
     * CourseSlots are stored in their respective database table
     */
    public static void generateSinglePattern() {
        List<StudentGroup> studentGroupList = School.getStudentGroupList();
        //set the subjects of the a group
        studentGroupList.forEach(studentGroup -> {
            //loop through the subjects that need to be taught
            School.getSyllabus().forEach(subject -> {
                School.getTeacherList().forEach(teacher -> {
                    if (teacher.getSubject() == subject) {
                        for (int i = 1; i <= School.getTotalPeriods(); i++) {
                            if (checkTeacherStudentAvailability(teacher, studentGroup, DayOfWeek.MONDAY, i)) {
                                CourseSlot courseSlot = new CourseSlot(DayOfWeek.MONDAY, i, subject, teacher, studentGroup);
                                setScheduleSlot(teacher, studentGroup, courseSlot);
                                break;
                            } else if (checkTeacherStudentAvailability(teacher, studentGroup, DayOfWeek.TUESDAY, i)) {
                                CourseSlot courseSlot = new CourseSlot(DayOfWeek.TUESDAY, i, subject, teacher, studentGroup);
                                setScheduleSlot(teacher, studentGroup, courseSlot);
                                break;
                            } else if (checkTeacherStudentAvailability(teacher, studentGroup, DayOfWeek.WEDNESDAY, i)) {
                                CourseSlot courseSlot = new CourseSlot(DayOfWeek.WEDNESDAY, i, subject, teacher, studentGroup);
                                setScheduleSlot(teacher, studentGroup, courseSlot);
                                break;
                            } else if (checkTeacherStudentAvailability(teacher, studentGroup, DayOfWeek.THURSDAY, i)) {
                                CourseSlot courseSlot = new CourseSlot(DayOfWeek.THURSDAY, i, subject, teacher, studentGroup);
                                setScheduleSlot(teacher, studentGroup, courseSlot);
                                break;
                            } else if (checkTeacherStudentAvailability(teacher, studentGroup, DayOfWeek.FRIDAY, i)) {
                                CourseSlot courseSlot = new CourseSlot(DayOfWeek.FRIDAY, i, subject, teacher, studentGroup);
                                setScheduleSlot(teacher, studentGroup, courseSlot);
                                break;
                            }
                        }
                    }
                });
            });
        });
    }


    /**
     * Generates a schedule for a student group using a double pattern
     * Each subject is assigned to a teacher who teaches that subject, and available slots are assigned for each course
     * The generated schedule is stored in the teacher and student group objects
     * CourseSlots are stored in the database in their respective table
     */
    public static void generateDoublePattern() {
        List<StudentGroup> studentGroupList = School.getStudentGroupList();
        //set the subjects of the group
        studentGroupList.forEach(studentGroup -> {
            //loop through the subjects that need to be taught
            School.getSyllabus().forEach(subject -> {
                School.getTeacherList().forEach(teacher -> {
                    if (teacher.getSubject() == subject) {
                        for (int i = 1; i <= School.getTotalPeriods(); i++) {
                            if (checkTeacherStudentAvailability(teacher, studentGroup, DayOfWeek.MONDAY, i) &&
                                    checkTeacherStudentAvailability(teacher, studentGroup, DayOfWeek.WEDNESDAY, i)) {
                                CourseSlot courseSlot = new CourseSlot(DayOfWeek.MONDAY, i, subject, teacher, studentGroup);
                                setScheduleSlot(teacher, studentGroup, courseSlot);

                                CourseSlot courseSlot2 = new CourseSlot(DayOfWeek.WEDNESDAY, i, subject, teacher, studentGroup);
                                setScheduleSlot(teacher, studentGroup, courseSlot2);
                                break;
                            } else if (checkTeacherStudentAvailability(teacher, studentGroup, DayOfWeek.TUESDAY, i) &&
                                    checkTeacherStudentAvailability(teacher, studentGroup, DayOfWeek.THURSDAY, i)) {
                                CourseSlot courseSlot = new CourseSlot(DayOfWeek.TUESDAY, i, subject, teacher, studentGroup);
                                setScheduleSlot(teacher, studentGroup, courseSlot);

                                CourseSlot courseSlot2 = new CourseSlot(DayOfWeek.THURSDAY, i, subject, teacher, studentGroup);
                                setScheduleSlot(teacher, studentGroup, courseSlot2);
                                break;
                            } else if (checkTeacherStudentAvailability(teacher, studentGroup, DayOfWeek.FRIDAY, i)) {
                                CourseSlot courseSlot = new CourseSlot(DayOfWeek.FRIDAY, i, subject, teacher, studentGroup);
                                setScheduleSlot(teacher, studentGroup, courseSlot);
                                break;
                            }
                        }
                    }
                });
            });
        });
    }



    //checks if both the teacher and student are available on the given day and period
    private static boolean checkTeacherStudentAvailability(Teacher teacher, StudentGroup group, DayOfWeek day, int period) {
        return (teacher.getSchedule().checkAvailability(day, period) &&
                group.getSchedule().checkAvailability(day, period));
    }

    private static void setScheduleSlot(Teacher teacher, StudentGroup studentGroup, CourseSlot courseSlot) {
        teacher.getSchedule().setCourseSlot(courseSlot);
        studentGroup.getSchedule().setCourseSlot(courseSlot);
        insertToDB(courseSlot);
    }

    private static void insertToDB(CourseSlot cs) {
        CourseSlotService courseSlotService = new CourseSlotService();
        courseSlotService.insert(cs);
    }
}
