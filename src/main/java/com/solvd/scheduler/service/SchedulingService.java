package com.solvd.scheduler.service;
import com.solvd.scheduler.bin.CourseSlot;
import com.solvd.scheduler.bin.Schedule;
import com.solvd.scheduler.bin.School;
import com.solvd.scheduler.dao.ICourseSlotDAO;
import com.solvd.scheduler.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class SchedulingService {

    private static final SqlSessionUtil sessionUtil = new SqlSessionUtil();

//Grabs a teacher's schedule by teacherId
public Schedule getByTeacherId(int teacherId){
    if(teacherId > 0){
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

private Schedule buildTeacherSchedule(int teacherId){

    try(SqlSession session = sessionUtil.getSessionFactory().openSession()){
        ICourseSlotDAO courseSlotDAO = session.getMapper(ICourseSlotDAO.class);


        List<CourseSlot> slotsByTeacherId = courseSlotDAO.getSlotsByTeacherId(teacherId);


        Schedule schedule = new Schedule(School.getTotalPeriods());

        slotsByTeacherId.forEach(schedule::setCourseSlot);
        //System.out.println(schedule.toString());




//        List<CourseSlot> monday = slotsByTeacherId.stream()
//                .filter(courseSlot -> courseSlot.getDay() == DayOfWeek.MONDAY)
//                .collect(Collectors.toList());
//        List<CourseSlot> tuesday = slotsByTeacherId.stream()
//                .filter(courseSlot -> courseSlot.getDay() == DayOfWeek.TUESDAY)
//                .collect(Collectors.toList());
//        List<CourseSlot> wednesday = slotsByTeacherId.stream()
//                .filter(courseSlot -> courseSlot.getDay() == DayOfWeek.WEDNESDAY)
//                .collect(Collectors.toList());
//        List<CourseSlot> thursday = slotsByTeacherId.stream()
//                .filter(courseSlot -> courseSlot.getDay() == DayOfWeek.THURSDAY)
//                .collect(Collectors.toList());
//        List<CourseSlot> friday = slotsByTeacherId.stream()
//                .filter(courseSlot -> courseSlot.getDay() == DayOfWeek.FRIDAY)
//                .collect(Collectors.toList());
//
//
//        addToSchedule(monday, schedule);
//        addToSchedule(tuesday, schedule);
//        addToSchedule(wednesday, schedule);
//        addToSchedule(thursday, schedule);
//        addToSchedule(friday, schedule);

        return schedule;
    }

}

    private void addToSchedule(List<CourseSlot> day, Schedule schedule) {
        for (CourseSlot slot : day) {
            schedule.setCourseSlot(slot);

        }
    }

    public void setCourseSlot(CourseSlot courseSlot) {

    }

}
