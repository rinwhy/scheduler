package com.solvd.scheduler.dao;

import com.solvd.scheduler.bin.Schedule;

public interface IScheduleDAO {

    Schedule getByTeacherId(int teacherId);

    Schedule buildTeacherSchedule(int teacherId);

    Schedule getByGroupId(int groupId);

    Schedule buildGroupSchedule(int groupId);
}
