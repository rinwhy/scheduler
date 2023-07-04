package com.solvd.scheduler.service;

import com.solvd.scheduler.Main;
import com.solvd.scheduler.bin.Syllabus;
import com.solvd.scheduler.dao.iSyllabusDAO;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Objects;

public class SyllabusService {

    private static final Logger logger = LogManager.getLogger(Main.class);
    private static final SqlSessionUtil sessionUtil = new SqlSessionUtil();

    public Syllabus getById(Integer studentGroupId){
        if (studentGroupId <= 0) {
            throw new IllegalArgumentException("Invalid syllabus ID");
        }

        try (SqlSession session = sessionUtil.getSession()) {
            iSyllabusDAO syllabusDAO = session.getMapper(iSyllabusDAO.class);
            Syllabus syllabus = (Syllabus) syllabusDAO.getById(studentGroupId);
            session.commit();

            logger.info("Successfully retrieved Syllabus for StudentGroup: "  + syllabus.getStudentGroupId());
            return syllabus;
        }
    }

    public void update(Syllabus syllabus){
        validateSyllabus(syllabus);

        try (SqlSession session = sessionUtil.getSession()) {
            iSyllabusDAO syllabusDAO = session.getMapper(iSyllabusDAO.class);
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

        try (SqlSession session = sessionUtil.getSession()) {
            iSyllabusDAO syllabusDAO = session.getMapper(iSyllabusDAO.class);

            syllabusDAO.deleteById(studentGroupId);
            session.commit();

            logger.info("Successfully deleted Syllabus for Student Group: " + syllabus.getStudentGroupId());
        }

    }

    public void insert(Syllabus syllabus){
        validateSyllabus(syllabus);

        try (SqlSession session = sessionUtil.getSession()) {
            iSyllabusDAO syllabusDAO = session.getMapper(iSyllabusDAO.class);

            syllabusDAO.insert(syllabus);
            session.commit();

            logger.info("Successfully saved Syllabus for Student Group: " + syllabus.getStudentGroupId());
        }
    }

    public List<Syllabus> getAll() {

        try (SqlSession session = sessionUtil.getSession()) {
            iSyllabusDAO syllabusDAO = session.getMapper(iSyllabusDAO.class);

            List<Syllabus> syllabuses = syllabusDAO.getAll();

            if (syllabuses.isEmpty()) {
                logger.info("No Syllabuses in Database");
                throw new RuntimeException("No Syllabuses in Database");
            }

            logger.info("Successfully retrieved all Syllabuses in database");
            return syllabuses;
        }
    }

    private void validateSyllabus(Syllabus syllabus) {
        Objects.requireNonNull(syllabus, "Cannot procede with a blank syllabus");

        if (syllabus.getSyllabus().isEmpty()) {
            throw new RuntimeException("Syllabus is not in the database, please insert into the database");
        }
    }


}
