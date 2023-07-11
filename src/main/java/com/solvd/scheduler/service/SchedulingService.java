package com.solvd.scheduler.service;

import com.solvd.scheduler.bin.CourseSlot;
import com.solvd.scheduler.bin.Schedule;
import com.solvd.scheduler.bin.School;
import com.solvd.scheduler.dao.ICourseSlotDAO;
import com.solvd.scheduler.dao.IScheduleDAO;
import com.solvd.scheduler.utils.SqlFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;


/**
 * SchedulingService provides operations to retrieve a Schedule based on teacherId
 *
 * Retrieves a list of CourseSlots and combines them into a Schedule
 */
public class SchedulingService implements IScheduleDAO {

    private static final SqlSessionFactory factory = SqlFactoryUtil.getInstance().getFactory();

    @Override
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

    @Override
    public Schedule buildTeacherSchedule(int teacherId) {
        try (SqlSession session = factory.openSession()) {
            ICourseSlotDAO courseSlotDAO = session.getMapper(ICourseSlotDAO.class);
            List<CourseSlot> slotsByTeacherId = courseSlotDAO.getSlotsByTeacherId(teacherId);
            Schedule schedule = new Schedule(School.getTotalPeriods());
            slotsByTeacherId.forEach(slot->{
                slot.setSlotOpen(false);
                schedule.setCourseSlot(slot);
            });
            return schedule;
        }
    }

    @Override
    public Schedule getByGroupId(int groupId) {
        if (groupId > 0) {
            Schedule schedule = buildGroupSchedule(groupId);
            return schedule;
        } else {
            throw new RuntimeException("Invalid GroupId entered");
        }
    }

    @Override
    public Schedule buildGroupSchedule(int groupId) {
        try (SqlSession session = factory.openSession()) {
            ICourseSlotDAO courseSlotDAO = session.getMapper(ICourseSlotDAO.class);
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
