package com.solvd.scheduler.bin;

public enum Subject {
    MATH("Math"),
    SCIENCE("Science"),
    ENGLISH("English"),
    HISTORY("History"),
    FOREIGN_LANGUAGE("Languages"),
    TECHNOLOGY("Tech"),
    ART("Art"),
    PHYSICAL_EDUCATION("P.E");


    private final String subjectName;



    Subject(String subjectName) {
        this.subjectName = subjectName;
    }


    public String getSubjectName() {
        return subjectName;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectName='" + subjectName + '\'' +
                '}';
    }
}
