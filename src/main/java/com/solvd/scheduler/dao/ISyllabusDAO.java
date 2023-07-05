package com.solvd.scheduler.dao;

public interface ISyllabusDAO<T> {

    T getById(int syllabusId);

    void insert(T syllabus);

    void update(T syllabus);

    void deleteById(int syllabusId);

}
