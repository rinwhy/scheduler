package com.solvd.scheduler.bin;

import java.util.List;

public class Teacher {

    private int id;
    private String name;
    private List<Subject> subjects;         // subjects able to teach
    private int teachingExperience;        // years of experience
    private float ratingScore;          //rating will determine their priority for scheduling


    public Teacher() {
    }

    public Teacher(int id, String name, List<Subject> subjects, int teachingExperience, float ratingScore) {
        this.id = id;
        this.name = name;
        this.subjects = subjects;
        this.teachingExperience = teachingExperience;
        this.ratingScore = ratingScore;
    }
}
