/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.hung.do_an;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author student
 */
public class LoginController implements Initializable {

    /**
     * Initializes the controller class.
     */

    @FXML
    private TextField login_username;

    @FXML
    private PasswordField login_password;

    @FXML
    private Button login_button;

    @FXML
    void handleLoginButtonAction() {
        String username = login_username.getText();
        String password = login_password.getText();

        IdRole idRole = validateCredentials(username, password);
        if (idRole.role != null && idRole.id != null) {
            try {
                Stage stage = (Stage) login_button.getScene().getWindow();
                if (idRole.role.equals("ADMIN")) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("admin.fxml"));
                    Parent root = loader.load();
                    stage.setScene(new Scene(root, 1280, 720));
                } else if (idRole.role.equals("TEACHER")) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("teacher.fxml"));
                    Parent root = loader.load();
                    TeacherController controller = loader.getController();
                    controller.setTeacherId(String.valueOf(idRole.id));
                    stage.setScene(new Scene(root, 1280, 720));
                } else if (idRole.role.equals("STUDENT")) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("student.fxml"));
                    Parent root = loader.load();
                    StudentController controller = loader.getController();
                    controller.setStudentId(String.valueOf(idRole.id));
                    stage.setScene(new Scene(root, 1280, 720));
                }
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private IdRole validateCredentials(String username, String password) {
        final String HOST = "jdbc:mysql://localhost:3306/student_manager";
        final String USERNAME = "root";
        final String PASSWORD = "";
        IdRole idRole = new IdRole();
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            con = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
            String sql = "SELECT id FROM students WHERE name = ? AND pwd = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                idRole.id = resultSet.getString("id");
                idRole.role = "STUDENT";
            }
            else{
                sql = "SELECT id FROM teachers WHERE name = ? AND pwd = ?";
                statement = con.prepareStatement(sql);
                statement.setString(1, username);
                statement.setString(2, password);
                resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    idRole.id = resultSet.getString("id");
                    idRole.role = "TEACHER";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return idRole;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialization code if needed
    }

    class IdRole {
        String id;
        String role;
    }
}
