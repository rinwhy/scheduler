package com.solvd.scheduler.service;

import com.solvd.scheduler.bin.StudentGroup;
import com.solvd.scheduler.dao.IStudentGroupDAO;
import com.solvd.scheduler.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;
import java.util.Objects;


/**
 * StudentGroupService provides operations to interact with StudentGroup objects in the database
 */
public class StudentGroupService implements IStudentGroupDAO {

    private static final Logger LOGGER = LogManager.getLogger(StudentGroupService.class);
    private static final SqlSessionUtil sessionUtil = new SqlSessionUtil();

    @Override
    public StudentGroup getById(int studentGroupId) {
        if (studentGroupId > 0) {
            try (SqlSession session = sessionUtil.getSessionFactory().openSession()) {
                IStudentGroupDAO studentGroupDAO = session.getMapper(IStudentGroupDAO.class);
                StudentGroup group = studentGroupDAO.getById(studentGroupId);
                SchedulingService schedulingService = new SchedulingService();
                group.setSchedule(schedulingService.getByGroupId(studentGroupId));
                return group;
            } catch (RuntimeException e) {
                LOGGER.warn("Error retrieving Student Group\n" + e.getMessage());
                e.printStackTrace();
            }
        } else LOGGER.warn("Invalid ID Provided");
        return null;
    }

    @Override
    public List<StudentGroup> getAll() {
        try (SqlSession session = sessionUtil.getSessionFactory().openSession()) {
            IStudentGroupDAO studentGroupDAO = session.getMapper(IStudentGroupDAO.class);
            SchedulingService schedulingService = new SchedulingService();
            List<StudentGroup> groups = studentGroupDAO.getAll();
            groups.forEach(group -> {
                group.setSchedule(schedulingService.getByGroupId(group.getId()));
            });
            return groups;
        } catch (RuntimeException e) {
            LOGGER.warn("Error retrieving list of Student groups\n" + e.getMessage());
            e.printStackTrace();
        }
        LOGGER.warn("Returning null student group list\n");
        return null;
    }

    @Override
    public void insert(StudentGroup studentGroup) {
        validateStudentGroup(studentGroup);

        try (SqlSession session = sessionUtil.getSessionFactory().openSession()) {
            IStudentGroupDAO studentGroupDAO = session.getMapper(IStudentGroupDAO.class);

            studentGroupDAO.insert(studentGroup);
            session.commit();
            LOGGER.info("Inserted StudentGroup\n");
        } catch (RuntimeException e) {
            LOGGER.warn("Error inserting Student Group\n" + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void update(StudentGroup studentGroup) {
        validateStudentGroup(studentGroup);
        try (SqlSession session = sessionUtil.getSessionFactory().openSession()) {
            IStudentGroupDAO studentGroupDAO = session.getMapper(IStudentGroupDAO.class);
            studentGroupDAO.update(studentGroup);
            session.commit();

            LOGGER.info("Successfully Updated Student Group\n" + studentGroup.getId());
        } catch (RuntimeException e) {
            LOGGER.warn("Error updating Student group\n" + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int studentGroupId) {
        if (studentGroupId > 0) {
            try (SqlSession session = sessionUtil.getSessionFactory().openSession()) {
                IStudentGroupDAO studentGroupDAO = session.getMapper(IStudentGroupDAO.class);

                studentGroupDAO.deleteById(studentGroupId);
                session.commit();
                LOGGER.info("Deleted student group\n");
            } catch (RuntimeException e) {
                LOGGER.warn("Error deleting student group\n" + e.getMessage());
                e.printStackTrace();
            }
        } else LOGGER.warn("Invalid ID Provided");
    }

    @Override
    public void deleteByGroupLetter(char letter) {
        try (SqlSession session = sessionUtil.getSessionFactory().openSession()) {
            IStudentGroupDAO studentGroupDAO = session.getMapper(IStudentGroupDAO.class);

            studentGroupDAO.deleteByGroupLetter(letter);
            session.commit();
            LOGGER.info("Deleted student group\n");
        } catch (RuntimeException e) {
            LOGGER.warn("Error deleting student group\n" + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public int getNumberOfStudentGroups() {
        int numGroups=0;
        try (SqlSession session = sessionUtil.getSessionFactory().openSession()) {
            IStudentGroupDAO groupDAO = session.getMapper(IStudentGroupDAO.class);
            numGroups= groupDAO.getNumberOfStudentGroups();
        } catch (RuntimeException e) {
            LOGGER.warn("Error retrieving list of Students\n" + e.getMessage());
            e.printStackTrace();
        }
        return numGroups;
    }

    private void validateStudentGroup(StudentGroup studentGroup) {
        Objects.requireNonNull(studentGroup, "Cannot proceed with a blank Student Group");
    }
}
