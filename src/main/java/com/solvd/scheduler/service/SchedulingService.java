package com.solvd.scheduler.service;
com.solvd.scheduler.util.SqlSessionUtil
import com.solvd.scheduler.bin.CourseSlot;
import com.solvd.scheduler.bin.Schedule;
import com.solvd.scheduler.dao.iCourseSlotDAO;
import org.apache.ibatis.session.SqlSession;

import java.nio.channels.ShutdownChannelGroupException;
import java.time.DayOfWeek;
import java.util.List;
import java.util.stream.Collectors;

public class SchedulingService {

    private static final SqlSessionUtil sessionUtil = new SqlSessionUtil();

//Grabs a teacher's schedule by teacherId
public Schedule getByTeacherId(Integer teacherId){
    if(scheduleId > 0){
        Schedule schedule = buildTeacherSchedule(teacherId);
        return schedule;
    }else {
        throw new RuntimeException("Invalide TeacherId entered");
    }
}

/*
 * Pulls all courseSlots corresponding to a specific teacher_id
 * Then places each CourseSlot into a list, depending on the courseSlot's intended day
 * Finally adds each day's slots to the schedule, based on period and day
 */

private Schedule buildTeacherSchedule(Integer teacherId){
    SqlSession session = sessionUtil.getSession();
    iCourseSlotDAO courseSlotDAO = session.getMapper(iCourseSlotDAO.class);


   List<CourseSlot> slotsByTeacherId = courseSlotDAO.getByTeacherId(teacherId)

    List<CourseSlot> monday = slotsByTeacherId.stream()
            .filter(courseSlot -> courseSlot.getDay() == DayOfWeek.MONDAY)
            .collect(Collectors.toList());
    List<CourseSlot> tuesday = slotsByTeacherId.stream()
            .filter(courseSlot -> courseSlot.getDay() == DayOfWeek.TUESDAY)
            .collect(Collectors.toList());
    List<CourseSlot> wednesday = slotsByTeacherId.stream()
            .filter(courseSlot -> courseSlot.getDay() == DayOfWeek.WEDNESDAY)
            .collect(Collectors.toList());
    List<CourseSlot> thursday = slotsByTeacherId.stream()
            .filter(courseSlot -> courseSlot.getDay() == DayOfWeek.THURSDAY)
            .collect(Collectors.toList());
    List<CourseSlot> friday = slotsByTeacherId.stream()
            .filter(courseSlot -> courseSlot.getDay() == DayOfWeek.FRIDAY)
            .collect(Collectors.toList());

    Schedule schedule = new Schedule();

    addToSchedule(monday, schedule);
    addToSchedule(tuesday, schedule);
    addToSchedule(wednesday, schedule);
    addToSchedule(thursday, schedule);
    addToSchedule(friday, schedule);

    return schedule;

}

    private void addToSchedule(List<CourseSlot> day, Schedule schedule) {
        for(int i = 0; i < day.size(); i++){
            CourseSlot slot = day.get(i);
            schedule.setCourseSlot(slot.getPeriod(), slot.getDay(), slot);
        }
    }
}
