package com.solvd.scheduler.dao;


import java.util.List;

/**
 * IStudentGroupDAO interface defines the contract for accessing and manipulating StudentGroup data in the database
 * It provides methods to retrieve, insert, update, and delete StudentGroups in the database
 * @param <T> StudentGroup
 */
public interface IStudentGroupDAO<T> {


    T getById(int studentId);

    List<T> getAll();

    void insert(T studentGroup);

    void update(T studentGroup);

    void deleteById(int studentId);

    void deleteByGroupLetter(char letter);
}
