-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th8 11, 2024 lúc 12:21 PM
-- Phiên bản máy phục vụ: 10.4.28-MariaDB
-- Phiên bản PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `student_manager`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `classes`
--

CREATE TABLE `classes` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `semester` varchar(255) DEFAULT NULL,
  `teacher_id` varchar(255) DEFAULT NULL,
  `subject_id` varchar(255) DEFAULT NULL,
  `attendance_flag` tinyint(1) DEFAULT 0,
  `attendance_date` date DEFAULT curdate()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `classes`
--

INSERT INTO `classes` (`id`, `name`, `semester`, `teacher_id`, `subject_id`, `attendance_flag`, `attendance_date`) VALUES
('C001', 'Class A', '2024 Spring', 'T001', 'S001', 0, '2024-08-11'),
('C002', 'Class B', '2024 Spring', 'T001', 'S002', 0, '2024-08-11'),
('C003', 'Class C', '2024 Spring', 'T002', 'S003', 0, '2024-08-11'),
('C004', 'Class D', '2024 Spring', 'T003', 'S001', 0, '2024-08-11'),
('C005', 'Class E', '2024 Spring', 'T003', 'S002', 0, '2024-08-11');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `classes_student`
--

CREATE TABLE `classes_student` (
  `student_id` varchar(255) DEFAULT NULL,
  `class_id` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `status` enum('P','PA','A') DEFAULT NULL,
  `attendance_flag` tinyint(1) DEFAULT 0,
  `attendance_count` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `classes_student`
--

INSERT INTO `classes_student` (`student_id`, `class_id`, `date`, `status`, `attendance_flag`, `attendance_count`) VALUES
('S001', 'C001', '2024-01-10', 'P', 1, 15),
('S001', 'C002', '2024-01-12', 'P', 1, 1),
('S001', 'C003', '2024-01-14', 'P', 0, 0),
('S002', 'C001', '2024-01-11', 'P', 0, 1),
('S002', 'C003', '2024-01-13', 'P', 0, 0),
('S002', 'C004', '2024-01-15', 'P', 0, 0),
('S003', 'C002', '2024-01-16', 'P', 0, 0),
('S003', 'C003', '2024-01-18', 'P', 0, 0),
('S003', 'C005', '2024-01-20', 'P', 0, 0),
('S004', 'C001', '2024-01-21', 'P', 0, 1),
('S004', 'C002', '2024-01-23', 'P', 1, 1),
('S004', 'C004', '2024-01-25', 'P', 0, 0),
('S005', 'C001', '2024-01-26', 'P', 0, 0),
('S005', 'C003', '2024-01-28', 'P', 0, 0),
('S005', 'C005', '2024-01-30', 'P', 0, 0),
('S006', 'C002', '2024-01-31', 'P', 0, 0),
('S006', 'C003', '2024-02-02', 'P', 0, 0),
('S006', 'C004', '2024-02-04', 'P', 0, 0),
('S007', 'C001', '2024-02-05', 'P', 0, 0),
('S007', 'C004', '2024-02-07', 'P', 0, 0),
('S007', 'C005', '2024-02-09', 'P', 0, 0),
('S008', 'C002', '2024-02-10', 'P', 0, 0),
('S008', 'C003', '2024-02-12', 'P', 0, 0),
('S008', 'C005', '2024-02-14', 'P', 0, 0),
('S009', 'C001', '2024-02-15', 'P', 0, 0),
('S009', 'C002', '2024-02-17', 'P', 0, 0),
('S009', 'C004', '2024-02-19', 'P', 0, 0),
('S010', 'C003', '2024-02-20', 'P', 0, 0),
('S010', 'C004', '2024-02-22', 'P', 0, 0),
('S010', 'C005', '2024-02-24', 'P', 0, 0),
('S011', 'C001', '2024-02-25', 'P', 0, 0),
('S011', 'C002', '2024-02-27', 'P', 0, 0),
('S011', 'C003', '2024-03-01', 'P', 0, 0),
('S012', 'C002', '2024-03-02', 'P', 0, 0),
('S012', 'C003', '2024-03-04', 'P', 0, 0),
('S012', 'C005', '2024-03-06', 'P', 0, 0),
('S013', 'C001', '2024-03-07', 'P', 0, 0),
('S013', 'C002', '2024-03-09', 'P', 0, 0),
('S013', 'C004', '2024-03-11', 'P', 0, 0),
('S014', 'C003', '2024-03-12', 'P', 0, 0),
('S014', 'C004', '2024-03-14', 'P', 0, 0),
('S014', 'C005', '2024-03-16', 'P', 0, 0),
('S015', 'C001', '2024-03-17', 'P', 0, 0),
('S015', 'C002', '2024-03-19', 'P', 0, 0),
('S015', 'C003', '2024-03-21', 'P', 0, 0),
('S016', 'C002', '2024-03-22', 'P', 0, 0),
('S016', 'C003', '2024-03-24', 'P', 0, 0),
('S016', 'C005', '2024-03-26', 'P', 0, 0),
('S017', 'C001', '2024-03-27', 'P', 0, 0),
('S017', 'C004', '2024-03-29', 'P', 0, 0),
('S017', 'C005', '2024-03-31', 'P', 0, 0),
('S018', 'C002', '2024-04-01', 'P', 0, 0),
('S018', 'C003', '2024-04-03', 'P', 0, 0),
('S018', 'C004', '2024-04-05', 'P', 0, 0),
('S019', 'C001', '2024-04-06', 'P', 0, 0),
('S019', 'C002', '2024-04-08', 'P', 0, 0),
('S019', 'C003', '2024-04-10', 'P', 0, 0),
('S020', 'C004', '2024-04-11', 'P', 0, 0),
('S020', 'C005', '2024-04-13', 'P', 0, 0),
('S020', 'C001', '2024-04-15', 'P', 0, 0),
('S021', 'C002', '2024-04-16', 'P', 0, 0),
('S021', 'C003', '2024-04-18', 'P', 0, 0),
('S021', 'C005', '2024-04-20', 'P', 0, 0),
('S022', 'C001', '2024-04-21', 'P', 0, 0),
('S022', 'C003', '2024-04-23', 'P', 0, 0),
('S022', 'C004', '2024-04-25', 'P', 0, 0),
('S023', 'C002', '2024-04-26', 'P', 0, 0),
('S023', 'C003', '2024-04-28', 'P', 0, 0),
('S023', 'C005', '2024-04-30', 'P', 0, 0),
('S024', 'C001', '2024-05-01', 'P', 0, 0),
('S024', 'C002', '2024-05-03', 'P', 0, 0),
('S024', 'C004', '2024-05-05', 'P', 0, 0),
('S025', 'C003', '2024-05-06', 'P', 0, 0),
('S025', 'C004', '2024-05-08', 'P', 0, 0),
('S025', 'C005', '2024-05-10', 'P', 0, 0),
('S026', 'C001', '2024-05-11', 'P', 0, 0),
('S026', 'C002', '2024-05-13', 'P', 0, 0),
('S026', 'C003', '2024-05-15', 'P', 0, 0),
('S027', 'C002', '2024-05-16', 'P', 0, 0),
('S027', 'C004', '2024-05-18', 'P', 0, 0),
('S027', 'C005', '2024-05-20', 'P', 0, 0),
('S028', 'C001', '2024-05-21', 'P', 0, 0),
('S028', 'C003', '2024-05-23', 'P', 0, 0),
('S028', 'C004', '2024-05-25', 'P', 0, 0),
('S029', 'C002', '2024-05-26', 'P', 0, 0),
('S029', 'C003', '2024-05-28', 'P', 0, 0),
('S029', 'C005', '2024-05-30', 'P', 0, 0),
('S030', 'C003', '2024-05-31', 'P', 0, 0),
('S030', 'C004', '2024-06-02', 'P', 0, 0),
('S030', 'C005', '2024-06-04', 'P', 0, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `marks`
--

CREATE TABLE `marks` (
  `student_id` varchar(255) DEFAULT NULL,
  `subject_id` varchar(255) DEFAULT NULL,
  `mark` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `marks`
--

INSERT INTO `marks` (`student_id`, `subject_id`, `mark`) VALUES
('S001', 'SUBJ001', 85),
('S001', 'SUBJ002', 78),
('S002', 'SUBJ001', 90),
('S002', 'SUBJ003', 88),
('S003', 'SUBJ002', 92),
('S003', 'SUBJ004', 81),
('S004', 'SUBJ001', 87),
('S004', 'SUBJ003', 79),
('S005', 'SUBJ002', 86),
('S005', 'SUBJ005', 83),
('S006', 'SUBJ001', 84),
('S006', 'SUBJ004', 77),
('S007', 'SUBJ003', 89),
('S007', 'SUBJ005', 85),
('S008', 'SUBJ001', 91),
('S008', 'SUBJ002', 82),
('S009', 'SUBJ003', 88),
('S009', 'SUBJ004', 80),
('S010', 'SUBJ005', 93),
('S010', 'SUBJ001', 76),
('S011', 'SUBJ002', 89),
('S011', 'SUBJ003', 81),
('S012', 'SUBJ004', 84),
('S012', 'SUBJ005', 78),
('S013', 'SUBJ001', 87),
('S013', 'SUBJ002', 90),
('S014', 'SUBJ003', 92),
('S014', 'SUBJ004', 85),
('S015', 'SUBJ005', 88),
('S015', 'SUBJ001', 82),
('S016', 'SUBJ002', 89),
('S016', 'SUBJ003', 84),
('S017', 'SUBJ004', 87),
('S017', 'SUBJ005', 86),
('S018', 'SUBJ001', 80),
('S018', 'SUBJ002', 75),
('S019', 'SUBJ003', 79),
('S019', 'SUBJ004', 82),
('S020', 'SUBJ005', 89),
('S020', 'SUBJ001', 88),
('S021', 'SUBJ002', 90),
('S021', 'SUBJ003', 87),
('S022', 'SUBJ004', 85),
('S022', 'SUBJ005', 83),
('S023', 'SUBJ001', 91),
('S023', 'SUBJ002', 76),
('S024', 'SUBJ003', 85),
('S024', 'SUBJ004', 84),
('S025', 'SUBJ005', 82),
('S025', 'SUBJ001', 89),
('S026', 'SUBJ002', 90),
('S026', 'SUBJ003', 87),
('S027', 'SUBJ004', 86),
('S027', 'SUBJ005', 83),
('S028', 'SUBJ001', 91),
('S028', 'SUBJ002', 88),
('S029', 'SUBJ003', 85),
('S029', 'SUBJ004', 82),
('S030', 'SUBJ005', 80);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `students`
--

CREATE TABLE `students` (
  `id` varchar(255) NOT NULL,
  `year` varchar(255) DEFAULT NULL,
  `class_id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `birth_place` varchar(255) DEFAULT NULL,
  `date_birth` date DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `students`
--

INSERT INTO `students` (`id`, `year`, `class_id`, `name`, `email`, `phone_number`, `birth_place`, `date_birth`, `gender`, `pwd`) VALUES
('S001', '2024', NULL, 'Student1', 'student1@school.com', '1234500001', 'CityX', '2005-01-01', 'M', '123'),
('S002', '2024', NULL, 'Student2', 'student2@school.com', '1234500002', 'CityY', '2005-02-01', 'F', '123'),
('S003', '2024', NULL, 'Student3', 'student3@school.com', '1234500003', 'CityZ', '2005-03-01', 'M', '123'),
('S004', '2024', NULL, 'Student4', 'student4@school.com', '1234500004', 'CityA', '2005-04-01', 'F', '123'),
('S005', '2024', NULL, 'Student5', 'student5@school.com', '1234500005', 'CityB', '2005-05-01', 'M', '123'),
('S006', '2024', NULL, 'Student6', 'student6@school.com', '1234500006', 'CityC', '2005-06-01', 'F', '123'),
('S007', '2024', NULL, 'Student7', 'student7@school.com', '1234500007', 'CityD', '2005-07-01', 'M', '123'),
('S008', '2024', NULL, 'Student8', 'student8@school.com', '1234500008', 'CityE', '2005-08-01', 'F', '123'),
('S009', '2024', NULL, 'Student9', 'student9@school.com', '1234500009', 'CityF', '2005-09-01', 'M', '123'),
('S010', '2024', NULL, 'Student10', 'student10@school.com', '1234500010', 'CityG', '2005-10-01', 'F', '123'),
('S011', '2024', NULL, 'Student11', 'student11@school.com', '1234500011', 'CityH', '2005-11-01', 'M', '123'),
('S012', '2024', NULL, 'Student12', 'student12@school.com', '1234500012', 'CityI', '2005-12-01', 'F', '123'),
('S013', '2024', NULL, 'Student13', 'student13@school.com', '1234500013', 'CityJ', '2005-01-15', 'M', '123'),
('S014', '2024', NULL, 'Student14', 'student14@school.com', '1234500014', 'CityK', '2005-02-15', 'F', '123'),
('S015', '2024', NULL, 'Student15', 'student15@school.com', '1234500015', 'CityL', '2005-03-15', 'M', '123'),
('S016', '2024', NULL, 'Student16', 'student16@school.com', '1234500016', 'CityM', '2005-04-15', 'F', '123'),
('S017', '2024', NULL, 'Student17', 'student17@school.com', '1234500017', 'CityN', '2005-05-15', 'M', '123'),
('S018', '2024', NULL, 'Student18', 'student18@school.com', '1234500018', 'CityO', '2005-06-15', 'F', '123'),
('S019', '2024', NULL, 'Student19', 'student19@school.com', '1234500019', 'CityP', '2005-07-15', 'M', '123'),
('S020', '2024', NULL, 'Student20', 'student20@school.com', '1234500020', 'CityQ', '2005-08-15', 'F', '123'),
('S021', '2024', NULL, 'Student21', 'student21@school.com', '1234500021', 'CityR', '2005-09-15', 'M', '123'),
('S022', '2024', NULL, 'Student22', 'student22@school.com', '1234500022', 'CityS', '2005-10-15', 'F', '123'),
('S023', '2024', NULL, 'Student23', 'student23@school.com', '1234500023', 'CityT', '2005-11-15', 'M', '123'),
('S024', '2024', NULL, 'Student24', 'student24@school.com', '1234500024', 'CityU', '2005-12-15', 'F', '123'),
('S025', '2024', NULL, 'Student25', 'student25@school.com', '1234500025', 'CityV', '2005-01-25', 'M', '123'),
('S026', '2024', NULL, 'Student26', 'student26@school.com', '1234500026', 'CityW', '2005-02-25', 'F', '123'),
('S027', '2024', NULL, 'Student27', 'student27@school.com', '1234500027', 'CityX', '2005-03-25', 'M', '123'),
('S028', '2024', NULL, 'Student28', 'student28@school.com', '1234500028', 'CityY', '2005-04-25', 'F', '123'),
('S029', '2024', NULL, 'Student29', 'student29@school.com', '1234500029', 'CityZ', '2005-05-25', 'M', '123'),
('S030', '2024', NULL, 'Student30', 'student30@school.com', '1234500030', 'CityA', '2005-06-01', 'M', '123');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `subjects`
--

CREATE TABLE `subjects` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `subjects`
--

INSERT INTO `subjects` (`id`, `name`) VALUES
('S001', 'Mathematics'),
('S002', 'Science'),
('S003', 'History'),
('SUBJ001', 'Mathematics'),
('SUBJ002', 'Physics'),
('SUBJ003', 'Chemistry'),
('SUBJ004', 'Biology'),
('SUBJ005', 'History');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `teachers`
--

CREATE TABLE `teachers` (
  `id` varchar(255) NOT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `birth_place` varchar(255) DEFAULT NULL,
  `date_birth` date DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `teachers`
--

INSERT INTO `teachers` (`id`, `pwd`, `name`, `email`, `phone_number`, `birth_place`, `date_birth`, `gender`) VALUES
('T001', '123', 'Teacher1', 'teacher1@school.com', '1234567891', 'CityA', '1980-05-10', 'F'),
('T002', '123', 'Teacher2', 'teacher2@school.com', '1234567892', 'CityB', '1985-07-15', 'M'),
('T003', '123', 'Teacher3', 'teacher3@school.com', '1234567893', 'CityC', '1975-02-20', 'F');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `classes`
--
ALTER TABLE `classes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `teacher_id` (`teacher_id`),
  ADD KEY `subject_id` (`subject_id`);

--
-- Chỉ mục cho bảng `classes_student`
--
ALTER TABLE `classes_student`
  ADD KEY `student_id` (`student_id`),
  ADD KEY `class_id` (`class_id`);

--
-- Chỉ mục cho bảng `marks`
--
ALTER TABLE `marks`
  ADD KEY `student_id` (`student_id`),
  ADD KEY `subject_id` (`subject_id`);

--
-- Chỉ mục cho bảng `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id`),
  ADD KEY `class_id` (`class_id`);

--
-- Chỉ mục cho bảng `subjects`
--
ALTER TABLE `subjects`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `teachers`
--
ALTER TABLE `teachers`
  ADD PRIMARY KEY (`id`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `classes`
--
ALTER TABLE `classes`
  ADD CONSTRAINT `classes_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teachers` (`id`),
  ADD CONSTRAINT `classes_ibfk_2` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`id`);

--
-- Các ràng buộc cho bảng `classes_student`
--
ALTER TABLE `classes_student`
  ADD CONSTRAINT `classes_student_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `students` (`id`),
  ADD CONSTRAINT `classes_student_ibfk_2` FOREIGN KEY (`class_id`) REFERENCES `classes` (`id`);

--
-- Các ràng buộc cho bảng `marks`
--
ALTER TABLE `marks`
  ADD CONSTRAINT `marks_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `students` (`id`),
  ADD CONSTRAINT `marks_ibfk_2` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`id`);

--
-- Các ràng buộc cho bảng `students`
--
ALTER TABLE `students`
  ADD CONSTRAINT `students_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `classes` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
