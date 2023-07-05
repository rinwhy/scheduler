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
        if (teacherId > 0) {
            try (SqlSession session = sessionUtil.getSessionFactory().openSession()) {
                ICourseSlotDAO courseSlotDAO = session.getMapper(ICourseSlotDAO.class);
                List<CourseSlot> courseLotsByTeacher = (List<CourseSlot>) courseSlotDAO.getSlotsByTeacherId(teacherId);
                session.commit();

                logger.info("Successfully retrieved all Course Slots tied to Teacher " + new TeacherService().getById(teacherId).getName());
                return courseLotsByTeacher;
            }catch(RuntimeException e){
                logger.warn("Error retrieving Course Slots by TeacherID\n" + e.getMessage());
                e.printStackTrace();
            }

        }else {
            logger.warn("Invalid ID Provided\n");
        }

        return null;
    }

    public List<CourseSlot> getByStudentGroupId(Integer studentGroupId){

        if (studentGroupId > 0) {
            try (SqlSession session = sessionUtil.getSessionFactory().openSession()) {
                ICourseSlotDAO courseSlotDAO = session.getMapper(ICourseSlotDAO.class);
                List<CourseSlot> courseLotsByStudentGroup = (List<CourseSlot>) courseSlotDAO.getSlotsByGroupId(studentGroupId);
                session.commit();

                logger.info("Successfully retrieved all Course Slots tied to Student Group " + studentGroupId);
                return courseLotsByStudentGroup;
            }catch(RuntimeException e ){
                logger.warn("Error retrieving Course Slots by GroupID\n" + e.getMessage());
                e.printStackTrace();
            }
        }else logger.warn("Invalid ID Provided\n");

        return null;
    }


    public CourseSlot getById(Integer courseSlotId){

        if (courseSlotId > 0) {
            try (SqlSession session = sessionUtil.getSessionFactory().openSession()) {
                ICourseSlotDAO courseSlotDAO = session.getMapper(ICourseSlotDAO.class);
                CourseSlot courseSlot = (CourseSlot) courseSlotDAO.getById(courseSlotId);
                session.commit();

                logger.info("Successfully retrieved Course Slot with ID: " + courseSlot.getId() +"\n");
                return courseSlot;
            }catch(RuntimeException e){
                logger.warn("Error retrieving Course Slot by Course Slot ID" + e.getMessage()+"\n");
                e.printStackTrace();
            }
        }else logger.warn("Invalid ID Provided\n");

        return null;
    }

    public void update(CourseSlot courseSlot){
        validateCourseSlot(courseSlot);

        try (SqlSession session = sessionUtil.getSessionFactory().openSession()) {
            ICourseSlotDAO courseSlotDAO = session.getMapper(ICourseSlotDAO.class);
            courseSlotDAO.update(courseSlot);
            session.commit();

            logger.info("Successfully Updated Course Slot with ID: " + courseSlot.getId() + "\n");
        }catch (RuntimeException e){
            logger.warn("Error updating Course Slot in database\n");
        }
    }


    public void deleteById(Integer courseSlotId){
        if(courseSlotId > 0 ){

            CourseSlot courseSlot = getById(courseSlotId);
            if(courseSlot != null){
                try (SqlSession session = sessionUtil.getSessionFactory().openSession()) {
                    ICourseSlotDAO courseSlotDAO = session.getMapper(ICourseSlotDAO.class);
                    courseSlotDAO.deleteById(courseSlotId);
                    session.commit();
                    logger.info("Successfully deleted Course Slot with ID: " + courseSlot.getId() + "\n");
                }catch(RuntimeException e){
                    logger.warn("Error deleting Course Slot by Course Slot ID" + e.getMessage() + "\n");
                    e.printStackTrace();
                }
            }

        }else logger.warn("Invalid Course Slot ID\n");
    }

    public void insert(CourseSlot courseSlot){
        validateCourseSlot(courseSlot);

        try (SqlSession session = sessionUtil.getSessionFactory().openSession()) {
            ICourseSlotDAO courseSlotDAO = session.getMapper(ICourseSlotDAO.class);
            courseSlotDAO.insert(courseSlot);
            session.commit();
            logger.info("Successfully saved Course Slot with ID: " + courseSlot.getId() + "\n");
        }catch(RuntimeException e ){
            logger.warn("Error inserting Course Slot into Database" + e.getMessage() + "\n");
            e.printStackTrace();
        }

    }

    /*public List<CourseSlot> getAll() {

        try (SqlSession session = sessionUtil.getSession()) {
    *//*public List<CourseSlot> getAll() {

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
*//*
        }
    }*/

    private void validateCourseSlot(CourseSlot courseSlot) {
        Objects.requireNonNull(courseSlot, "Cannot procede with a blank Course Slot");

    }
}
