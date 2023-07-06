package com.solvd.scheduler.dao;

import com.solvd.scheduler.bin.CourseSlot;

import java.util.List;

/**
 * ICourseSlotDAO interface defines the contract for accessing and manipulating course slot data in the database
 * It provides methods to retrieve, insert, update, and delete course slot objects
 * @param <T> CourseSlot
 */
public interface ICourseSlotDAO<T> {

    T getById(Integer courseSlotId);

    List<T> getSlotsByTeacherId(Integer teacherId);

    List<T>  getSlotsByStudentGroupId(Integer studentId);

    void insert(T slot);

    void update(T slot);

    void deleteById(Integer courseSlotId);
}
