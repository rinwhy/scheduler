package com.solvd.scheduler.bin;

import java.util.ArrayList;
import java.util.List;

public class Syllabus {
    private int studentGroupId;
    private int subjectId;
    private String major;
    private List<Subject> syllabus;

    Syllabus(){
        syllabus = new ArrayList<>();
    }
    Syllabus (List<Subject> syllabus){
        this.syllabus = syllabus;
    }

    public int getStudentGroupId() {
        return studentGroupId;
    }

    public void setStudentGroupId(int studentGroupId) {
        this.studentGroupId = studentGroupId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public List<Subject> getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(List<Subject> syllabus) {
        this.syllabus = syllabus;
    }
}
