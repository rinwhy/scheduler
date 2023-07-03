package com.solvd.scheduler.bin;

public class StudentGroup {

    private final int id;
    private final Schedule groupSchedule;

    public StudentGroup(int id) {
        this.id = id;
        groupSchedule = new Schedule(School.getTotalPeriods());
    }


    public int getId() {
        return id;
    }

    public Schedule getGroupSchedule() {
        return groupSchedule;
    }

    public void printStudentSchedule() {
        groupSchedule.printStudentsSchedule(this);
    }

}
