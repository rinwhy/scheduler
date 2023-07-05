package com.solvd.scheduler.bin;

import com.solvd.scheduler.utils.SchedulePrinter;

public class StudentGroup {

    private int id;
    private char letter;
    private Schedule schedule;
    private int numStudents;


    public StudentGroup() {
    }

    public StudentGroup(int id, char letter, int numStudents) {
        this.id = id;
        this.letter = letter;
        this.numStudents = numStudents;
    }

    public StudentGroup(char letter, int numStudents) {
        this.letter = letter;
        this.numStudents = numStudents;
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

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "StudentGroup{" +
                "id=" + id +
                ", letter=" + letter +
                ", numStudents=" + numStudents +
                '}';
    }
}
