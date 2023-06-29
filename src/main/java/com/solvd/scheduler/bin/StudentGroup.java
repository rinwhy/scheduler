package com.solvd.scheduler.bin;

import com.solvd.scheduler.bin.school.Schedule;
import com.solvd.scheduler.bin.school.Subject;

import java.util.List;

public class StudentGroup {

    private int id;
    private Schedule groupSchedule;
    private List<Subject> syllabus;

    public StudentGroup(int id) {
        this.id = id;
        groupSchedule = new Schedule(4);
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

    @Override
    public String toString() {
        return
                "groupSchedule=" + groupSchedule;
    }

}
