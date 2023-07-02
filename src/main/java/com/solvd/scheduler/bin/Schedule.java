package com.solvd.scheduler.bin;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Schedule {

    private final HashMap<DayOfWeek, List<CourseSlot>> scheduleMap = new HashMap<>();


    public Schedule(int totalPeriods) {
        scheduleMap.put(DayOfWeek.MONDAY, new ArrayList<>(totalPeriods));
        scheduleMap.put(DayOfWeek.TUESDAY, new ArrayList<>(totalPeriods));
        scheduleMap.put(DayOfWeek.WEDNESDAY, new ArrayList<>(totalPeriods));
        scheduleMap.put(DayOfWeek.THURSDAY, new ArrayList<>(totalPeriods));
        scheduleMap.put(DayOfWeek.FRIDAY, new ArrayList<>(totalPeriods));

        for (int i = 1; i <= 4; i++) {
            int period = i;
            scheduleMap.forEach((dayOfWeek, courseSlots) -> {
                CourseSlot slot = new CourseSlot();
                slot.setPeriod(period);
                slot.setDay(dayOfWeek);
                scheduleMap.get(dayOfWeek).add(slot);
            });
        }
    }


    public boolean checkAvailability(DayOfWeek day, int period) {

        return scheduleMap.get(day).stream()
                .filter(courseSlot -> courseSlot.getPeriod() == period)
                .collect(Collectors.toList())
                .get(0).isSlotOpen();
    }

    public void setCourseSlot(CourseSlot courseSlot) {
        List<CourseSlot> newList = scheduleMap.get(courseSlot.getDay());
        for (int i = 0; i < newList.size(); i++) {
            if (newList.get(i).getPeriod() == courseSlot.getPeriod()) {
                newList.set(i, courseSlot);
                break;
            }
        }
    }

    public void printTeachersSchedule(Teacher teacher) {
        //Heading 1
        String[][] tableHeading1 = {{"Teachers Schedule"}};
        printSchedule(tableHeading1);
        //Heading 2
        String[][] tableHeading2 = {{"Name:" + teacher.getName(), " ID: " + teacher.getId()}};
        printSchedule(tableHeading2);
        //heading 3, the days of the week
        String[][] tableHeading3 = {{"Period", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"}};
        printSchedule(tableHeading3);

        for (int i = 1; i <= School.getTotalPeriods(); i++) {
            String[][] tableData = {
                    {Integer.toString(i),
                            getSubjectName(DayOfWeek.MONDAY, i) + getGroupNum(DayOfWeek.MONDAY, i),
                            getSubjectName(DayOfWeek.TUESDAY, i) + getGroupNum(DayOfWeek.TUESDAY, i),
                            getSubjectName(DayOfWeek.WEDNESDAY, i) + getGroupNum(DayOfWeek.WEDNESDAY, i),
                            getSubjectName(DayOfWeek.THURSDAY, i) + getGroupNum(DayOfWeek.THURSDAY, i),
                            getSubjectName(DayOfWeek.FRIDAY, i) + getGroupNum(DayOfWeek.FRIDAY, i),
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
                            getSubjectName(DayOfWeek.MONDAY, i) + getTeacherIDNum(DayOfWeek.MONDAY, i),
                            getSubjectName(DayOfWeek.TUESDAY, i) + getTeacherIDNum(DayOfWeek.TUESDAY, i),
                            getSubjectName(DayOfWeek.WEDNESDAY, i) + getTeacherIDNum(DayOfWeek.WEDNESDAY, i),
                            getSubjectName(DayOfWeek.THURSDAY, i) + getTeacherIDNum(DayOfWeek.THURSDAY, i),
                            getSubjectName(DayOfWeek.FRIDAY, i) + getTeacherIDNum(DayOfWeek.FRIDAY, i),
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

    private String getSubjectName(DayOfWeek day, int period) {

        if (!checkAvailability(day, period)) {
            return scheduleMap.get(day).stream()
                    .filter(courseSlot -> courseSlot.getPeriod() == period)
                    .collect(Collectors.toList())
                    .get(0).getSubject().getSubjectName();
        }
        else return "------";
    }

    private String getGroupNum(DayOfWeek day, int period) {
        if (!checkAvailability(day, period)) {
            return " {class " + scheduleMap.get(day).stream()
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


}
