package com.hung.do_an;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;
import java.util.stream.Collectors;

public class TeacherController {
    @FXML
    private Label class_name_class_label;
    @FXML
    private TableView<Students> class_student_table;
    @FXML
    private TableColumn<Students, String> col_stt;
    @FXML
    private TableColumn<Students, String> col_id;
    @FXML
    private TableColumn<Students, String> col_name;
    @FXML
    private TableColumn<Students, String> col_birth_date;
    @FXML
    private TableColumn<Students, String> col_birth_place;
    @FXML
    private TableColumn<Students, String> col_attendance;
    @FXML
    private ChoiceBox<String> class_list;
    @FXML
    private Button attendance;
    private Teachers teachers = new Teachers("");
    private Classes classes = new Classes();
    private TeachersEntity teachersEntity = TeachersEntity.getInstance();
    private ClassesEntity classesEntity = ClassesEntity.getInstance();

    public void initialize() {
        col_stt.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_birth_date.setCellValueFactory(new PropertyValueFactory<>("date_birth"));
        col_birth_place.setCellValueFactory(new PropertyValueFactory<>("birth_place"));
        col_attendance.setCellValueFactory(new PropertyValueFactory<>("attendance"));

        class_list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue != null) {
                    updateTableData(newValue, teachers.getId());
                    classes = teachersEntity.findClassById(newValue, teachers.getId());
                    attendance.setVisible(true);
                    if (!classes.isAttendanceFlag()) {
                        // Attendance flag is false
                        attendance.setText("Bật điểm danh");
                        attendance.setStyle("-fx-background-color: #ceeece;"); // Green background
                    } else {
                        // Attendance flag is true
                        attendance.setText("Tắt điểm danh");
                        attendance.setStyle("-fx-background-color: #ff4e4e;"); // Red background
                    }
                }
            }
        });
        attendance.setOnAction(event -> {
            if (classes != null) {
                boolean newFlag = !classes.isAttendanceFlag();
                classes.setAttendanceFlag(newFlag);
                classesEntity.changeFlag(classes.getClassId(), newFlag);
                // Update the button text and color
                if (newFlag) {
                    attendance.setText("Tắt điểm danh");
                    attendance.setStyle("-fx-background-color: #ff4e4e;"); // Red background
                } else {
                    attendance.setText("Bật điểm danh");
                    attendance.setStyle("-fx-background-color: #ceeece;"); // Green background
                }
            }
        });

    }

    void updateTableData(String className, String id){
        List<Students> studentsList = teachersEntity.findAllByClassId(className ,id);
        ObservableList<Students> observableStudentsList = FXCollections.observableArrayList(studentsList);
        class_student_table.setItems(observableStudentsList);
    };

    private List<Classes> getClassNamesForTeacher(String id) {
        return TeachersEntity.getAllClass(id);
    }


    private void loadClassList(String id) {
        List<Classes> classNames = getClassNamesForTeacher(id);
        ObservableList<String> classListItems = FXCollections.observableArrayList(
                classNames.stream().map(Classes::getClassName).collect(Collectors.toList())
        );
        class_list.setItems(classListItems);

        // Đặt hành động khi một lớp học được chọn
        class_list.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            class_name_class_label.setText(newValue);
        });
    }

    public void setTeacherId(String id) {
        teachers = teachersEntity.findById(new Teachers(id));
        class_name_class_label.setText(teachers.getClass_id());
        loadClassList(id);
    }

    public void reset(){
    }

}
