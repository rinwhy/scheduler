package com.solvd.scheduler.service;

import com.solvd.scheduler.bin.CourseSlot;
import com.solvd.scheduler.bin.Schedule;
import com.solvd.scheduler.bin.School;
import com.solvd.scheduler.dao.ICourseSlotDAO;
import com.solvd.scheduler.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.time.DayOfWeek;
import java.util.List;


/**
 * SchedulingService provides operations to retrieve a Schedule based on teacherId
 *
 * Retrieves a list of CourseSlots and combines them into a Schedule
 */
public class SchedulingService {

    private static final SqlSessionUtil sessionUtil = new SqlSessionUtil();

    public Schedule getByTeacherId(int teacherId) {
        if (teacherId > 0) {
            Schedule schedule = buildTeacherSchedule(teacherId);
            return schedule;
        } else {
            throw new RuntimeException("Invalid TeacherId entered");
        }
    }

    /**
     * Pulls all courseSlots corresponding to a specific teacherId
     * Then adds the CourseSlots to a schedule based on teacherId
     *
     * @param teacherId
     * @return
     */
    private Schedule buildTeacherSchedule(int teacherId) {
        try (SqlSession session = sessionUtil.getSessionFactory().openSession()) {
            ICourseSlotDAO<CourseSlot> courseSlotDAO = session.getMapper(ICourseSlotDAO.class);
            List<CourseSlot> slotsByTeacherId = courseSlotDAO.getSlotsByTeacherId(teacherId);
            Schedule schedule = new Schedule(School.getTotalPeriods());
            slotsByTeacherId.forEach(slot->{
                slot.setSlotOpen(false);
                schedule.setCourseSlot(slot);
            });
            return schedule;
        }

    }

    public Schedule getByGroupId(int groupId) {
        if (groupId > 0) {
            Schedule schedule = buildGroupSchedule(groupId);
            return schedule;
        } else {
            throw new RuntimeException("Invalid GroupId entered");
        }
    }

    private Schedule buildGroupSchedule(int groupId) {
        try (SqlSession session = sessionUtil.getSessionFactory().openSession()) {
            ICourseSlotDAO<CourseSlot> courseSlotDAO = session.getMapper(ICourseSlotDAO.class);
            List<CourseSlot> slotsByGroupId = courseSlotDAO.getSlotsByStudentGroupId(groupId);
            Schedule schedule = new Schedule(School.getTotalPeriods());
            slotsByGroupId.forEach(slot->{
                slot.setSlotOpen(false);
                schedule.setCourseSlot(slot);
            });
            return schedule;
        }

    }
}
