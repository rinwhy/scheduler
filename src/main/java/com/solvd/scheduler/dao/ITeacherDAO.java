package com.solvd.scheduler.dao;

import com.solvd.scheduler.bin.Teacher;

import java.util.List;

public interface ITeacherDAO {

    Teacher getById(int teacherId);

    void insert(Teacher teacher);

    void update(Teacher teacher);

    void deleteById(int teacherId);

    List<Teacher> getAll();

}
