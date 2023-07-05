package com.solvd.scheduler.service;

import com.solvd.scheduler.bin.Teacher;
import com.solvd.scheduler.dao.ITeacherDAO;
import com.solvd.scheduler.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Objects;

public class TeacherService implements ITeacherDAO {

    private static final Logger LOGGER = LogManager.getLogger(TeacherService.class);
    private static final SqlSessionUtil sessionUtil = new SqlSessionUtil();

    @Override
    public Teacher getById(int teacherId) {
        if (teacherId > 0) {
            try (SqlSession session = sessionUtil.getSessionFactory().openSession()) {
                ITeacherDAO teacherDAO = session.getMapper(ITeacherDAO.class);
                return teacherDAO.getById(teacherId);
            } catch (RuntimeException e) {
                LOGGER.warn("Error retrieving teacher\n" + e.getMessage());
                e.printStackTrace();
            }
        } else LOGGER.warn("Invalid ID Provided\n");
        return null;
    }

    @Override
    public List<Teacher> getAll() {
        try (SqlSession session = sessionUtil.getSessionFactory().openSession()) {
            ITeacherDAO teacherDAO = session.getMapper(ITeacherDAO.class);
            return teacherDAO.getAll();
        } catch (RuntimeException e) {
            LOGGER.warn("Error retrieving list of teachers\n" + e.getMessage());
            e.printStackTrace();
        }
        LOGGER.warn("Returning null teachers list\n");
        return null;
    }

    @Override
    public void insert(Teacher teacher) {
        if (validateTeacher(teacher)) {
            try (SqlSession session = sessionUtil.getSessionFactory().openSession()) {
                ITeacherDAO teacherDAO = session.getMapper(ITeacherDAO.class);

                teacherDAO.insert(teacher);
                session.commit();
                LOGGER.info("Inserted teacher\n");
            } catch (RuntimeException e) {
                LOGGER.warn("Error inserting teacher\n" + e.getMessage());
                e.printStackTrace();
            }
        } else LOGGER.warn("Teacher validation failed, please check teacher being inserted!\n");
    }

    @Override
    public void update(Teacher teacher) {
        if(validateTeacher(teacher)) {

            try (SqlSession session = sessionUtil.getSessionFactory().openSession()) {
                ITeacherDAO teacherDAO = session.getMapper(ITeacherDAO.class);
                teacherDAO.update(teacher);
                session.commit();
                LOGGER.info("Updated teacher\n");
            } catch (RuntimeException e) {
                LOGGER.warn("Error Updating teacher\n" + e.getMessage());
                e.printStackTrace();
            }
        } else LOGGER.warn("Teacher validation failed, please check teacher being updated!\n");
    }

    @Override
    public void deleteById(int teacherId) {

        if (teacherId > 0) {
            try (SqlSession session = sessionUtil.getSessionFactory().openSession()) {
                ITeacherDAO teacherDAO = session.getMapper(ITeacherDAO.class);

                teacherDAO.deleteById(teacherId);
                session.commit();
                LOGGER.info("Deleted teacher\n");
            } catch (RuntimeException e) {
                LOGGER.warn("Error deleting teacher\n" + e.getMessage());
                e.printStackTrace();
            }
        } else LOGGER.warn("Invalid ID Provided");
    }


    private boolean validateTeacher(Teacher teacher) {
        Objects.requireNonNull(teacher, "Cannot update a blank teacher");

        if (teacher.getName() != null && teacher.getSubject() != null) return true;
        else return false;

        // this thows a null pointed exception, when you try to pash any teacher.. validate teacher should just check name and subject
//        if (Objects.isNull(getById(teacher.getId()))) {
//            throw new RuntimeException("Teacher is not in the database, please insert into the database");
//        }
    }
}
