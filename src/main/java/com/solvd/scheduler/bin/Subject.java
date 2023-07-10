package com.solvd.scheduler.bin;

/**
 * Subject class represents an entity in the database
 * The Subject enum represents different subjects taught in the school curriculum
 * Each Subject represents a value in the database
 */
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
                "Ordinal ID=" + this.ordinal() + "  "+
                "subjectName='" + subjectName + '\'' +
                '}';
    }
}
