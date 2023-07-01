CREATE DATABASE IF NOT EXISTS teacher_scheduler;


USE teacher_scheduler;

CREATE TABLE course_slot (
course_slot_id INT(11) NOT NULL,
subject_id INT(11) NOT NULL,
period INT(11) NOT NULL,
`day` VARCHAR(45),
teachers_teacher_id INT(11) NOT NULL,
teachers_subject_id INT(11) NOT NULL,
student_group_id INT(11) NOT NULL,
PRIMARY KEY(course_slot_id, subject_id)
);

CREATE TABLE student_groups (
group_id INT(11) PRIMARY KEY NOT NULL,
num_students INT(11)
);

CREATE TABLE syllabus (
student_groups_group_id INT(11) NOT NULL,
subjects_subject_id INT(11) NOT NULL,
major VARCHAR(255),
PRIMARY KEY (student_groups_group_id, subjects_subject_id)
);

CREATE TABLE subjects (
subject_id INT(11) PRIMARY KEY NOT NULL,
subject_name VARCHAR(45)
);

CREATE TABLE teachers(
teacher_id INT(11) NOT NULL,
subjects_subject_id INT(11) NOT NULL,
`name` VARCHAR(45),
PRIMARY KEY(teacher_id, subjects_subject_id)
);