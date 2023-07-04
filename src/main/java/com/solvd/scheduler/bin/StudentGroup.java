package com.solvd.scheduler.bin;

import com.solvd.scheduler.utils.SchedulePrinter;

public class StudentGroup {

    private final int id;
    private final Schedule schedule;
    private int numStudents;

    public StudentGroup(int id) {
        this.id = id;
        schedule = new Schedule(School.getTotalPeriods());
    }


    public int getId() {
        return id;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void printSchedule() {
        SchedulePrinter.printStudentSchedule(this);
    }

    public int getNumStudents() {
        return numStudents;
    }

    public void setNumStudents(int numStudents) {
        this.numStudents = numStudents;
    }
}
