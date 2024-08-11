package com.hung.do_an;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Classes {
    private String classId;
    private String className;
    private String subjectId;
    private String semester;
    private String teacherId;
    private boolean attendanceFlag;
    private Date attendanceDate;

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public Classes(){

    };

    // Constructor dùng để khởi tạo đối tượng Classes
    public Classes(String classId, String className, String semester, String teacherId, String subjectId) {
        this.classId = classId;
        this.className = className;
        this.semester = semester;
        this.teacherId = teacherId;
        this.subjectId = subjectId;
    }

    // Constructor để khởi tạo đối tượng từ một ResultSet
    public Classes(ResultSet resultSet) {
        try {
            this.classId = resultSet.getString("id");
            this.className = resultSet.getString("name");
            this.semester = resultSet.getString("semester");
            this.teacherId = resultSet.getString("teacher_id");
            this.subjectId = resultSet.getString("subject_id");
            this.attendanceFlag = resultSet.getBoolean("attendance_flag");
            this.attendanceDate = resultSet.getDate("attendance_date");
        } catch (SQLException ex) {
            Logger.getLogger(Classes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Getters và Setters
    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public boolean isAttendanceFlag() {
        return attendanceFlag;
    }

    public void setAttendanceFlag(boolean attendanceFlag) {
        this.attendanceFlag = attendanceFlag;
    }
}
