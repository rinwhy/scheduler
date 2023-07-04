package com.solvd.scheduler.dao;

public interface ISyllabusDAO<T> {

    T getById(Integer syllabusId);

    void insert(T syllabus);

    void update(T syllabus);

    void deleteById(Integer syllabusId);

}
