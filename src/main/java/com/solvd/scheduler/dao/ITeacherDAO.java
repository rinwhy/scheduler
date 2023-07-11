package com.solvd.scheduler.dao;

import com.solvd.scheduler.bin.Teacher;
import java.util.List;

/**
 * ITeachereacherDAO interface defines the contract for accessing and manipulating Teachereacher data in the database
 * It provides methods to retrieve, insert, update, and delete Teachereachers in the database
 */
public interface ITeacherDAO {

    Teacher getById(int teacherId);

    void insert(Teacher teacher);

    void update(Teacher teacher);

    void deleteById(int teacherId);

    List<Teacher> getAll();

    int getNumberOfTeachers();

}
