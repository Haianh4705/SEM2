/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hung.do_an;

import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    TeachersEntity() {
    }
    
    public synchronized static TeachersEntity getInstance() {
        if(instance == null) {
            instance = new TeachersEntity();
        }
        
        return instance;
    }

    @Override
    public List<Teachers> findAll() {
        List<Teachers> dataList = new ArrayList<>();
        
        openConnection();
        
        String sql = "select * from students";
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
        
        String sql = "insert into students(id, name, email, phone_number, birth_place, date_birth, gender, pwd, year, class_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
        
        String sql = "update students set name=?,email=?,phone_number=?,birth_place=?,date_birth=?,gender=?,year=?,class_id=? where id=?";
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
        
        String sql = "select * from teachers where id = ?";
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, item.getId());
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                itemFind = new Teachers(resultSet);
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeachersEntity.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        closeConnection();
        
        return itemFind;
    }
}
