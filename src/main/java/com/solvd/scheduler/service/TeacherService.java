package com.solvd.scheduler.service;

import com.solvd.scheduler.bin.Teacher;
import com.solvd.scheduler.dao.ITeacherDAO;
import com.solvd.scheduler.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * TeacherService provides the operations that interact with Teacher objects in the database
 */
public class TeacherService implements ITeacherDAO {

    private static final Logger LOGGER = LogManager.getLogger(TeacherService.class);
    private static final SqlSessionUtil sessionUtil = new SqlSessionUtil();

    @Override
    public Teacher getById(int teacherId) {
        if (teacherId > 0) {
            try (SqlSession session = sessionUtil.getSessionFactory().openSession()) {
                ITeacherDAO teacherDAO = session.getMapper(ITeacherDAO.class);
                Teacher teacher = teacherDAO.getById(teacherId);
                SchedulingService schedulingService = new SchedulingService();
                teacher.setSchedule(schedulingService.getByTeacherId(teacherId));
                return teacher;
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
            SchedulingService schedulingService = new SchedulingService();
            List<Teacher> teachers = teacherDAO.getAll();
            teachers.forEach(teacher -> {
                teacher.setSchedule(schedulingService.getByTeacherId(teacher.getId()));
            });
            return teachers;
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
                LOGGER.info("Inserted teacher:" + teacher.getName()+"\n");
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
        return teacher.getName() != null && teacher.getSubject() != null;
    }
}
