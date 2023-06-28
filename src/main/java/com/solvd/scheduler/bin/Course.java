package com.solvd.scheduler.bin;

import java.time.LocalTime;

public class Course {

    private Subject subject;
    private LocalTime startTime;
    private LocalTime endTime;

    private Teacher teacherAssigned;

    public Course() {
    }

    public Course(Subject subject, LocalTime startTime, LocalTime endTime, Teacher teacherAssigned) {
        this.subject = subject;
        this.startTime = startTime;
        this.endTime = endTime;
        this.teacherAssigned = teacherAssigned;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Teacher getTeacherAssigned() {
        return teacherAssigned;
    }

    public void setTeacherAssigned(Teacher teacherAssigned) {
        this.teacherAssigned = teacherAssigned;
    }
}
