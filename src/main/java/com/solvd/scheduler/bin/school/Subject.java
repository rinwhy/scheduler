package com.solvd.scheduler.bin.school;

public enum Subject {
    MATH("Math"),
    SCIENCE("Science"),
    ENGLISH("English"),
    HISTORY("History"),
    FOREIGN_LANGUAGE("Foreign Languages"),
    TECHNOLOGY("Technology"),
    ART("Art"),
    PHYSICAL_EDUCATION("Physical Education");


    private final String subjectName;

    Subject(String subjectName) {
        this.subjectName = subjectName;
    }


    public String getSubjectName() {
        return subjectName;
    }
}
