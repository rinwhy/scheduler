package com.solvd.scheduler.dao;

public interface iSubjectDAO<T> {

    T getById(Integer subjectId);

    void insert(T subject);

    void update(T subject);

    void delete(Integer subjectId);
}
