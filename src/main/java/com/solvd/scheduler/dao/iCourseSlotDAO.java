package com.solvd.scheduler.dao;

public interface iCourseSlotDAO<T> {

    T getById(Integer coursSlotId);

    T getByTeacherId(Integer teacherId);

    T getByStudentId(Integer studentId);

    void insert(T CourseSlot);

    void update(T CourseSlot);

    void deleteById(Integer courseSlotId);
}
