package com.solvd.scheduler.dao;


public interface iSchedule<T> {

    T getById(Integer scheduleId);

    void saveById(T schedule);

    void update(T schedule);

    void delete(Integer contractorID);

}
