package com.solvd.scheduler.service;

import com.solvd.scheduler.bin.CourseSlot;
import com.solvd.scheduler.dao.ICourseSlotDAO;
import com.solvd.scheduler.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;
import java.util.Objects;


/**
 * CourseSlotService provides the operations that interact with CourseSlot objects in the database
 */
public class CourseSlotService implements ICourseSlotDAO {

    private static final Logger LOGGER = LogManager.getLogger(CourseSlotService.class);
    private static final SqlSessionUtil sessionUtil = new SqlSessionUtil();

    @Override
    public List<CourseSlot> getSlotsByTeacherId(Integer teacherId) {
        if (teacherId > 0) {
            try (SqlSession session = sessionUtil.getSessionFactory().openSession()) {
                ICourseSlotDAO courseSlotDAO = session.getMapper(ICourseSlotDAO.class);
                List<CourseSlot> courseLotsByTeacher = courseSlotDAO.getSlotsByTeacherId(teacherId);
                session.commit();

                LOGGER.info("Successfully retrieved all Course Slots tied to Teacher " + new TeacherService().getById(teacherId).getName());
                return courseLotsByTeacher;
            } catch (RuntimeException e) {
                LOGGER.warn("Error retrieving Course Slots by TeacherID\n" + e.getMessage());
                e.printStackTrace();
            }

        } else {
            LOGGER.warn("Invalid ID Provided\n");
        }

        return null;
    }

    @Override
    public List<CourseSlot> getSlotsByStudentGroupId(Integer studentGroupId) {

        if (studentGroupId > 0) {
            try (SqlSession session = sessionUtil.getSessionFactory().openSession()) {
                ICourseSlotDAO courseSlotDAO = session.getMapper(ICourseSlotDAO.class);
                List<CourseSlot> courseLotsByStudentGroup = (List<CourseSlot>) courseSlotDAO.getSlotsByStudentGroupId(studentGroupId);
                session.commit();

                LOGGER.info("Successfully retrieved all Course Slots tied to Student Group " + studentGroupId);
                return courseLotsByStudentGroup;
            } catch (RuntimeException e) {
                LOGGER.warn("Error retrieving Course Slots by GroupID\n" + e.getMessage());
                e.printStackTrace();
            }
        } else LOGGER.warn("Invalid ID Provided\n");

        return null;
    }

    @Override
    public CourseSlot getById(Integer courseSlotId) {

        if (courseSlotId > 0) {
            try (SqlSession session = sessionUtil.getSessionFactory().openSession()) {
                ICourseSlotDAO courseSlotDAO = session.getMapper(ICourseSlotDAO.class);
                CourseSlot courseSlot = (CourseSlot) courseSlotDAO.getById(courseSlotId);
                session.commit();

                LOGGER.info("Successfully retrieved Course Slot with ID: " + courseSlot.getId() + "\n");
                return courseSlot;
            } catch (RuntimeException e) {
                LOGGER.warn("Error retrieving Course Slot by Course Slot ID" + e.getMessage() + "\n");
                e.printStackTrace();
            }
        } else LOGGER.warn("Invalid ID Provided\n");

        return null;
    }

    @Override
    public void update(CourseSlot courseSlot) {
        validateCourseSlot(courseSlot);

        try (SqlSession session = sessionUtil.getSessionFactory().openSession()) {
            ICourseSlotDAO courseSlotDAO = session.getMapper(ICourseSlotDAO.class);
            courseSlotDAO.update(courseSlot);
            session.commit();

            LOGGER.info("Successfully Updated Course Slot with ID: " + courseSlot.getId() + "\n");
        } catch (RuntimeException e) {
            LOGGER.warn("Error updating Course Slot in database\n");
        }
    }

    @Override
    public void deleteById(Integer courseSlotId) {
        if (courseSlotId > 0) {

            CourseSlot courseSlot = getById(courseSlotId);
            if (courseSlot != null) {
                try (SqlSession session = sessionUtil.getSessionFactory().openSession()) {
                    ICourseSlotDAO courseSlotDAO = session.getMapper(ICourseSlotDAO.class);
                    courseSlotDAO.deleteById(courseSlotId);
                    session.commit();
                    LOGGER.info("Successfully deleted Course Slot with ID: " + courseSlot.getId() + "\n");
                } catch (RuntimeException e) {
                    LOGGER.warn("Error deleting Course Slot by Course Slot ID" + e.getMessage() + "\n");
                    e.printStackTrace();
                }
            }

        } else LOGGER.warn("Invalid Course Slot ID\n");
    }

    @Override
    public void deleteAll() {
        try (SqlSession session = sessionUtil.getSessionFactory().openSession()) {
            ICourseSlotDAO courseSlotDAO = session.getMapper(ICourseSlotDAO.class);
            courseSlotDAO.deleteAll();
        } catch (RuntimeException e) {
            LOGGER.warn("Error retrieving list of course slots\n" + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public int getNumberOfCourseSlots() {
        int numCourseSlot = 0;
        try (SqlSession session = sessionUtil.getSessionFactory().openSession()) {
            ICourseSlotDAO courseSlotDAO = session.getMapper(ICourseSlotDAO.class);
            numCourseSlot = courseSlotDAO.getNumberOfCourseSlots();
        } catch (RuntimeException e) {
            LOGGER.warn("Error retrieving list of Course Slots\n" + e.getMessage());
            e.printStackTrace();
        }
        return numCourseSlot;
    }

    @Override
    public void insert(CourseSlot courseSlot) {
        validateCourseSlot(courseSlot);

        try (SqlSession session = sessionUtil.getSessionFactory().openSession()) {
            ICourseSlotDAO courseSlotDAO = session.getMapper(ICourseSlotDAO.class);
            courseSlotDAO.insert(courseSlot);
            session.commit();
            LOGGER.info("Successfully saved Course Slot. Teacher:" +
                    courseSlot.getTeacherAssigned().getName() +
                    "  Subject:" + courseSlot.getSubject().name() +
                    "  GroupID:" + courseSlot.getStudentGroup().getId() +
                    "  Day: " + courseSlot.getDay() + "\n");
        } catch (RuntimeException e) {
            LOGGER.warn("Error inserting Course Slot into Database" + e.getMessage() + "\n");
            e.printStackTrace();
        }

    }

    private void validateCourseSlot(CourseSlot courseSlot) {
        Objects.requireNonNull(courseSlot, "Cannot proceed with a blank Course Slot");

    }
}
