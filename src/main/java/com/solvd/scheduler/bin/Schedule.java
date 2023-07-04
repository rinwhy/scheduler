package com.solvd.scheduler.bin;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
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

    // returns the schedule values to be printed
    public <T> String[][] getScheduleValues(Object obj) {
        List<List<String>> dataList = new ArrayList<>();

        if (obj instanceof Teacher) {
            for (int i = 1; i <= School.getTotalPeriods(); i++) {
                String[] tableRow =
                        {
                                Integer.toString(i),
                                getSubjectName(DayOfWeek.MONDAY, i) + getGroupNum(DayOfWeek.MONDAY, i),
                                getSubjectName(DayOfWeek.TUESDAY, i) + getGroupNum(DayOfWeek.TUESDAY, i),
                                getSubjectName(DayOfWeek.WEDNESDAY, i) + getGroupNum(DayOfWeek.WEDNESDAY, i),
                                getSubjectName(DayOfWeek.THURSDAY, i) + getGroupNum(DayOfWeek.THURSDAY, i),
                                getSubjectName(DayOfWeek.FRIDAY, i) + getGroupNum(DayOfWeek.FRIDAY, i)
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

//                    .get(0).getSubject().getSubjectName();
        } else return "------";
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
