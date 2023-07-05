package com.solvd.scheduler.dao;

import com.solvd.scheduler.bin.Subject;

import java.util.List;

public interface ISubjectDAO {

    Subject getById(int subjectId);

    List<Subject> getAll();

    void deleteByName(Subject subject);
    void insert(Subject subject);
}
