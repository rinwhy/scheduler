package com.solvd.scheduler.bin;

import java.time.DayOfWeek;

/**
 * Represents a CourseSlot entity in the database
 * Contains information about open/ closed CourseSlots in a Schedule Object
 */
public class CourseSlot {

    private int id;
    private boolean slotOpen;
    private DayOfWeek  day;
    private int period;
    private Subject subject;
    private Teacher teacherAssigned;
    private StudentGroup studentGroup;

    public CourseSlot() {
        slotOpen = true;
    }

    public CourseSlot(DayOfWeek day, int period, Subject subject, Teacher teacherAssigned, StudentGroup studentGroup) {
        this.day = day;
        this.period = period;
        this.subject = subject;
        this.teacherAssigned = teacherAssigned;
        this.studentGroup = studentGroup;
        slotOpen = false;
    }

    public boolean isSlotOpen() {
        return slotOpen;
    }

    public void setSlotOpen(boolean slotOpen) {
        this.slotOpen = slotOpen;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Teacher getTeacherAssigned() {
        return teacherAssigned;
    }

    public void setTeacherAssigned(Teacher teacherAssigned) {
        this.teacherAssigned = teacherAssigned;
    }

    public StudentGroup getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
    }

    @Override
    public String toString() {
        return "CourseSlot{" +
                "id=" + id +
                ", slotOpen=" + slotOpen +
                ", day=" + day +
                ", period=" + period +
                ", subject=" + subject +
                ", teacherAssigned=" + teacherAssigned +
                ", studentGroup=" + studentGroup +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}