package com.hung.do_an;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class AdminController {

    @FXML
    private Button classAddBtn;

    @FXML
    private Button classDeleteBtn;

    @FXML
    private TextField classIDTxt;

    @FXML
    private AnchorPane classManagerPage;

    @FXML
    private Label className;

    @FXML
    private Label className1;

    @FXML
    private Label className2;

    @FXML
    private Label className21;

    @FXML
    private TextField classNameTxt;

    @FXML
    private Label classNumberLabel;

    @FXML
    private Button classSearchBtn;

    @FXML
    private Label classSubject;

    @FXML
    private Label classSubject1;

    @FXML
    private Label classSubject2;

    @FXML
    private Label classSubject21;

    @FXML
    private TextField classSubjectIDTxt;

    @FXML
    private TextField classTeacherIDTxt;

    @FXML
    private LineChart<?, ?> homeLinechart;

    @FXML
    private Label homeNumberClass;

    @FXML
    private Label homeNumberTeacher;

    @FXML
    private AnchorPane homePage;

    @FXML
    private PieChart homePiechart;

    @FXML
    private Label homeStudentNumber;

    @FXML
    private Label numberStudent1;

    @FXML
    private Button sidebarClassBtn;

    @FXML
    private Button sidebarHomeBtn;

    @FXML
    private Button sidebarLogOutBtn;

    @FXML
    private Button sidebarStudentBtn;

    @FXML
    private Button sidebarSubjectBtn;

    @FXML
    private Button sidebarTeacherBtn;

    @FXML
    private Button studentAddBtn;

    @FXML
    private DatePicker studentBirthDatePick;

    @FXML
    private TextField studentBirthPlaceTxt;

    @FXML
    private TextField studentClassIDTxt;

    @FXML
    private Button studentDeleteBtn;

    @FXML
    private TextField studentEmailTxt;

    @FXML
    private TextField studentEnrollYearTxt;

    @FXML
    private ChoiceBox<?> studentGenderOpt;

    @FXML
    private TextField studentIDTxt;

    @FXML
    private AnchorPane studentManagerPage;

    @FXML
    private TextField studentNameTxt;

    @FXML
    private Label studentNumberLabel;

    @FXML
    private TextField studentPhoneNumberTxt;

    @FXML
    private Button studentSearchBtn;

    @FXML
    private Button subjectAddBtn;

    @FXML
    private Button subjectDeleteBtn;

    @FXML
    private TextField subjectIDTxt;

    @FXML
    private AnchorPane subjectManagerPage;

    @FXML
    private TextField subjectNameTxt;

    @FXML
    private Button subjectSearchBtn;

    @FXML
    private TableView<?> tblClass;

    @FXML
    private TableView<?> tblStudent;

    @FXML
    private TableView<?> tblSubject;

    @FXML
    private TableView<?> tblTeacher;

    @FXML
    private Button teacherAddBtn;

    @FXML
    private DatePicker teacherBirthDatePick;

    @FXML
    private TextField teacherBirthPlaceTxt;

    @FXML
    private Button teacherDeleteBtn;

    @FXML
    private TextField teacherEmailTxt;

    @FXML
    private ChoiceBox<?> teacherGenderOpt;

    @FXML
    private TextField teacherIDTxt;

    @FXML
    private AnchorPane teacherManagerPage;

    @FXML
    private TextField teacherNameTxt;

    @FXML
    private Label teacherNumberLabel;

    @FXML
    private TextField teacherPasswordTxt;

    @FXML
    private TextField teacherPhoneNumberTxt;

    @FXML
    private Button teacherSearchBtn;

    @FXML
    void handleLogout(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Dang Xuat");
        alert.setTitle("Popup");
        
        try {
            if (alert.showAndWait().get() == ButtonType.OK) {
                App.setRoot("login");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void setClassPage(MouseEvent event) {

    }

    @FXML
    void setHomePage(MouseEvent event) {

    }

    @FXML
    void setStudentPage(MouseEvent event) {

    }

    @FXML
    void setSubjectPage(MouseEvent event) {

    }

    @FXML
    void setTeacherPage(MouseEvent event) {

    }

}
