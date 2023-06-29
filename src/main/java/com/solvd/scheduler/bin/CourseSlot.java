package com.solvd.scheduler.bin;

import com.solvd.scheduler.bin.school.Subject;

import java.time.DayOfWeek;

public class CourseSlot {


    private boolean slotAssigned;

    private String  days;
    private Subject subject;
    private Teacher teacherAssigned;

    public CourseSlot() {
        slotAssigned = false;
    }


    public boolean isSlotAssigned() {
        return slotAssigned;
    }

    public void setSlotAssigned(boolean slotAssigned) {
        this.slotAssigned = slotAssigned;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setTeacherAssigned(Teacher teacherAssigned) {
        this.teacherAssigned = teacherAssigned;
    }

    public void setDay(String days) {
        this.days = days;
    }

    @Override
    public String toString() {
        return "CourseSlot{" +
                "slotAssigned=" + slotAssigned +
                ", day=" + days +
                ", subject=" + subject +
                ", teacherAssigned=" + teacherAssigned +
                '}';
    }
}