package com.solvd.scheduler.dao;

public interface iSubject<Subject, Integer> {

    Subject getById(Integer subjectId);

    void update(Subject subject);

    void save(Subject subject);

    void delete(Integer subjectId);
}
