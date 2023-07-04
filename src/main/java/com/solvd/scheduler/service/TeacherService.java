package com.solvd.scheduler.service;

import com.solvd.scheduler.Main;
import com.solvd.scheduler.bin.Teacher;
import com.solvd.scheduler.dao.ITeacherDAO;
import com.solvd.scheduler.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Objects;

public class TeacherService {

    private static final Logger logger = LogManager.getLogger(Main.class);
    private static final SqlSessionUtil sessionUtil = new SqlSessionUtil();

    public Teacher getById(Integer teacherId){
        if (teacherId <= 0) {
            throw new IllegalArgumentException("Invalid teacher ID");
        }

        try (SqlSession session = sessionUtil.getSession().openSession()) {
            ITeacherDAO teacherDAO = session.getMapper(ITeacherDAO.class);
            Teacher teacher = (Teacher) teacherDAO.getById(teacherId);
            session.commit();

            logger.info("Successfully retrieved Teacher " + teacher.getName() + " ID: " + teacher.getId());
            return teacher;
        }
    }

    public void update(Teacher teacher){
        validateTeacher(teacher);

        try (SqlSession session = sessionUtil.getSession().openSession()) {
            ITeacherDAO teacherDAO = session.getMapper(ITeacherDAO.class);
            teacherDAO.update(teacher);
            session.commit();

            logger.info("Successfully Updated Teacher " + teacher.getName() + " ID: " + teacher.getId());
        }
    }


    public void deleteById(Integer teacherId){
        if (teacherId <= 0) {
            throw new IllegalArgumentException("Invalid teacher ID");
        }

        Teacher teacher = getById(teacherId);

        try (SqlSession session = sessionUtil.getSession().openSession()) {
            ITeacherDAO teacherDAO = session.getMapper(ITeacherDAO.class);

            teacherDAO.delete(teacherId);
            session.commit();

            logger.info("Successfully deleted Teacher " + teacher.getName() + " ID: " + teacher.getId());
        }

    }

    public void insert(Teacher teacher){
        validateTeacher(teacher);

        try (SqlSession session = sessionUtil.getSession().openSession()) {
            ITeacherDAO teacherDAO = session.getMapper(ITeacherDAO.class);

            teacherDAO.insert(teacher);
            session.commit();

            logger.info("Successfully saved Teacher " + teacher.getName() + " ID: " + teacher.getId() + " to the Database");
        }
    }

    public List<Teacher> getAll() {

        try (SqlSession session = sessionUtil.getSession().openSession()) {
            ITeacherDAO teacherDAO = session.getMapper(ITeacherDAO.class);

            List<Teacher> teachers = teacherDAO.getAll();

            if (teachers.isEmpty()) {
                logger.info("No Teachers in Database");
                throw new RuntimeException("No Teachers in Database");
            }

            logger.info("Successfully retrieved all teachers in database");
            return teachers;
        }
    }

    private void validateTeacher(Teacher teacher) {
        Objects.requireNonNull(teacher, "Cannot update a blank teacher");

        if (Objects.isNull(getById(teacher.getId()))) {
            throw new RuntimeException("Teacher is not in the database, please insert into the database");
        }
    }
}
