package com.solvd.scheduler.dao;

import java.util.List;

public interface iTeacher<T> {

    T getById(Integer teacherId);

    void save(T teacher);

    void update(T teacher);

    void delete(Integer teacherId);

    List<T> getAll();

}
