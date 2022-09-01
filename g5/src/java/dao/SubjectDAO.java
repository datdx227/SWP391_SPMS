/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mysql.cj.log.Log;
import entity.Subject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Seth
 */
public class SubjectDAO extends MySQLDAO {

    public List<Subject> getSubjects(int page, int entriesPerPage) {
        page -= 1;
        List<Subject> list = new ArrayList<>();
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM spm.subject LIMIT ? OFFSET ?");
            stmt.setInt(1, entriesPerPage);
            stmt.setInt(2, page * entriesPerPage);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Subject sub = new Subject();
                sub.setId(rs.getInt("subject_id"));
                sub.setSubject_code(rs.getString("subject_code"));
                sub.setSubject_name(rs.getString("subject_name"));
                sub.setManager_id(rs.getInt("manager_id"));
                sub.setStatus(rs.getBoolean("status"));
                sub.setDescription(rs.getString("description"));
                list.add(sub);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Subject> getAllSubjects() {
        List<Subject> list = new ArrayList<>();
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM spm.subject");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Subject sub = new Subject();
                sub.setId(rs.getInt("subject_id"));
                sub.setSubject_code(rs.getString("subject_code"));
                sub.setSubject_name(rs.getString("subject_name"));
                sub.setManager_id(rs.getInt("manager_id"));
                sub.setStatus(rs.getBoolean("status"));
                sub.setDescription(rs.getString("description"));
                list.add(sub);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Subject> getSubjectListByUID(int managerId) {
        List<Subject> list = new ArrayList<>();
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM spm.subject WHERE manager_id = ?");
            stmt.setInt(1, managerId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Subject sub = new Subject();
                sub.setId(rs.getInt("subject_id"));
                sub.setSubject_code(rs.getString("subject_code"));
                sub.setSubject_name(rs.getString("subject_name"));
                sub.setManager_id(rs.getInt("manager_id"));
                sub.setStatus(rs.getBoolean("status"));
                sub.setDescription(rs.getString("description"));
                list.add(sub);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Subject> getSubjects(String query, int page) {
        List<Subject> list = new ArrayList<>();
        try {
            String q = "SELECT s.subject_id, s.subject_code, s.subject_name, (select u.full_name from spm.user u where u.user_id = s.manager_id) AS manager_name, s.status\n"
                    + "FROM spm.subject s" + query;
            PreparedStatement stm = getConnection().prepareStatement(q);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Subject s = new Subject();
                s.setId(rs.getInt("subject_id"));
                s.setSubject_code(rs.getString("subject_code"));
                s.setSubject_name(rs.getString("subject_name"));
                s.setManager_name(rs.getString("manager_name"));
                s.setStatus(rs.getBoolean("status"));
                list.add(s);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public void updateSubjectStatus(int id, int updater_id, boolean status) {
        Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        try {
            PreparedStatement stmt = getConnection().prepareStatement("UPDATE spm.subject SET status = ?, updater_id = ?, updated_time = ? WHERE subject_id = ?");
            stmt.setBoolean(1, status);
            stmt.setInt(2, updater_id);
            stmt.setTimestamp(3, date);
            stmt.setInt(4, id);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Subject getSubjectDetails(int id) {
        Subject sub = null;
        try {
            String query = "SELECT * FROM spm.subject WHERE subject_id = " + id;
            PreparedStatement stmt = getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                sub = new Subject();
                sub.setId(rs.getInt("subject_id"));
                sub.setSubject_code(rs.getString("subject_code"));
                sub.setSubject_name(rs.getString("subject_name"));
                sub.setManager_id(rs.getInt("manager_id"));
                sub.setStatus(rs.getBoolean("status"));
                sub.setDescription(rs.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sub;
    }

    public void updateSubjectDetails(Subject sub, int user_id) {
        Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        try {
            PreparedStatement stmt = getConnection().prepareStatement("UPDATE spm.subject SET "
                    + "subject_id = ?, "
                    + "subject_code = ?, "
                    + "subject_name = ?, "
                    + "manager_id = ?, "
                    + "status = ?, "
                    + "description = ?, "
                    + "updater_id = ?, "
                    + "updated_time = ? "
                    + "WHERE subject_id = ?");
            stmt.setString(1, sub.getSubject_code());
            stmt.setString(2, sub.getSubject_name());
            stmt.setInt(3, sub.getManager_id());
            stmt.setBoolean(4, sub.isStatus());
            stmt.setString(5, sub.getDescription());
            stmt.setInt(6, user_id);
            stmt.setTimestamp(7, date);
            stmt.setInt(8, sub.getId());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addNewSubject(Subject sub, int user_id) {
        Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        try {
            PreparedStatement stmt = getConnection().prepareStatement("INSERT INTO spm.subject (subject_id, subject_code, subject_name, manager_id, status, description, creator_id, created_time) "
                    + "VALUES (?,?,?,?,?,?,?,?)");
            stmt.setInt(1, sub.getId());
            stmt.setString(2, sub.getSubject_code());
            stmt.setString(3, sub.getSubject_name());
            stmt.setInt(4, sub.getManager_id());
            stmt.setBoolean(5, sub.isStatus());
            stmt.setString(6, sub.getDescription());
            stmt.setInt(7, user_id);
            stmt.setTimestamp(8, date);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Subject> getSubjectList() {
        List<Subject> list = new ArrayList<>();
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM spm.subject");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Subject sub = new Subject();
                sub.setId(rs.getInt("subject_id"));
                sub.setSubject_code(rs.getString("subject_code"));
                sub.setSubject_name(rs.getString("subject_name"));
                sub.setManager_id(rs.getInt("manager_id"));
                sub.setStatus(rs.getBoolean("status"));
                sub.setDescription(rs.getString("description"));
                list.add(sub);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
