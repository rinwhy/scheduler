package com.solvd.scheduler.service;

import com.solvd.scheduler.bin.StudentGroup;
import com.solvd.scheduler.dao.IStudentGroupDAO;
import com.solvd.scheduler.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Objects;

public class StudentGroupService implements IStudentGroupDAO {

    private static final Logger LOGGER = LogManager.getLogger(StudentGroup.class);
    private static final SqlSessionUtil sessionUtil = new SqlSessionUtil();

    @Override
    public StudentGroup getById(int studentGroupId) {
        if (studentGroupId > 0) {
            try (SqlSession session = sessionUtil.getSessionFactory().openSession()) {
                IStudentGroupDAO studentGroupDAO = session.getMapper(IStudentGroupDAO.class);
                return studentGroupDAO.getById(studentGroupId);
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
            return studentGroupDAO.getAll();
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


    private void validateStudentGroup(StudentGroup studentGroup) {
        Objects.requireNonNull(studentGroup, "Cannot proceed with a blank Student Group");
    }
}
