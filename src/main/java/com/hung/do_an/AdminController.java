package com.hung.do_an;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AdminController {

    @FXML
    private Button classAddBtn;

    @FXML
    private Button classAddBtn1;

    @FXML
    private Button classAddBtn2;

    @FXML
    private Button classAddBtn21;

    @FXML
    private Button classDeleteBtn;

    @FXML
    private Button classDeleteBtn1;

    @FXML
    private Button classDeleteBtn2;

    @FXML
    private Button classDeleteBtn21;

    @FXML
    private TextField classIDTxt;

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
    private Button classSearchBtn1;

    @FXML
    private Button classSearchBtn2;

    @FXML
    private Button classSearchBtn21;

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
    private DatePicker studentBirthDatePick;

    @FXML
    private TextField studentBirthPlaceTxt;

    @FXML
    private TextField studentClassIDTxt;

    @FXML
    private TextField studentEmailTxt;

    @FXML
    private TextField studentEnrollYearTxt;

    @FXML
    private ChoiceBox<?> studentGenderOpt;

    @FXML
    private TextField studentIDTxt;

    @FXML
    private TextField studentNameTxt;

    @FXML
    private Label studentNumberLabel;

    @FXML
    private TextField studentPhoneNumberTxt;

    @FXML
    private TextField subjectIDTxt;

    @FXML
    private TextField subjectNameTxt;

    @FXML
    private TableView<?> tblClass;

    @FXML
    private TableView<?> tblStudent;

    @FXML
    private TableView<?> tblSubject;

    @FXML
    private TableView<?> tblTeacher;

    @FXML
    private DatePicker teacherBirthDatePick;

    @FXML
    private TextField teacherBirthPlaceTxt;

    @FXML
    private TextField teacherEmailTxt;

    @FXML
    private ChoiceBox<?> teacherGenderOpt;

    @FXML
    private TextField teacherIDTxt;

    @FXML
    private TextField teacherNameTxt;

    @FXML
    private Label teacherNumberLabel;

    @FXML
    private TextField teacherPasswordTxt;

    @FXML
    private TextField teacherPhoneNumberTxt;

    @FXML
    void logOut(MouseEvent event) throws IOException {
        App.setRoot("login");
    }
    
    @FXML
    void initialize() throws IOException {
        TeachersEntity teachers_mgr;
        teachers_mgr = new TeachersEntity();
    }

}
