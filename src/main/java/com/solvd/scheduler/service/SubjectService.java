package com.solvd.scheduler.service;

import com.solvd.scheduler.bin.Subject;
import com.solvd.scheduler.dao.ISubjectDAO;
import com.solvd.scheduler.utils.SqlFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * SubjectService provides operations for interacting with Subject Entities in the database
 */
public class SubjectService implements ISubjectDAO {

    private static final Logger LOGGER = LogManager.getLogger(SubjectService.class);
    private static final SqlSessionFactory factory = SqlFactoryUtil.getInstance().getFactory();


    @Override
    public Subject getById(int subjectId) {
        if (subjectId > 0) {
            try (SqlSession session = factory.openSession()) {
                ISubjectDAO subjectDAO = session.getMapper(ISubjectDAO.class);
                return subjectDAO.getById(subjectId);
            } catch (RuntimeException e) {
                LOGGER.warn("Error retrieving subject\n" + e.getMessage());
                e.printStackTrace();
            }
        } else LOGGER.warn("Invalid ID Provided");
        return null;
    }

    @Override
    public List<Subject> getAll() {
        try (SqlSession session = factory.openSession()) {
            ISubjectDAO subjectDAO = session.getMapper(ISubjectDAO.class);
            return subjectDAO.getAll();
        } catch (RuntimeException e) {
            LOGGER.warn("Error retrieving list of subjects\n" + e.getMessage());
            e.printStackTrace();
        }
        LOGGER.warn("Returning null subjects list");
        return null;
    }

    @Override
    public void deleteByName(Subject subject) {
        try (SqlSession session = factory.openSession()) {
            ISubjectDAO subjectDAO = session.getMapper(ISubjectDAO.class);
            subjectDAO.deleteByName(subject);
            session.commit();
            LOGGER.info("Deleted " + subject.name());
        } catch (RuntimeException e) {
            LOGGER.warn("Error deleting subject\n" + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void insert(Subject subject) {
        try (SqlSession session = factory.openSession()) {
            ISubjectDAO subjectDAO = session.getMapper(ISubjectDAO.class);
            subjectDAO.insert(subject);
            session.commit();
//            LOGGER.info("Inserted " + subject.name() + "\n");
        } catch (RuntimeException e) {
            LOGGER.warn("Error inserting subject\n" + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public int getNumberOfSubjects() {
        int numSubjects=0;
        try (SqlSession session = factory.openSession()) {
            ISubjectDAO subjectDAO = session.getMapper(ISubjectDAO.class);
            numSubjects= subjectDAO.getNumberOfSubjects();
        } catch (RuntimeException e) {
            LOGGER.warn("Error retrieving list of Subjects\n" + e.getMessage());
            e.printStackTrace();
        }
        return numSubjects;
    }
}
