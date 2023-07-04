package com.solvd.scheduler.dao;

import java.util.List;

public interface iCourseSlotDAO<T> {

    T getById(int courseSlotId);

    List<T> getSlotsByTeacherId(int teacherId);

    List<T>  getSlotsByGroupId(int studentId);

    void insert(T CourseSlot);

    void update(T CourseSlot);

    void deleteById(int courseSlotId);
}
