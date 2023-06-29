package com.solvd.scheduler.bin.school;

public enum Course {

    //maths
    ALGEBRA(Subject.MATH, "Algebra", 1),
    GEOMETRY(Subject.MATH, "Geometry", 2),
    TRIGONOMETRY(Subject.MATH, "Trigonometry", 3),
    CALCULUS(Subject.MATH, "Calculus", 4),

    //science
    EARTH_SCIENCE(Subject.SCIENCE, "Earth Science", 1),
    BIOLOGY(Subject.SCIENCE, "Biology", 2),
    CHEMISTRY(Subject.SCIENCE, "Chemistry", 3),
    PHYSICS(Subject.SCIENCE, "Physics", 4),

    //english
    AMERICAN_LITERATURE(Subject.ENGLISH, "American Literature", 1),
    CREATIVE_WRITING(Subject.ENGLISH, "Creative Writing", 2),
    JOURNALISM(Subject.ENGLISH, "Journalism", 3),
    DEBATE(Subject.ENGLISH, "Debate", 4),

    //history
    WORLD_HISTORY(Subject.HISTORY, "World History", 1),
    AMERICAN_HISTORY(Subject.HISTORY, "American History", 2),
    US_GOVERNMENT(Subject.HISTORY, "US Government", 3),
    ECONOMICS(Subject.HISTORY, "Economics", 4),

    //foreign languages
    SPANISH_ONE(Subject.FOREIGN_LANGUAGE, "Spanish", 1),
    SPANISH_TWO(Subject.FOREIGN_LANGUAGE, "Spanish 2", 2),
    FRENCH_ONE(Subject.FOREIGN_LANGUAGE, "French", 3),
    FRENCH_TWO(Subject.FOREIGN_LANGUAGE, "French 2", 4),

    // technology
    INTRO_TO_CS(Subject.TECHNOLOGY, "Introduction to CS", 1),
    PROGRAMMING(Subject.TECHNOLOGY, "Programming", 2),
    INTRO_TO_ROBOTICS(Subject.TECHNOLOGY, "Introduction to Robotics", 3),
    ENGINEERING_DESIGN_DEVELOPMENT(Subject.TECHNOLOGY, "Engineering Design and Development", 4),

    //arts
    ART(Subject.ART, "Art", 1),
    MUSIC_THEORY(Subject.ART, "Music Theory", 2),
    BAND(Subject.ART, "Band", 3),
    THEATER(Subject.ART, "Theater", 4),

    //Physical Education
    HEALTH(Subject.PHYSICAL_EDUCATION, "Health", 1),
    AEROBICS(Subject.PHYSICAL_EDUCATION, "Aerobics", 2),
    WEIGHT_TRAINING(Subject.PHYSICAL_EDUCATION, "Weight Training", 3),
    TEAM_SPORTS(Subject.PHYSICAL_EDUCATION, "Team Sports", 4);


    private final Subject subjectType;
    private final String courseName;
    private final int subjectDifficulty;

    Course(Subject subjectType, String courseName, int subjectDifficulty) {
        this.subjectType = subjectType;
        this.courseName = courseName;
        this.subjectDifficulty = subjectDifficulty;
    }

    public Subject getSubjectType() {
        return subjectType;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getSubjectDifficulty() {
        return subjectDifficulty;
    }

}
