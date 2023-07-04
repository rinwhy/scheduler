package com.solvd.scheduler.dao;

public interface IStudentGroupDAO<T> {


    T getById(Integer studentId);

    void insert(T student);

    void update(T student);

    void deleteById(Integer studentId);
}
