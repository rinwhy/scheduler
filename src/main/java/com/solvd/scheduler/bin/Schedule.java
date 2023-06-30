package com.solvd.scheduler.bin;

import java.time.DayOfWeek;
import java.util.HashMap;

public class Schedule {

    private final HashMap<Integer, CourseSlot> mondaySchedule = new HashMap<>();
    private final HashMap<Integer, CourseSlot> tuesdaySchedule = new HashMap<>();
    private final HashMap<Integer, CourseSlot> wednesdaySchedule = new HashMap<>();
    private final HashMap<Integer, CourseSlot> thursdaySchedule = new HashMap<>();
    private final HashMap<Integer, CourseSlot> fridaySchedule = new HashMap<>();

    private final HashMap<DayOfWeek, HashMap<Integer, CourseSlot>> mapOfAllDays = new HashMap<>();


    public Schedule(int totalPeriods) {
        for (int i = 1; i <= totalPeriods; i++) {
            mondaySchedule.put(i, new CourseSlot());
            tuesdaySchedule.put(i, new CourseSlot());
            wednesdaySchedule.put(i, new CourseSlot());
            thursdaySchedule.put(i, new CourseSlot());
            fridaySchedule.put(i, new CourseSlot());
        }
        mapOfAllDays.put(DayOfWeek.MONDAY, mondaySchedule);
        mapOfAllDays.put(DayOfWeek.TUESDAY, tuesdaySchedule);
        mapOfAllDays.put(DayOfWeek.WEDNESDAY, wednesdaySchedule);
        mapOfAllDays.put(DayOfWeek.THURSDAY, thursdaySchedule);
        mapOfAllDays.put(DayOfWeek.FRIDAY, fridaySchedule);
    }


    public boolean checkAvailability(int period, DayOfWeek day) {
        return mapOfAllDays.get(day).get(period).isSlotOpen();
    }

    public void setCourseSlot(int period, DayOfWeek day, CourseSlot courseSlot) {
        mapOfAllDays.get(day).replace(period, courseSlot);
    }

    public void printTeachersSchedule(Teacher teacher) {
        //Heading 1
        String[][] tableHeading1 = {{"Teachers Schedule"}};
        printSchedule(tableHeading1);
        //Heading 2
        String[][] tableHeading2 = {{"Name:"+ teacher.getName() , " ID: " + teacher.getId()}};
        printSchedule(tableHeading2);
        //heading 3, the days of the week
        String[][] tableHeading3 = {{"Period", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"}};
        printSchedule(tableHeading3);

        for (int i = 1; i <= School.getTotalPeriods(); i++) {
            String[][] tableData = {
                    {Integer.toString(i),
                            getSubjectName(mondaySchedule, i) + getGroupNum(mondaySchedule, i),
                            getSubjectName(tuesdaySchedule, i) + getGroupNum(tuesdaySchedule, i),
                            getSubjectName(wednesdaySchedule, i) + getGroupNum(wednesdaySchedule, i),
                            getSubjectName(thursdaySchedule, i) + getGroupNum(thursdaySchedule, i),
                            getSubjectName(fridaySchedule, i) + getGroupNum(fridaySchedule, i)
                    }};
            printSchedule(tableData);
        }
    }

    public void printStudentsSchedule(StudentGroup studentGroup) {
        //Heading 1
        String[][] tableHeading1 = {{"Students Group Schedule"}};
        printSchedule(tableHeading1);
        //Heading 2
        String[][] tableHeading2 = {{"Group ID: " + studentGroup.getId()}};
        printSchedule(tableHeading2);
        //heading 3, the days of the week
        String[][] tableHeading3 = {{"Period", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"}};
        printSchedule(tableHeading3);

        for (int i = 1; i <= School.getTotalPeriods(); i++) {
            String[][] tableData = {
                    {Integer.toString(i),
                            getSubjectName(mondaySchedule, i) + getTeacherIDNum(mondaySchedule, i),
                            getSubjectName(tuesdaySchedule, i) + getTeacherIDNum(tuesdaySchedule, i),
                            getSubjectName(wednesdaySchedule, i) + getTeacherIDNum(wednesdaySchedule, i),
                            getSubjectName(thursdaySchedule, i) + getTeacherIDNum(thursdaySchedule, i),
                            getSubjectName(fridaySchedule, i) + getTeacherIDNum(fridaySchedule, i)
                    }};
            printSchedule(tableData);
        }
    }

    public void printSchedule(String[][] tableData) {
        int numCols = tableData[0].length;

        for (String[] table : tableData) {
            for (int j = 0; j < numCols; j++) {
                System.out.printf("%-20s", table[j]);
            }
            System.out.println();
        }
    }

    private String getSubjectName(HashMap<Integer, CourseSlot> map, int i) {

        if (!map.get(i).isSlotOpen()) {
            return map.get(i).getSubject().getSubjectName();
        }
        return "------";
    }

    private String getGroupNum(HashMap<Integer, CourseSlot> map, int i) {
        if (!map.get(i).isSlotOpen()) {
            return " {class " + Integer.toString(map.get(i).getStudentGroup().getId()) + "}";
        }
        return "";
    }

    private String getTeacherIDNum(HashMap<Integer, CourseSlot> map, int i) {
        if (!map.get(i).isSlotOpen()) {
            return " {T:" + Integer.toString(map.get(i).getTeacherAssigned().getId()) + "}";
        }
        return "";
    }


}
