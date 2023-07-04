package com.solvd.scheduler.bin;

import com.solvd.scheduler.utils.SchedulePrinter;

public class StudentGroup {

    private final int id;
    private final Schedule schedule;

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

}
