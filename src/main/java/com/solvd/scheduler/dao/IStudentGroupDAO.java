package com.solvd.scheduler.dao;

import com.solvd.scheduler.bin.StudentGroup;
import java.util.List;

/**
 * IStudentGroupDAO interface defines the contract for accessing and manipulating StudentGroup data in the database
 * It provides methods to retrieve, insert, update, and delete StudentGroups in the database
 */
public interface IStudentGroupDAO {

    StudentGroup getById(int studentId);

    List<StudentGroup> getAll();

    void insert(StudentGroup studentGroup);

    void update(StudentGroup studentGroup);

    void deleteById(int studentId);

    void deleteByGroupLetter(char letter);
    int getNumberOfStudentGroups();

}
