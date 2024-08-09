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

    public Students() {}

    public Students(int year, String class_id, String id, String name, String email, String phone_number, String birth_place, String date_birth, String gender) throws Exception {
        super(id, name, email, phone_number, birth_place, date_birth, gender);
        this.year = year;
        this.class_id = class_id;
    }
    
    public Students(ResultSet resultSet) {
        try {
            this.id = resultSet.getString("id");
            this.name = resultSet.getString("name");
            this.email = resultSet.getString("email");
            this.phone_number = resultSet.getString("phone_number");
            this.birth_place = resultSet.getString("birth_place");
            this.date_birth = resultSet.getString("date_birth");
            this.gender = resultSet.getString("gender");
            this.year = resultSet.getInt("year");
            this.class_id = resultSet.getString("class_id");
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
}
