package com.solvd.scheduler.bin;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Represents a Schedule - No Matching Entity in current database implementation
 * Holds a list of CourseSlots per day of the week
 */
public class Schedule {

    private final HashMap<DayOfWeek, List<CourseSlot>> scheduleMap = new HashMap<>();

    public Schedule(int totalPeriods) {
        scheduleMap.put(DayOfWeek.MONDAY, new ArrayList<>(totalPeriods));
        scheduleMap.put(DayOfWeek.TUESDAY, new ArrayList<>(totalPeriods));
        scheduleMap.put(DayOfWeek.WEDNESDAY, new ArrayList<>(totalPeriods));
        scheduleMap.put(DayOfWeek.THURSDAY, new ArrayList<>(totalPeriods));
        scheduleMap.put(DayOfWeek.FRIDAY, new ArrayList<>(totalPeriods));

        IntStream.rangeClosed(1, 4)
                .forEach(period -> scheduleMap.forEach((dayOfWeek, courseSlots) -> {
                    CourseSlot slot = new CourseSlot();
                    slot.setPeriod(period);
                    slot.setDay(dayOfWeek);
                    scheduleMap.get(dayOfWeek).add(slot);
                }));
        }

    /**
     * Checks if period is taken by an open/ closed CourseSlot
     *
     * @param day DayOfTheWeek object being checked for open/ closed slot
     * @param period The period intended to be checked
     * @return True if CourseSlot is open
     *         False if CourseSlot is closed
     */
    public boolean checkAvailability(DayOfWeek day, int period) {
        return scheduleMap.get(day).stream()
                .filter(courseSlot -> courseSlot.getPeriod() == period)
                .collect(Collectors.toList())
                .get(0).isSlotOpen();
    }

    /**
     * Updates a specific CourseSlot object in the scheduleMap based on the provided CourseSlot.
     *
     * @param courseSlot Slot object containing updated/ new information
     *                   Day and Period are used to filter for the CourseSlot
     *                   If no matching CourseSlot is found, no changes are made to the scheduleMap
     */
    public void setCourseSlot(CourseSlot courseSlot) {
        List<CourseSlot> newList = scheduleMap.get(courseSlot.getDay());

        newList.stream()
                .filter(slot -> slot.getPeriod() == courseSlot.getPeriod())
                .forEach(slot -> newList.set(newList.indexOf(slot), courseSlot));
    }


    /**
     * Retrieves the schedule values as a two-dimensional string array based on the provided object.
     *
     * @param <T> Intended to be either a Teacher or StudentGroup
     * @return 2D array representing values in a schedule
     *         Each row = period, Each column = DayOfTheWeek
     *         Empty 2D array is returned if params provided don't match StudentGroup or Teacher
     */
    public <T> String[][] getScheduleValues(Object obj) {
        List<List<String>> dataList = new ArrayList<>();

        if (obj instanceof Teacher) {
            for (int i = 1; i <= School.getTotalPeriods(); i++) {
                String[] tableRow =
                        {
                                Integer.toString(i),

                                getSubjectName(DayOfWeek.MONDAY, i) + getGroupID(DayOfWeek.MONDAY, i),
                                getSubjectName(DayOfWeek.TUESDAY, i) + getGroupID(DayOfWeek.TUESDAY, i),
                                getSubjectName(DayOfWeek.WEDNESDAY, i) + getGroupID(DayOfWeek.WEDNESDAY, i),
                                getSubjectName(DayOfWeek.THURSDAY, i) + getGroupID(DayOfWeek.THURSDAY, i),
                                getSubjectName(DayOfWeek.FRIDAY, i) + getGroupID(DayOfWeek.FRIDAY, i)
                        };
                dataList.add(Arrays.asList(tableRow));
            }
        } else if (obj instanceof StudentGroup) {
            for (int i = 1; i <= School.getTotalPeriods(); i++) {
                String[] tableRow =
                        {
                                Integer.toString(i),
                                getSubjectName(DayOfWeek.MONDAY, i) + getTeacherIDNum(DayOfWeek.MONDAY, i),
                                getSubjectName(DayOfWeek.TUESDAY, i) + getTeacherIDNum(DayOfWeek.TUESDAY, i),
                                getSubjectName(DayOfWeek.WEDNESDAY, i) + getTeacherIDNum(DayOfWeek.WEDNESDAY, i),
                                getSubjectName(DayOfWeek.THURSDAY, i) + getTeacherIDNum(DayOfWeek.THURSDAY, i),
                                getSubjectName(DayOfWeek.FRIDAY, i) + getTeacherIDNum(DayOfWeek.FRIDAY, i)
                        };
                dataList.add(Arrays.asList(tableRow));
            }
        }

        return listToArrayTwoDim(dataList);
    }

    private String[][] listToArrayTwoDim(List<List<String>> list) {

        int numRows = list.size();
        int numColumns = list.get(0).size();
        String[][] array = new String[numRows][numColumns];

        for (int i = 0; i < numRows; i++) {
            List<String> row = list.get(i);
            for (int j = 0; j < numColumns; j++) {
                array[i][j] = String.valueOf(row.get(j));
            }
        }
        return array;
    }

    private String getSubjectName(DayOfWeek day, int period) {

        if (!checkAvailability(day, period)) {
            return scheduleMap.get(day).stream()
                    .filter(courseSlot -> courseSlot.getPeriod() == period)
                    .collect(Collectors.toList())
                    .get(0).getSubject().name();

        } else return "------";
    }

    private String getGroupID(DayOfWeek day, int period) {
        if (!checkAvailability(day, period)) {
            return " {Group " + scheduleMap.get(day).stream()
                    .filter(courseSlot -> courseSlot.getPeriod() == period)
                    .collect(Collectors.toList())
                    .get(0).getStudentGroup().getId() + "}";
        }
        return "";
    }

    private String getTeacherIDNum(DayOfWeek day, int period) {
        if (!checkAvailability(day, period)) {
            return " {T" + scheduleMap.get(day).stream()
                    .filter(courseSlot -> courseSlot.getPeriod() == period)
                    .collect(Collectors.toList())
                    .get(0).getTeacherAssigned().getId() + "}";
        }
        return "";
    }

    public HashMap<DayOfWeek, List<CourseSlot>> getScheduleMap() {
        return scheduleMap;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "scheduleMap=" + scheduleMap +
                '}';
    }
}
