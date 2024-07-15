/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hung.do_an;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author teacher
 * @param <T>
 */
public abstract class BaseEntity<T> {
    final String HOST = "jdbc:mysql://localhost:3308/student_manager";
    final String USERNAME = "root";
    final String PASSWORD = "";
    
    Connection con = null;
    PreparedStatement statement = null;

    public void openConnection() {
        try {
            con = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(BaseEntity.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void closeConnection() {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(BaseEntity.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BaseEntity.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public abstract List<T> findAll();
    public abstract void insert(T item);
    public abstract void update(T item);
    public abstract void delete(T item);
    public abstract T findById(T item);
}
