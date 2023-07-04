package com.solvd.scheduler.bin;


import com.solvd.scheduler.utils.SchedulePrinter;

public class Teacher {

    private int id;
    private String name;
    private Subject subject;         // subject
    private Schedule schedule;        // teachers schedule


    public Teacher() {
    }

    public Teacher(int id, String name, Subject subject) {
        this.id = id;
        this.name = name;
        this.subject = subject;

        schedule = new Schedule(School.getTotalPeriods());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void printSchedule() {
        SchedulePrinter.printTeacherSchedule(this);
    }

}
