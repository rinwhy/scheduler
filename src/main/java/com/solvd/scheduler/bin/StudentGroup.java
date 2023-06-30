package com.solvd.scheduler.bin;

import java.util.List;

public class StudentGroup {

    private final int id;
    private final Schedule groupSchedule;
    private List<Subject> syllabus;

    public StudentGroup(int id) {
        this.id = id;
        groupSchedule = new Schedule(School.getTotalPeriods());
    }


    public int getId() {
        return id;
    }

    public List<Subject> getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(List<Subject> syllabus) {
        this.syllabus = syllabus;
    }

    public Schedule getGroupSchedule() {
        return groupSchedule;
    }

    public void printStudentSchedule() {
        groupSchedule.printStudentsSchedule(this);
    }

}
