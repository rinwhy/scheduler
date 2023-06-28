package com.solvd.scheduler.bin;

import java.util.List;

public class StudentGroup {

    private int id;
    private List<Student> studentsList;


    public void addStudentToList(Student student) {
        studentsList.add(student);
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }
}
