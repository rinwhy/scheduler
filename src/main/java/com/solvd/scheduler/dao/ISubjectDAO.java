package com.solvd.scheduler.dao;

public interface ISubjectDAO<T> {

    T getById(int subjectId);

    void insert(T subject);

    void update(T subject);

    void delete(Integer subjectId);
}
