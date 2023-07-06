package com.solvd.scheduler.dao;

import java.util.List;

/**
 * ITeacherDAO interface defines the contract for accessing and manipulating Teacher data in the database
 * It provides methods to retrieve, insert, update, and delete Teachers in the database
 * @param <T> Teacher
 */
public interface ITeacherDAO<T> {

    T getById(int teacherId);

    void insert(T teacher);

    void update(T teacher);

    void deleteById(int teacherId);

    List<T> getAll();

}
