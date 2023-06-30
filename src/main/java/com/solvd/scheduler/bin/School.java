package com.solvd.scheduler.bin;

import com.solvd.scheduler.bin.Teacher;

import java.util.ArrayList;
import java.util.List;

public class School {

    private static final int TOTAL_PERIODS = 4;
    private static final List<Teacher> teacherList = new ArrayList<>();

    public static int getTotalPeriods() {
        return TOTAL_PERIODS;
    }

    public static List<Teacher> getTeacherList() {
        return teacherList;
    }
}
