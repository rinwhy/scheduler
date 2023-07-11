package com.solvd.scheduler.dao;

import com.solvd.scheduler.bin.CourseSlot;
import java.util.List;

/**
 * ICourseSlotDAO interface defines the contract for accessing and manipulating course slot data in the database
 * It provides methods to retrieve, insert, update, and delete course slot objects

 */
public interface ICourseSlotDAO {

    CourseSlot getById(Integer courseSlotId);

    List<CourseSlot> getSlotsByTeacherId(Integer teacherId);

    List<CourseSlot>  getSlotsByStudentGroupId(Integer studentId);

    void insert(CourseSlot slot);

    void update(CourseSlot slot);

    void deleteById(Integer courseSlotId);
    void deleteAll();
    int getNumberOfCourseSlots();
}
