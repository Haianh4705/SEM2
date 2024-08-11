package com.hung.do_an;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.util.List;

public class StudentController {

    @FXML
    private VBox buttonContainer;

    @FXML
    private ScrollPane buttonScrollPane;

    @FXML
    private TextField class_name_textfield;
    @FXML
    private TextField class_email_textfield;
    @FXML
    private TextField class_phone_textfield;
    @FXML
    private TextField class_birth_place_textfield;
    @FXML
    private TextField class_birth_date_textfield;
    @FXML
    private TextField class_year_textfield;
    @FXML
    private  TextField class_sex;
    @FXML
    private Label header__welcome;
    @FXML
    private Label class_name_subject_label;
    @FXML
    private Label class_number_student_label;
private Students student;
    private StudentsEntity studentsEntity = StudentsEntity.getInstance();

    public void initialize() {
    }

    private void handleButtonClick(String studentId, String classId){
        studentsEntity.attend(studentId,classId);
        reset();
    }

    void reset(){
        buttonContainer.getChildren().clear();
        List<Classes> items = fetchDataFromDatabase();
        for (Classes item : items) {
            Button button = new Button("Điểm danh lớp " + item.getClassName());
            button.setPrefWidth(300);
            button.setOnAction(event -> handleButtonClick(student.getId() , item.getClassId())); // Set action with id
            buttonContainer.getChildren().add(button);
        }
    }

    private List<Classes> fetchDataFromDatabase() {
        return studentsEntity.getAllNotAttendedClasses(student.getId());
    }

    public void setStudentId(String studentId) {
        student = studentsEntity.findById(new Students(studentId));
        if (student != null) {
            class_name_textfield.setText(student.getName());
            class_email_textfield.setText(student.getEmail());
            class_phone_textfield.setText(student.getPhone_number());
            class_birth_place_textfield.setText(student.getBirth_place());
            class_birth_date_textfield.setText(student.getDate_birth());
            class_year_textfield.setText(String.valueOf(student.getYear()));
            String gender = student.getGender();
            if ("M".equals(gender)) {
                class_sex.setText("Nam");
            } else if ("F".equals(gender)) {
                class_sex.setText("Nữ");
            } else {
                class_sex.setText("LGBT");
            }

            class_name_textfield.setEditable(false);
            class_email_textfield.setEditable(false);
            class_phone_textfield.setEditable(false);
            class_birth_place_textfield.setEditable(false);
            class_birth_date_textfield.setEditable(false);
            class_year_textfield.setEditable(false);
            class_sex.setEditable(false);
            header__welcome.setText("Xin chào "+ student.getName());
        } else {
            // Handle case where student is not found
            System.out.println("Student not found for ID: " + studentId);
        }
        List<Classes> items = fetchDataFromDatabase();

        for (Classes item : items) {
            Button button = new Button("Điểm danh lớp " + item.getClassName());
            button.setPrefWidth(300);
            button.setOnAction(event -> handleButtonClick(student.getId() , item.getClassId())); // Set action with id
            buttonContainer.getChildren().add(button);
        }
    }
}
