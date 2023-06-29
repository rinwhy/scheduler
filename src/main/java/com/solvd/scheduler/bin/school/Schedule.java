package com.solvd.scheduler.bin.school;

import com.solvd.scheduler.bin.CourseSlot;

import java.time.DayOfWeek;
import java.util.HashMap;

public class Schedule {


    private HashMap<Integer, CourseSlot> mwfSchedule = new HashMap<>();
    private HashMap<Integer, CourseSlot> tueThurSchedule = new HashMap<>();

    public Schedule(int periods) {
        for (int i = 1; i <= periods; i++) {
            mwfSchedule.put(i, new CourseSlot());
            tueThurSchedule.put(i, new CourseSlot());
        }
    }

    public static void printTable(String[][] tableData) {
        int numRows = tableData.length;
        int numCols = tableData[0].length;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                System.out.printf("%-20s", tableData[i][j]);
            }
            System.out.println();
        }
    }

    public boolean checkAvailabilityMWF(int period) {
        //if the teachers mwf schedule for the given class period ...
        return !mwfSchedule.get(period).isSlotAssigned();
    }

    public boolean checkAvailabilityTueThur(int period) {
        return !tueThurSchedule.get(period).isSlotAssigned();
    }

    public void setMWFCourseSlot(int classPeriod, CourseSlot courseSlot) {
        mwfSchedule.replace(classPeriod, courseSlot);
    }

    public void setTueCourseSlot(int classPeriod, CourseSlot courseSlot) {
        tueThurSchedule.replace(classPeriod, courseSlot);
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "\nmwfSchedule=" + mwfSchedule +
                "\ntueThurSchedule=" + tueThurSchedule +
                '}';
    }

    public void printSchedule() {
        String[][] tableData = {
                {"Period", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"},
                {"1 (9-10am)", getSubjectName(mwfSchedule, 1), getSubjectName(tueThurSchedule, 1), getSubjectName(mwfSchedule, 1), getSubjectName(tueThurSchedule, 1), getSubjectName(mwfSchedule, 1)},
                {"2 (10-11am)", getSubjectName(mwfSchedule, 2), getSubjectName(tueThurSchedule, 2), getSubjectName(mwfSchedule, 2), getSubjectName(tueThurSchedule, 2), getSubjectName(mwfSchedule, 2)},
                {"3 (11-12pm)", getSubjectName(mwfSchedule, 3), getSubjectName(tueThurSchedule, 3), getSubjectName(mwfSchedule, 3), getSubjectName(tueThurSchedule, 3), getSubjectName(mwfSchedule, 3)},
                {"4 (12-1pm)", getSubjectName(mwfSchedule, 4), getSubjectName(tueThurSchedule, 4), getSubjectName(mwfSchedule, 4), getSubjectName(tueThurSchedule, 4), getSubjectName(mwfSchedule, 4)}
        };

        printTable(tableData);
    }

    private String getSubjectName(HashMap<Integer, CourseSlot> map, int i) {

        if (map.get(i).isSlotAssigned()) {
            return map.get(i).getSubject().getSubjectName();
        }
        return "------";
    }


}
