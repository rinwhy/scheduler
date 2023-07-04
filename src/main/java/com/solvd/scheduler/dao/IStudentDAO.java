package com.solvd.scheduler.dao;

import java.util.List;

public interface IStudentDAO<T> {

    T getById(int studentId);

    void insert(T student);

    void update(T student);

    void delete(Integer studentId);

    List<T> getAll();
}
