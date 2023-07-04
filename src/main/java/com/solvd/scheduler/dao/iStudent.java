package com.solvd.scheduler.dao;

import java.util.List;

public interface iStudent<T> {

    <T> T getById(Integer studentId);

    void insert(T student);

    void update(T student);

    void delete(Integer studentId);

    List<T> getAll();
}
