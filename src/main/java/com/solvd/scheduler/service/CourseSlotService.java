package com.solvd.scheduler.service;

import com.solvd.scheduler.Main;
import com.solvd.scheduler.bin.CourseSlot;
import com.solvd.scheduler.dao.ICourseSlotDAO;
import com.solvd.scheduler.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Objects;

public class CourseSlotService {

    private static final Logger logger = LogManager.getLogger(Main.class);
    private static final SqlSessionUtil sessionUtil = new SqlSessionUtil();

    public List<CourseSlot> getByTeacherId(Integer teacherId){
        if (teacherId <= 0) {
            throw new IllegalArgumentException("Invalid Teacher ID");
        }

        try (SqlSession session = sessionUtil.getSessionFactory().openSession()) {
            ICourseSlotDAO courseSlotDAO = session.getMapper(ICourseSlotDAO.class);
            List<CourseSlot> courseLotsByTeacher = (List<CourseSlot>) courseSlotDAO.getSlotsByTeacherId(teacherId);
            session.commit();

            logger.info("Successfully retrieved all Course Slots tied to Teacher " + new TeacherService().getById(teacherId).getName());
            return courseLotsByTeacher;
        }
    }

    public List<CourseSlot> getByStudentGroupId(Integer studentGroupId){
        if (studentGroupId <= 0) {
            throw new IllegalArgumentException("Invalid studentGroupId ID");
        }

        try (SqlSession session = sessionUtil.getSessionFactory().openSession()) {
            ICourseSlotDAO courseSlotDAO = session.getMapper(ICourseSlotDAO.class);
            List<CourseSlot> courseLotsByStudentGroup = (List<CourseSlot>) courseSlotDAO.getSlotsByGroupId(studentGroupId);
            session.commit();

            logger.info("Successfully retrieved all Course Slots tied to Student Group " + studentGroupId);
            return courseLotsByStudentGroup;
        }
    }


    public CourseSlot getById(Integer courseSlotId){
        if (courseSlotId <= 0) {
            throw new IllegalArgumentException("Invalid Course Slot ID");
        }

        try (SqlSession session = sessionUtil.getSessionFactory().openSession()) {
            ICourseSlotDAO courseSlotDAO = session.getMapper(ICourseSlotDAO.class);
            CourseSlot courseSlot = (CourseSlot) courseSlotDAO.getById(courseSlotId);
            session.commit();

            logger.info("Successfully retrieved Course Slot with ID: " + courseSlot.getId());
            return courseSlot;
        }
    }

    public void update(CourseSlot courseSlot){
        validateCourseSlot(courseSlot);

        try (SqlSession session = sessionUtil.getSessionFactory().openSession()) {
            ICourseSlotDAO courseSlotDAO = session.getMapper(ICourseSlotDAO.class);
            courseSlotDAO.update(courseSlot);
            session.commit();

            logger.info("Successfully Updated Course Slot with ID: " + courseSlot.getId());
        }
    }


    public void deleteById(Integer courseSlotId){
        if (courseSlotId <= 0) {
            throw new IllegalArgumentException("Invalid Course Slot ID");
        }

        CourseSlot courseSlot = getById(courseSlotId);

        try (SqlSession session = sessionUtil.getSessionFactory().openSession()) {
            ICourseSlotDAO courseSlotDAO = session.getMapper(ICourseSlotDAO.class);

            courseSlotDAO.deleteById(courseSlotId);
            session.commit();

            logger.info("Successfully deleted Course Slot with ID: " + courseSlot.getId());
        }

    }

    /*public List<CourseSlot> getAll() {

        try (SqlSession session = sessionUtil.getSession().openSession()) {
            iCourseSlotDAO courseSlotDAO = session.getMapper(iCourseSlotDAO.class);

            List<CourseSlot> courseSlots = courseSlotDAO.getAll();

            if (courseSlots.isEmpty()) {
                logger.info("No Course Slots in Database");
                throw new RuntimeException("No Course Slots in Database");
            }

            logger.info("Successfully retrieved all Course Slots in database");
            return courseSlots;
        }
    }*/

    public void insert(CourseSlot courseSlot){
        validateCourseSlot(courseSlot);

        try (SqlSession session = sessionUtil.getSessionFactory().openSession()) {
            ICourseSlotDAO courseSlotDAO = session.getMapper(ICourseSlotDAO.class);

            courseSlotDAO.insert(courseSlot);
            session.commit();

            logger.info("Successfully saved Course Slot with ID: " + courseSlot.getId());
        }
    }

    private void validateCourseSlot(CourseSlot courseSlot) {
        Objects.requireNonNull(courseSlot, "Cannot procede with a blank Course Slot");

        if (Objects.isNull(getById(courseSlot.getId()))) {
            throw new RuntimeException("Course Slot is not in the database, please insert into the database");
        }
    }


}
