/**
 * Sample Skeleton for 'login.fxml' Controller Class
 */

package com.hung.do_an;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class LoginController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="login_button"
    private Button login_button; // Value injected by FXMLLoader

    @FXML // fx:id="login_icon"
    private ImageView login_icon; // Value injected by FXMLLoader

    @FXML // fx:id="login_image"
    private ImageView login_image; // Value injected by FXMLLoader

    @FXML // fx:id="login_password"
    private PasswordField login_password; // Value injected by FXMLLoader

    @FXML // fx:id="login_username"
    private TextField login_username; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() throws Exception {
        assert login_button != null : "fx:id=\"login_button\" was not injected: check your FXML file 'login.fxml'.";
        assert login_icon != null : "fx:id=\"login_icon\" was not injected: check your FXML file 'login.fxml'.";
        assert login_image != null : "fx:id=\"login_image\" was not injected: check your FXML file 'login.fxml'.";
        assert login_password != null : "fx:id=\"login_password\" was not injected: check your FXML file 'login.fxml'.";
        assert login_username != null : "fx:id=\"login_username\" was not injected: check your FXML file 'login.fxml'.";
    }
    
    @FXML
    void checkLogin(MouseEvent event) throws IOException {
        String username = login_username.getText();
        String pwd = login_password.getText();
        
        if (username.equals("AD123") && pwd.equals("123456")) {
            App.setRoot("admin");
        }
        
        System.out.println(username);
        System.out.println(pwd);
    }
}
