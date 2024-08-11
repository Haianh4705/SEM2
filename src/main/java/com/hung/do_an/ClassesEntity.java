package com.hung.do_an;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClassesEntity extends BaseEntity<Classes> {

    private static ClassesEntity instance = null;

    public synchronized static ClassesEntity getInstance() {
        if (instance == null) {
            instance = new ClassesEntity();
        }

        return instance;
    }

    void changeFlag(String id, Boolean flag) {
        ResultSet rs = null;
        try {
            openConnection();

            Date currentDate = new Date(System.currentTimeMillis());
            String currentDateString = currentDate.toString();

            String selectSQL = "SELECT attendance_date FROM classes WHERE id = ?";
            statement = con.prepareStatement(selectSQL);
            statement.setString(1, id);
            rs = statement.executeQuery();

            String oldAttendanceDate = null;
            if (rs.next()) {
                oldAttendanceDate = rs.getString("attendance_date");
            }

            if (oldAttendanceDate == null || !oldAttendanceDate.equals(currentDateString)) {
                flag = false;
            }

            String updateSQL = "UPDATE classes SET attendance_flag = ?, attendance_date = ? WHERE id = ?";
            statement = con.prepareStatement(updateSQL);
            statement.setBoolean(1, flag);
            statement.setString(2, currentDateString);
            statement.setString(3, id);
            statement.executeUpdate();

            if (oldAttendanceDate == null || !oldAttendanceDate.equals(currentDateString)) {
                resetAllStudentAttendance(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }


    public static void resetAllStudentAttendance(String id) {
        try {
            openConnection();

            String sql = "UPDATE classes_student " +
                    "SET attendance_flag = FALSE " +
                    "WHERE class_id = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    @Override
    public List<Classes> findAll() {
        List<Classes> classesList = new ArrayList<>();
        try {
            openConnection();
            String query = "SELECT * FROM classes";
            statement = con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Classes cls = new Classes(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("semester"),
                        rs.getString("teacher_id"),
                        rs.getString("subject_id")
                );
                classesList.add(cls);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassesEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
        return classesList;
    }

    @Override
    public void insert(Classes item) {
        try {
            openConnection();
            String query = "INSERT INTO classes (id, name, semester, teacher_id, subject_id) VALUES (?, ?, ?, ?, ?)";
            statement = con.prepareStatement(query);
            statement.setString(1, item.getClassId());
            statement.setString(2, item.getClassName());
            statement.setString(3, item.getSemester());
            statement.setString(4, item.getTeacherId());
            statement.setString(5, item.getSubjectId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClassesEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
    }

    @Override
    public void update(Classes item) {
        try {
            openConnection();
            String query = "UPDATE classes SET name = ?, semester = ?, teacher_id = ?, subject_id = ? WHERE id = ?";
            statement = con.prepareStatement(query);
            statement.setString(1, item.getClassName());
            statement.setString(2, item.getSemester());
            statement.setString(3, item.getTeacherId());
            statement.setString(4, item.getSubjectId());
            statement.setString(5, item.getClassId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClassesEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
    }

    @Override
    public void delete(Classes item) {
        try {
            openConnection();
            String query = "DELETE FROM classes WHERE id = ?";
            statement = con.prepareStatement(query);
            statement.setString(1, item.getClassId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClassesEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
    }

    @Override
    public Classes findById(Classes item) {
        Classes cls = null;
        try {
            openConnection();
            String query = "SELECT * FROM classes WHERE id = ?";
            statement = con.prepareStatement(query);
            statement.setString(1, item.getClassId());
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                cls = new Classes(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("semester"),
                        rs.getString("teacher_id"),
                        rs.getString("subject_id")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassesEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
        return cls;
    }

    public List<Classes> findByTeacherId(String teacherId) {
        List<Classes> classesList = new ArrayList<>();
        try {
            openConnection();
            String query = "SELECT * FROM classes WHERE teacher_id = ?";
            statement = con.prepareStatement(query);
            statement.setString(1, teacherId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Classes cls = new Classes(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("semester"),
                        rs.getString("teacher_id"),
                        rs.getString("subject_id")
                );
                classesList.add(cls);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassesEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
        return classesList;
    }
}
