/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hung.do_an;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author teacher
 */
public class TeachersEntity extends BaseEntity<Teachers>{
    private static TeachersEntity instance = null;
    
    private TeachersEntity() {
    }
    
    public synchronized static TeachersEntity getInstance() {
        if(instance == null) {
            instance = new TeachersEntity();
        }
        
        return instance;
    }

    public static List<Classes> getAllClass(String id) {
        List<Classes> dataList = new ArrayList<>();

        openConnection();

        String sql = "select * from classes where teacher_id = ?";
        try {

            statement = con.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                Classes classes = new Classes(resultSet);
                dataList.add(classes);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeachersEntity.class.getName()).log(Level.SEVERE, null, ex);
        }

        closeConnection();

        return dataList;
    }

    @Override
    public List<Teachers> findAll() {
        List<Teachers> dataList = new ArrayList<>();
        
        openConnection();
        
        String sql = "select * from Teachers";
        try {
            statement = con.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                Teachers teachers = new Teachers(resultSet);
                dataList.add(teachers);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeachersEntity.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        closeConnection();
        
        return dataList;
    }

    @Override
    public void insert(Teachers item) {
        openConnection();
        
        String sql = "insert into Teachers(id, name, email, phone_number, birth_place, date_birth, gender, pwd, year, class_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, item.getId());
            statement.setString(2, item.getName());
            statement.setString(3, item.getEmail());
            statement.setString(4, item.getPhone_number());
            statement.setString(5, item.getBirth_place());
            statement.setString(6, item.getDate_birth());
            statement.setString(7, item.getGender());
            statement.setString(8, item.getPwd());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TeachersEntity.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        closeConnection();
    }

    @Override
    public void update(Teachers item) {
        openConnection();
        
        String sql = "update Teachers set name=?,email=?,phone_number=?,birth_place=?,date_birth=?,gender=?,year=?,class_id=? where id=?";
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, item.getName());
            statement.setString(2, item.getEmail());
            statement.setString(3, item.getPhone_number());
            statement.setString(4, item.getBirth_place());
            statement.setString(5, item.getDate_birth());
            statement.setString(6, item.getGender());
            statement.setString(7, item.getPwd());
            statement.setString(8, item.getId());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TeachersEntity.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        closeConnection();
    }

    @Override
    public void delete(Teachers item) {
        openConnection();
        
        String sql = "delete from teachers where id=?";
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, item.getId());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TeachersEntity.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        closeConnection();
    }

    @Override
    public Teachers findById(Teachers item) {
        Teachers itemFind = null;

        openConnection();

        String sql_student = "SELECT * FROM Teachers WHERE id = ?";
        try {
            statement = con.prepareStatement(sql_student);
            statement.setString(1, item.getId());
            ResultSet resultSet_student = statement.executeQuery();
            itemFind = new Teachers(resultSet_student);
        } catch (SQLException ex) {
            Logger.getLogger(TeachersEntity.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
        return itemFind;
    }

    public Boolean changeAttenStatus(String id) {
        openConnection();

        String sql = "SELECT * FROM users JOIN teachers ON users.id = teachers.id WHERE users.id = ?";
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String dayOfAttendance = resultSet.getString("day_of_attendance");
                Boolean isStartAtten = resultSet.getBoolean("is_start_atten");

                // Lấy ngày hiện tại dưới dạng chuỗi
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String currentDay = LocalDate.now().format(formatter);

                if (currentDay.equals(dayOfAttendance)) {
                    // Ngày hiện tại giống với day_of_attendance
                    if (isStartAtten == null) {
                        isStartAtten = false;
                    } else {
                        isStartAtten = !isStartAtten;
                    }

                    // Cập nhật giá trị isStartAtten
                    String updateSql = "UPDATE teachers SET is_start_atten = ? WHERE id = ?";
                    PreparedStatement updateStatement = con.prepareStatement(updateSql);
                    updateStatement.setBoolean(1, isStartAtten);
                    updateStatement.setString(2, id);
                    updateStatement.executeUpdate();
                    updateStatement.close();

                } else {
                    // Ngày hiện tại khác với day_of_attendance
                    // Cập nhật day_of_attendance và đặt lại is_atten của tất cả sinh viên về false
                    String updateSql = "UPDATE teachers SET day_of_attendance = ?, is_start_atten = false WHERE id = ?";
                    PreparedStatement updateStatement = con.prepareStatement(updateSql);
                    updateStatement.setString(1, currentDay);
                    updateStatement.setString(2, id);
                    updateStatement.executeUpdate();
                    updateStatement.close();

                    // Đặt lại is_atten của tất cả sinh viên về false
                    String resetSql = "UPDATE students SET is_atten = false";
                    PreparedStatement resetStatement = con.prepareStatement(resetSql);
                    resetStatement.executeUpdate();
                    resetStatement.close();
                }
            }

            resultSet.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(StudentsEntity.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Students> findAllByClassId(String className, String teacherId) {
        List<Students> itemsFind = new ArrayList<>();

        openConnection();

        String sql = "SELECT * FROM students " +
                "JOIN classes_student ON students.id = classes_student.student_id " +
                "JOIN classes ON classes_student.class_id = classes.id " +
                "JOIN teachers ON classes.teacher_id = teachers.id " +
                "WHERE teachers.id = ? AND classes.name = ?";        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, teacherId);
            statement.setString(2, className);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Students student = new Students();
                student.setId(resultSet.getString("id"));
                student.setName(resultSet.getString("name"));
                student.setEmail(resultSet.getString("email"));
                student.setPhone_number(resultSet.getString("phone_number"));
                student.setBirth_place(resultSet.getString("birth_place"));
                student.setDate_birth(resultSet.getString("date_birth"));
                student.setYear(resultSet.getInt("year"));
                student.setClass_id(resultSet.getString("class_id"));
                // Thêm sinh viên vào danh sách
                itemsFind.add(student);
            }

            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentsEntity.class.getName()).log(Level.SEVERE, null, ex);
        }

        closeConnection();

        return itemsFind;
    }

}
