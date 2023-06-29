package com.solvd.scheduler.bin;

import com.solvd.scheduler.bin.school.Schedule;
import com.solvd.scheduler.bin.school.Subject;


public class Teacher {

    private int id;
    private Subject teachingSubject;         // subject
    private Schedule teacherSchedule;        // teachers schedule


    public Teacher() {
    }

    public Teacher(int id, Subject teachingSubject) {
        this.id = id;
        this.teachingSubject = teachingSubject;

        teacherSchedule = new Schedule(4);
    }

    public int getId() {
        return id;
    }

    public Subject getTeachingSubject() {
        return teachingSubject;
    }

    public Schedule getTeacherSchedule() {
        return teacherSchedule;
    }

}
