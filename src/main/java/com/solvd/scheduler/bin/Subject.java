package com.solvd.scheduler.bin;

public enum Subject {
    MATH("Math",1 ),
    SCIENCE("Science",2),
    ENGLISH("English",3),
    HISTORY("History",4),
    FOREIGN_LANGUAGE("Languages",5),
    TECHNOLOGY("Tech",6),
    ART("Art",7),
    PHYSICAL_EDUCATION("P.E",8);


    private final String subjectName;
    private final int id;

    Subject(String subjectName, int id) {
        this.subjectName = subjectName;
        this.id = id;
    }


    public String getSubjectName() {
        return subjectName;
    }
    public int getId(){
        return id;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectName='" + subjectName + '\'' +
                ", id=" + id +
                '}';
    }
}
