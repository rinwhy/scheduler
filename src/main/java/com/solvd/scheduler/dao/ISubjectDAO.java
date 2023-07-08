package com.solvd.scheduler.dao;
import com.solvd.scheduler.bin.Subject;

import java.util.List;

/**
 * ISubjectDAO interface defines the contract for accessing and manipulating Subject data in the database
 * It provides methods to retrieve, insert,and delete Subjects in the database
 */
public interface ISubjectDAO {

    Subject getById(int subjectId);

    List<Subject> getAll();

    void deleteByName(Subject subject);
    void insert(Subject subject);

    int getNumberOfSubjects();

}
