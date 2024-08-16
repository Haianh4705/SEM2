package com.hung.do_an;

import java.sql.ResultSet;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class LoginController {

    @FXML
    private Button login_button;

    @FXML
    private ImageView login_icon;

    @FXML
    private ImageView login_image;

    @FXML
    private PasswordField login_password;

    @FXML
    private TextField login_username;

    @FXML
    void handleLogin(MouseEvent event) {
        String username = login_username.getText();
        String password = login_password.getText();
        
        DBManager db = new DBManager();
        ResultSet res = null;
        String sql = "select id from teachers where name = ? and pwd = ?";
        
        try {
            db.connectDB();
            db.stmt = db.conn.prepareStatement(sql);
            db.stmt.setString(1, username);
            db.stmt.setString(2, password);
            res = db.stmt.executeQuery();
            
            if (res.next()) {
                App.setRoot("teacher");
            } else {
                if (username.equals("ADMIN1") && password.equals("123456")) {
                    App.setRoot("admin");
                } else {
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Popup");
                    alert.setHeaderText("Khong tim thay du lieu");
                    alert.showAndWait();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                db.closeDB();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
