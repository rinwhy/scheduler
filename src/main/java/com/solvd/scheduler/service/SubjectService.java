package com.solvd.scheduler.service;

import com.solvd.scheduler.Main;
import com.solvd.scheduler.bin.Subject;
import com.solvd.scheduler.dao.ISubjectDAO;
import com.solvd.scheduler.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Objects;

public class SubjectService {

    private static final Logger logger = LogManager.getLogger(Main.class);
    private static final SqlSessionUtil sessionUtil = new SqlSessionUtil();

    public Subject getById(Integer subjectId){
        if (subjectId <= 0) {
            throw new IllegalArgumentException("Invalid subject ID");
        }

        try (SqlSession session = sessionUtil.getSession().openSession()) {
            ISubjectDAO subjectDAO = session.getMapper(ISubjectDAO.class);
            Subject subject = (Subject) subjectDAO.getById(subjectId);
            session.commit();

            logger.info("Successfully retrieved Subject " + subject.getSubjectName());
            return subject;
        }
    }


    public void deleteById(Integer subjectId){
        if (subjectId <= 0) {
            throw new IllegalArgumentException("Invalid subject ID");
        }

        Subject subject = getById(subjectId);

        try (SqlSession session = sessionUtil.getSession().openSession()) {
            ISubjectDAO subjectDAO = session.getMapper(ISubjectDAO.class);

            subjectDAO.delete(subjectId);
            session.commit();

            logger.info("Successfully deleted Subject " + subject.getSubjectName());
        }

    }

    public void insert(Subject subject){
        validateSubject(subject);

        try (SqlSession session = sessionUtil.getSession().openSession()) {
            ISubjectDAO subjectDAO = session.getMapper(ISubjectDAO.class);

            subjectDAO.insert(subject);
            session.commit();

            logger.info("Successfully saved Subject " + subject.getSubjectName());
        }
    }

    /*public List<Subject> getAll() {

        try (SqlSession session = sessionUtil.getSession().openSession()) {
            ISubjectDAO subjectDAO = session.getMapper(ISubjectDAO.class);

            List<Subject> subjects = subjectDAO.getAll();

            if (subjects.isEmpty()) {
                logger.info("No Subjects in Database");
                throw new RuntimeException("No Subjects in Database");
            }

            logger.info("Successfully retrieved all subjects in database");
            return subjects;
        }
    }*/

    private void validateSubject(Subject subject) {
        Objects.requireNonNull(subject, "Cannot procede with blank subject");

        if (Objects.isNull(getById(subject.getId()))) {
            throw new RuntimeException("Subject is not in the database, please insert into the database");
        }
    }


}
