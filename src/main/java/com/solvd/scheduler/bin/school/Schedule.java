package com.solvd.scheduler.bin.school;

import com.solvd.scheduler.bin.CourseSlot;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Schedule {

    private HashMap<Integer, CourseSlot> mwfSchedule = new HashMap<>();
    private HashMap<Integer, CourseSlot> tueThurSchedule = new HashMap<>();
//    HashMap<DayOfWeek, List<CourseSlot>> wednesdaySchedule = new HashMap<>();
//    HashMap<DayOfWeek, List<CourseSlot>> thursdaySchedule = new HashMap<>();
//    HashMap<DayOfWeek, List<CourseSlot>> fridaySchedule = new HashMap<>();


    public Schedule(int periods) {
        for(int i = 1; i<=periods; i++ ) {
            mwfSchedule.put(i, new CourseSlot());
            tueThurSchedule.put(i, new CourseSlot());
        }
    }

    public boolean checkAvailabilityMWF(int period) {
        //if the teachers mwf schedule for the given class period ...
        return mwfSchedule.get(period).isSlotAssigned();
    }

    public boolean checkAvailabilityTueThur(int period) {
        return tueThurSchedule.get(period).isSlotAssigned();
    }

    public void setMWFCourseSlot(int classPeriod, CourseSlot courseSlot) {
        mwfSchedule.replace(classPeriod, courseSlot);
    }

    public void setTueCourseSlot(int classPeriod, CourseSlot courseSlot ) {
        tueThurSchedule.replace(classPeriod, courseSlot);
    }


    @Override
    public String toString() {
        return "Schedule{" +
                "\nmwfSchedule=" + mwfSchedule +
                "\ntueThurSchedule=" + tueThurSchedule +
                '}';
    }
}
