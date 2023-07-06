package com.solvd.scheduler.service;

import com.solvd.scheduler.Main;
import com.solvd.scheduler.bin.Syllabus;
import com.solvd.scheduler.dao.ISyllabusDAO;
import com.solvd.scheduler.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class SyllabusService {

    private static final Logger logger = LogManager.getLogger(Main.class);
    private static final SqlSessionUtil sessionUtil = new SqlSessionUtil();

    public Syllabus getById(Integer studentGroupId){
        if (studentGroupId <= 0) {
            throw new IllegalArgumentException("Invalid syllabus ID");
        }

        try (SqlSession session = sessionUtil.getSessionFactory().openSession()) {
            ISyllabusDAO syllabusDAO = session.getMapper(ISyllabusDAO.class);
            Syllabus syllabus = (Syllabus) syllabusDAO.getById(studentGroupId);
            session.commit();

            logger.info("Successfully retrieved Syllabus for StudentGroup: "  + syllabus.getStudentGroupId());
            return syllabus;
        }
    }

    public void update(Syllabus syllabus){
        validateSyllabus(syllabus);

        try (SqlSession session = sessionUtil.getSessionFactory().openSession()) {
            ISyllabusDAO syllabusDAO = session.getMapper(ISyllabusDAO.class);
            syllabusDAO.update(syllabus);
            session.commit();

            logger.info("Successfully Updated Syllabus for StudentGroup: " + syllabus.getStudentGroupId());
        }
    }


    public void deleteById(Integer studentGroupId){
        if (studentGroupId <= 0) {
            throw new IllegalArgumentException("Invalid Student Group ID");
        }

        Syllabus syllabus = getById(studentGroupId);

        try (SqlSession session = sessionUtil.getSessionFactory().openSession()) {
            ISyllabusDAO syllabusDAO = session.getMapper(ISyllabusDAO.class);

            syllabusDAO.deleteById(studentGroupId);
            session.commit();

            logger.info("Successfully deleted Syllabus for Student Group: " + syllabus.getStudentGroupId());
        }

    }

    public void insert(Syllabus syllabus){
        validateSyllabus(syllabus);

        try (SqlSession session = sessionUtil.getSessionFactory().openSession()) {
            ISyllabusDAO syllabusDAO = session.getMapper(ISyllabusDAO.class);

            syllabusDAO.insert(syllabus);
            session.commit();

            logger.info("Successfully saved Syllabus for Student Group: " + syllabus.getStudentGroupId());
        }
    }

    private void validateSyllabus(Syllabus syllabus) {
        Objects.requireNonNull(syllabus, "Cannot procede with a blank syllabus");

    }
}
