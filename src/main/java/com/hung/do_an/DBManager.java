/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hung.do_an;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author HaiAnh
 */
public class DBManager {
    private static final String URL = "jdbc:mysql://localhost:3306/student_manager";
    private static final String USER = "root";
    private static final String PWD = "";
    
    Connection conn = null;
    PreparedStatement stmt = null;
    
    public void connectDB() throws Exception {
        conn = DriverManager.getConnection(URL, USER, PWD);
    }
    
    public void closeDB() throws Exception {
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
}
