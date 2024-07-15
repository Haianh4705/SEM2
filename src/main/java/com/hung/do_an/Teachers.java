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
public class Teachers extends Users {

    public Teachers() {
    }

    public Teachers(ResultSet resultSet) {
        try {
            this.id = resultSet.getString("id");
            this.name = resultSet.getString("name");
            this.email = resultSet.getString("email");
            this.phone_number = resultSet.getString("phone_number");
            this.birth_place = resultSet.getString("birth_place");
            this.date_birth = resultSet.getString("date_birth");
            this.gender = resultSet.getString("gender");
            this.pwd = resultSet.getString("pwd");
        } catch (SQLException ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        this.pwd = pwd;
    }

}
