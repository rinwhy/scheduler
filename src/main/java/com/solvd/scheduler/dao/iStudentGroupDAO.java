package com.solvd.scheduler.dao;

import java.util.List;

public interface iStudentGroupDAO<T> {


    T getById(Integer studentId);

    void insert(T student);

    void update(T student);

    void deleteById(Integer studentId);
}
