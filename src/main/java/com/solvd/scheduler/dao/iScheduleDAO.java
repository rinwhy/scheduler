package com.solvd.scheduler.dao;


public interface iScheduleDAO<T> {

    T getById(Integer scheduleId);

    void insert(T schedule);

    void update(T schedule);

    void delete(Integer scheduleId);

}
