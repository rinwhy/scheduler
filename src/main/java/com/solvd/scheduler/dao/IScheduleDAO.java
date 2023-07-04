package com.solvd.scheduler.dao;


public interface IScheduleDAO<T> {

    T getById(int scheduleId);

    void insert(T schedule);

    void update(T schedule);

    void deleteById(int scheduleId);

}
