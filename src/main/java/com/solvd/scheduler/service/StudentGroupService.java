package com.solvd.scheduler.service;

import com.solvd.scheduler.Main;
import com.solvd.scheduler.bin.StudentGroup;
import com.solvd.scheduler.dao.iStudentGroupDAO;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

/*
 * Contains CRUD Functionality pertaining to Student and StudentGroups
 *
 * Get
 *
 * Insert
 *
 * Update
 *
 * Delete
 *
 */

public class StudentGroupService {

    private static final Logger logger = LogManager.getLogger(Main.class);
    private static final SqlSessionUtil sessionUtil = new SqlSessionUtil();

    public StudentGroup getById(Integer studentGroupId){

        if (studentGroupId <= 0) {
            throw new IllegalArgumentException("Invalid Student Group ID");
        }

        try (SqlSession session = sessionUtil.getSession()) {
            iStudentGroupDAO studentGroupDAO = session.getMapper(iStudentGroupDAO.class);
            StudentGroup studentGroup = (StudentGroup) studentGroupDAO.getById(studentGroupId);
            session.commit();

            logger.info("Successfully retrieved Student Group " + studentGroup.getId());
            return studentGroup;
        }
    }

    public void update(StudentGroup studentGroup){
        validateStudentGroup(studentGroup);

        try (SqlSession session = sessionUtil.getSession()) {
            iStudentGroupDAO studentGroupDAO = session.getMapper(iStudentGroupDAO.class);
            studentGroupDAO.update(studentGroup);
            session.commit();

            logger.info("Successfully Updated Student Group " + studentGroup.getId());
        }
    }


    public void deleteById(Integer studentGroupId){
        if (studentGroupId <= 0) {
            throw new IllegalArgumentException("Invalid StudentGroup ID");
        }

        StudentGroup studentGroup = getByStudentGroupId(studentGroupId);

        try (SqlSession session = sessionUtil.getSession()) {
            iStudentGroupDAO studentGroupDAO = session.getMapper(iStudentGroupDAO.class);

            studentGroupDAO.deleteById(studentGroupId);
            session.commit();

            logger.info("Successfully deleted Student Group " + studentGroup.getId());
        }
    }


    public void insert(StudentGroup studentGroup){
        validateStudentGroup(studentGroup);

        try (SqlSession session = sessionUtil.getSession()) {
            iStudentGroupDAO studentGroupDAO = session.getMapper(iStudentGroupDAO.class);

            studentGroupDAO.insert(studentGroup);
            session.commit();

            logger.info("Successfully saved Student Group " + studentGroup.getId());
        }
    }

    private void validateStudentGroup(StudentGroup studentGroup) {
        Objects.requireNonNull(studentGroup, "Cannot procede with a blank Student Group");

        if (Objects.isNull(getById(studentGroup.getId()))) {
            throw new RuntimeException("StudentGroup is not in the database, please insert into the database");
        }
    }
}
