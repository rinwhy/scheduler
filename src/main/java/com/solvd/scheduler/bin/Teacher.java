package com.solvd.scheduler.bin;


public class Teacher {

    private int id;
    private String name;
    private Subject teachingSubject;         // subject
    private Schedule teacherSchedule;        // teachers schedule


    public Teacher() {
    }

    public Teacher(int id, String name, Subject teachingSubject) {
        this.id = id;
        this.name = name;
        this.teachingSubject = teachingSubject;

        teacherSchedule = new Schedule(School.getTotalPeriods());
    }

    public int getId() {
        return id;
    }

    public Subject getTeachingSubject() {
        return teachingSubject;
    }

    public String getName() {
        return name;
    }

    public Schedule getTeacherSchedule() {
        return teacherSchedule;
    }

    public void printTeachersSchedule() {
        teacherSchedule.printTeachersSchedule(this);
    }

}
