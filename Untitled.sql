CREATE TABLE `students` (
  `id` varchar(255) PRIMARY KEY,
  `year` varchar(255),
  `class_id` varchar(255),
  `name` varchar(255),
  `email` varchar(255),
  `phone_number` varchar(255),
  `birth_place` varchar(255),
  `date_birth` datetime,
  `gender` varchar(255)
);

CREATE TABLE `teachers` (
  `id` varchar(255) PRIMARY KEY,
  `pwd` varchar(255),
  `name` varchar(255),
  `email` varchar(255),
  `phone_number` varchar(255),
  `birth_place` varchar(255),
  `date_birth` datetime,
  `gender` varchar(255)
);

CREATE TABLE `classes` (
  `id` varchar(255) PRIMARY KEY,
  `name` varchar(255),
  `semester` varchar(255),
  `teacher_id` varchar(255),
  `subject_id` varchar(255)
);

CREATE TABLE `subjects` (
  `id` varchar(255) PRIMARY KEY,
  `name` varchar(255)
);

CREATE TABLE `classes_student` (
  `student_id` varchar(255),
  `class_id` varchar(255),
  `date` datetime,
  `status` ENUM ('P', 'PA', 'A')
);

CREATE TABLE `marks` (
  `student_id` varchar(255),
  `subject_id` varchar(255),
  `mark` float
);

ALTER TABLE `teachers` ADD FOREIGN KEY (`id`) REFERENCES `user` (`id`);

ALTER TABLE `classes` ADD FOREIGN KEY (`teacher_id`) REFERENCES `teachers` (`id`);

ALTER TABLE `classes` ADD FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`id`);

ALTER TABLE `marks` ADD FOREIGN KEY (`student_id`) REFERENCES `students` (`id`);

ALTER TABLE `students` ADD FOREIGN KEY (`class_id`) REFERENCES `classes` (`id`);

ALTER TABLE `admin` ADD FOREIGN KEY (`id`) REFERENCES `user` (`id`);

ALTER TABLE `classes_student` ADD FOREIGN KEY (`student_id`) REFERENCES `students` (`id`);

ALTER TABLE `classes_student` ADD FOREIGN KEY (`class_id`) REFERENCES `classes` (`id`);

ALTER TABLE `students` ADD FOREIGN KEY (`id`) REFERENCES `user` (`id`);

ALTER TABLE `marks` ADD FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`id`);