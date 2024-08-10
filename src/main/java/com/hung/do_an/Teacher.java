/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hung.do_an;

import java.sql.ResultSet;
import java.time.LocalDate;

/**
 *
 * @author HaiAnh
 */
public class Teacher {
    String id, name, pwd, email, phone_number, birth_place, gender;
    LocalDate date_birth;
    
    public Teacher() {}
    
    public Teacher(ResultSet res) throws Exception {
        this.id = res.getString("id");
        this.name = res.getString("name");
        this.pwd = res.getString("pwd");
        this.email = res.getString("email");
        this.phone_number = res.getString("phone_number");
        this.birth_place = res.getString("birth_place");
        this.date_birth = res.getDate("date_birth").toLocalDate();
        this.gender = res.getString("gender");
    }

    public LocalDate getDate_birth() {
        return date_birth;
    }

    public void setDate_birth(LocalDate date_birth) {
        this.date_birth = date_birth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getBirth_place() {
        return birth_place;
    }

    public void setBirth_place(String birth_place) {
        this.birth_place = birth_place;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
