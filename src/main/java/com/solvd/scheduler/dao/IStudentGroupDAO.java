package com.solvd.scheduler.dao;

import com.solvd.scheduler.bin.StudentGroup;

import java.util.List;

public interface IStudentGroupDAO {


    StudentGroup getById(int studentId);

    List<StudentGroup> getAll();

    void insert(StudentGroup studentGroup);

    void update(StudentGroup studentGroup);

    void deleteById(int studentId);
}
