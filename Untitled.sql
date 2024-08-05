CREATE TABLE `user` (
  `id` varchar(255) PRIMARY KEY,
  `name` varchar(255),
  `email` varchar(255),
  `phone_number` varchar(255),
  `birth_place` varchar(255),
  `date_birth` time,
  `gender` varchar(255)
);

CREATE TABLE `students` (
  `id` varchar(255) PRIMARY KEY,
  `year` varchar(255),
  `class_id` varchar(255)
);

CREATE TABLE `teachers` (
  `id` varchar(255) PRIMARY KEY,
  `pwd` varchar(255)
);

CREATE TABLE `admin` (
  `id` varchar(255) PRIMARY KEY,
  `pwd` varchar(255)
);

CREATE TABLE `classes` (
  `id` varchar(255) PRIMARY KEY,
  `name` varchar(255)
);

CREATE TABLE `class_manager` (
  `class_id` varchar(255),
  `teacher_id` varchar(255),
  `subject_id` varchar(255),
  `time_start` time,
  `time_end` time
);

CREATE TABLE `subjects` (
  `id` varchar(255) PRIMARY KEY,
  `name` varchar(255),
  `semester` varchar(255)
);

CREATE TABLE `teacher_subject_manager` (
  `teacher_id` varchar(255),
  `subject_id` varchar(255)
);

CREATE TABLE `classes_student` (
  `student_id` varchar(255),
  `class_id` varchar(255),
  `date` timestamp,
  `status` ENUM ('P', 'PA', 'A')
);

CREATE TABLE `marks` (
  `student_id` varchar(255),
  `subject_name` varchar(255),
  `exam_name` varchar(255),
  `exam_time` time,
  `mark` float
);

ALTER TABLE `teachers` ADD FOREIGN KEY (`id`) REFERENCES `user` (`id`);

ALTER TABLE `class_manager` ADD FOREIGN KEY (`teacher_id`) REFERENCES `teachers` (`id`);

ALTER TABLE `class_manager` ADD FOREIGN KEY (`class_id`) REFERENCES `classes` (`id`);

ALTER TABLE `class_manager` ADD FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`id`);

ALTER TABLE `teacher_subject_manager` ADD FOREIGN KEY (`teacher_id`) REFERENCES `teachers` (`id`);

ALTER TABLE `teacher_subject_manager` ADD FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`id`);

ALTER TABLE `marks` ADD FOREIGN KEY (`student_id`) REFERENCES `students` (`id`);

ALTER TABLE `students` ADD FOREIGN KEY (`class_id`) REFERENCES `classes` (`id`);

ALTER TABLE `admin` ADD FOREIGN KEY (`id`) REFERENCES `user` (`id`);

ALTER TABLE `classes_student` ADD FOREIGN KEY (`student_id`) REFERENCES `students` (`id`);

ALTER TABLE `classes_student` ADD FOREIGN KEY (`class_id`) REFERENCES `classes` (`id`);

ALTER TABLE `students` ADD FOREIGN KEY (`id`) REFERENCES `user` (`id`);
