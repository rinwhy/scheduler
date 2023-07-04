package com.solvd.scheduler.utils;

public class tempmain {
    public static void main(String[] args) {
        /*List<Integer> temp= InputUtil.getInputs();
        System.out.println(temp);
        List<Teacher> teachers;
        teachers = utils.TeacherBuilder.buildTeachers(temp.get(0));
        teachers.forEach(teacher -> {
            System.out.println(teacher.getId() + " " + teacher.getName() + " " + teacher.getTeachingSubject());
        });*/
        String[][] test = {
                {"8AM-9:30AM","1A", "Science", "English", "", "History"},
                {"9:30AM - 12PM", "2A,1B", "History","Math", "English", ""},
                {"9:30AM - 12PM", "3A,1C,2B", "History","Math", "English", ""},
                {"9:30AM - 12PM", "4A,1D,3B,2C", "History","Math", "English", ""},
                {"9:30AM - 12PM", "4B,3C,2D", "History","Math", "English", ""},
                {"9:30AM - 12PM", "4C,3D", "History","Math", "English", ""},
                {"9:30AM - 12PM", "4D", "History","Math", "English", ""},
                {"9:30AM - 12PM", "", "History","Math", "English", ""},

        };
//        SchedulePrinter.printSchedule(test);
    }
}
