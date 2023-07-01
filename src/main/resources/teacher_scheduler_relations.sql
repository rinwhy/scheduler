USE teacher_scheduler;

-- Teachers
ALTER TABLE teachers ADD FOREIGN KEY (subjects_subject_id) REFERENCES subjects (subject_id);

--Syllabus
ALTER TABLE syllabus ADD FOREIGN KEY (student_groups_group_id) REFERENCES student_groups (group_id);
ALTER TABLE syllabus ADD FOREIGN KEY (subjects_subject_id) REFERENCES subjects (subject_id);

--Course Slot
ALTER TABLE course_slot ADD FOREIGN KEY (subject_id) REFERENCES subjects (subject_id);

ALTER TABLE course_slot
ADD FOREIGN KEY (teachers_teacher_id) REFERENCES teachers (teacher_id),
ADD FOREIGN KEY (teachers_subject_id) REFERENCES teachers (subjects_subject_id);

ALTER TABLE course_slot ADD FOREIGN KEY (student_group_id) REFERENCES student_groups (group_id);