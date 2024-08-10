package com.hung.do_an;

import java.sql.ResultSet;
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
    private ChoiceBox<String> teacherGenderOpt;

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
    void logOut(MouseEvent event) throws Exception {
        App.setRoot("login");
    }
    
    @FXML
    void initialize() throws Exception {
        // open database
        DBManager db = new DBManager();
        db.connectDB();
        //setHomePage(db);
        db.closeDB();
    }

    @FXML
    void setHomePage(DBManager db) throws Exception {
        // set visible
        homePage.setVisible(true);
        subjectManagerPage.setVisible(false);
        teacherManagerPage.setVisible(false);
        studentManagerPage.setVisible(false);
        classManagerPage.setVisible(false);
        /*
        // set number
        String sql = "SELECT COUNT(id) as id_count from students UNION ALL SELECT COUNT(id) as id_count from classes UNION ALL SELECT COUNT(id) as is_count from teachers";
        db.stmt = db.conn.prepareStatement(sql);
        ResultSet res = db.stmt.executeQuery();
        int[] cnt = new int[3];
        int i = 0;
        while (res.next()) {
            // cnt[i] = res.getInt("id_count");
            System.out.println(res.getString("id_count"));
            i++;
        }
        res.close();
        //homeStudentNumber.setText(String.valueOf(cnt[0]));
        //homeNumberClass.setText(String .valueOf(cnt[1]));
        //homeNumberTeacher.setText(String.valueOf(cnt[2]));
        */
    }
    
    @FXML
    void setSubjectPage(DBManager db) throws Exception {
        // set visible
        homePage.setVisible(false);
        subjectManagerPage.setVisible(true);
        teacherManagerPage.setVisible(false);
        studentManagerPage.setVisible(false);
        classManagerPage.setVisible(false);
    }
    
    @FXML
    void setTeacherPage(DBManager db) throws Exception {
        // set visible
        homePage.setVisible(false);
        subjectManagerPage.setVisible(false);
        teacherManagerPage.setVisible(true);
        studentManagerPage.setVisible(false);
        classManagerPage.setVisible(false);
    }
    
    @FXML
    void setStudentPage(DBManager db) throws Exception {
        // set visible
        homePage.setVisible(false);
        subjectManagerPage.setVisible(false);
        teacherManagerPage.setVisible(false);
        studentManagerPage.setVisible(true);
        classManagerPage.setVisible(false);
    }
    
    @FXML
    void setClassPage(DBManager db) throws Exception {
        // set visible
        homePage.setVisible(false);
        subjectManagerPage.setVisible(false);
        teacherManagerPage.setVisible(false);
        studentManagerPage.setVisible(false);
        classManagerPage.setVisible(true);
    }
}
