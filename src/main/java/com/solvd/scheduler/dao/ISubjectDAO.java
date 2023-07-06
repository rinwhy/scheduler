package com.solvd.scheduler.dao;
import java.util.List;

/**
 * ISubjectDAO interface defines the contract for accessing and manipulating Subject data in the database
 * It provides methods to retrieve, insert,and delete Subjects in the database
 * @param <T> Subject
 */
public interface ISubjectDAO<T> {

    T getById(int subjectId);

    List<T> getAll();

    void deleteByName(T subject);
    void insert(T subject);
}
