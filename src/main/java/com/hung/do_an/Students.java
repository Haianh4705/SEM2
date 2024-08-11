/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hung.do_an;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class Students extends Users{
    int year;
    String class_id;
    Boolean attendanceFlag;
    int attendanceCount;

    public Boolean getAttendanceFlag() {
        return attendanceFlag;
    }

    public void setAttendanceFlag(Boolean attendanceFlag) {
        this.attendanceFlag = attendanceFlag;
    }

    public int getAttendanceCount() {
        return attendanceCount;
    }

    public void setAttendanceCount(int attendanceCount) {
        this.attendanceCount = attendanceCount;
    }

    public Students() {
    }

    public Students(String id){
        this.id = id;
    }

    public Students(int year, String class_id, String attendance) {
        this.year = year;
        this.class_id = class_id;
    }


    public Students(int year, String class_id, String id, String name, String email, String phone_number, String birth_place, String date_birth, String gender, String pwd) throws Exception {
        super(id, name, email, phone_number, birth_place, date_birth, gender, pwd);
        this.year = year;
        this.class_id = class_id;
    }

    public Students(int id) {

    }

    public Students(ResultSet resultSet) {
        try {
            if (resultSet.next()) {  // Di chuyển con trỏ đến bản ghi đầu tiên
                this.id = resultSet.getString("id");
                this.name = resultSet.getString("name");
                this.email = resultSet.getString("email");
                this.phone_number = resultSet.getString("phone_number");
                this.birth_place = resultSet.getString("birth_place");
                this.date_birth = resultSet.getString("date_birth");
                this.gender = resultSet.getString("gender");
                this.pwd = resultSet.getString("pwd");
                this.year = resultSet.getInt("year");
                this.class_id = resultSet.getString("class_id");
//                this.attendanceCount = resultSet.getInt("attendance_count");
//                this.attendanceFlag = resultSet.getBoolean("attendance_flag");
            } else {
                throw new SQLException("No data in ResultSet");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Students(ResultSet resultSet_user,ResultSet resultSet_student) {
        try {
            if(resultSet_user.next()){
                this.id = resultSet_user.getString("id");
                this.name = resultSet_user.getString("name");
                this.email = resultSet_user.getString("email");
                this.phone_number = resultSet_user.getString("phone_number");
                this.birth_place = resultSet_user.getString("birth_place");
                this.date_birth = resultSet_user.getString("date_birth");
                this.gender = resultSet_user.getString("gender");
                this.pwd = resultSet_user.getString("pwd");
            }if(resultSet_student.next()){
                this.year = resultSet_student.getInt("year");
                this.class_id = resultSet_student.getString("class_id");
            }


        } catch (SQLException ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPhone_number() {
        return phone_number;
    }

    @Override
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String getBirth_place() {
        return birth_place;
    }

    @Override
    public void setBirth_place(String birth_place) {
        this.birth_place = birth_place;
    }

    @Override
    public String getDate_birth() {
        return date_birth;
    }

    @Override
    public void setDate_birth(String date_birth) {
        this.date_birth = date_birth;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String getPwd() {
        return pwd;
    }

    @Override
    public void setPwd(String pwd) {
        try {
            this.pwd = encrypt(pwd);
        } catch (Exception ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
