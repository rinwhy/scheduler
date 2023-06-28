package com.solvd.scheduler.bin;

public enum Subject {
    ALGEBRA("Algebra", 1),
    GEOMETRY("Geometry", 2),
    TRIGONOMETRY("Trigonometry", 3),
    CALCULUS("Calculus", 4),

    EARTH_SCIENCE("Earth Science", 1),
    BIOLOGY("Biology", 2),
    CHEMISTRY("Chemistry", 3),
    PHYSICS("Physics", 4),

    AMERICAN_LITERATURE("American Literature", 1),
    CREATIVE_WRITING("Creative Writing", 2),
    JOURNALISM("Journalism", 3),
    DEBATE("Debate", 4),

    WORLD_HISTORY("World History", 1),
    AMERICAN_HISTORY("American History", 2),
    US_GOVERNMENT("US Government", 3),
    ECONOMICS("Economics", 4);

    private final String subjectName;
    private final int subjectDifficulty;

    Subject(String subjectName, int subjectDifficulty) {
        this.subjectName = subjectName;
        this.subjectDifficulty = subjectDifficulty;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public int getSubjectDifficulty() {
        return subjectDifficulty;
    }

}
