/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BarePC
 */
public class StudentDAO extends MySQLDAO {

    public int updateSubject(int team_id,int student_id) {
        String sql = "UPDATE class_user set team_id=? \n"
                + "where student_id = ?";
        try {
            PreparedStatement stm = getConnection().prepareStatement(sql);
            stm.setInt(1, team_id);
            stm.setInt(2, student_id);
            
            return stm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);

        }
        return -1;
    }

    public ArrayList<Student> getAllStudent() {
        ArrayList<Student> list = new ArrayList<>();
        try {
            String query = "SELECT \n"
                    + "s.student_id,t.team_id,u.fullname,u.email,u.role_id,s.team_leader,s.status\n"
                    + "FROM spm.class_user s,spm.class su,spm.team t,spm.user u \n"
                    + "where s.team_id = t.team_id and u.user_id = s.user_id\n";
//                    + "LIMIT ? OFFSET ?";
            PreparedStatement stm = getConnection().prepareStatement(query);
//            stm.setInt(1, pageSize);
//            stm.setInt(2, pageNum);
            ResultSet rs = stm.executeQuery();
            
            while (rs.next()) {
                Student student = new Student(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7));
                //setting.setNumOfRecord(rs.getInt("RowOfSubject"));
                list.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return list;
        }
    }

    public ArrayList<Student> searchName(String parameter) {
        ArrayList<Student> list = new ArrayList<>();
        try {
            String query = "SELECT \n"
                    + "s.student_id,t.team_id,u.fullname,u.email,u.role_id,s.team_leader,s.status\n"
                    + "FROM spm.class_user s,spm.class su,spm.team t,spm.user u \n"
                    + "where s.team_id = t.team_id and u.user_id = s.user_id and u.fullname like ?\n";
            PreparedStatement stm = getConnection().prepareStatement(query);
            stm.setString(1, "%" + parameter + "%");
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Student student = new Student(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7));
                //setting.setNumOfRecord(rs.getInt("RowOfSubject"));
                list.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return list;
        }
        
    }

    public ArrayList<Student> searchMail(String parameter) {
        ArrayList<Student> list = new ArrayList<>();
        try {
            String query = "SELECT \n"
                    + "s.student_id,t.team_id,u.fullname,u.email,u.role_id,s.team_leader,s.status\n"
                    + "FROM spm.class_user s,spm.class su,spm.team t,spm.user u \n"
                    + "where s.team_id = t.team_id and u.user_id = s.user_id and u.email like ?\n";
            PreparedStatement stm = getConnection().prepareStatement(query);
            stm.setString(1, "%" + parameter + "%");
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Student student = new Student(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7));
                //setting.setNumOfRecord(rs.getInt("RowOfSubject"));
                list.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return list;
        }
    }
    public ArrayList<Student> searchRole(int parameter) {
        ArrayList<Student> list = new ArrayList<>();
        try {
            String query = "SELECT \n"
                    + "s.student_id,t.team_id,u.fullname,u.email,u.role_id,s.team_leader,s.status\n"
                    + "FROM spm.class_user s,spm.class su,spm.team t,spm.user u \n"
                    + "where s.team_id = t.team_id and u.user_id = s.user_id and u.role_id = ?\n";
            PreparedStatement stm = getConnection().prepareStatement(query);
            stm.setInt(1,parameter);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Student student = new Student(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7));
                //setting.setNumOfRecord(rs.getInt("RowOfSubject"));
                list.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return list;
        }
    }

    public ArrayList<Integer> getAllTeam() {
        ArrayList<Integer> list = new ArrayList<>();
        try {
            String query = "SELECT distinct su.team_id  FROM spm.team su";
            PreparedStatement stm = getConnection().prepareStatement(query);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                list.add(rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return list;
        }
    }

    public ArrayList<Student> filterTeam(int parameter) {
        ArrayList<Student> list = new ArrayList<>();
        try {
            String query = "SELECT \n"
                    + "s.student_id,t.team_id,u.fullname,u.email,u.role_id,s.team_leader,s.status\n"
                    + "FROM spm.class_user s,spm.class su,spm.team t,spm.user u \n"
                    + "where s.team_id = t.team_id and u.user_id = s.user_id and t.team_id = ?\n";
            PreparedStatement stm = getConnection().prepareStatement(query);
            stm.setInt(1,parameter);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Student student = new Student(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7));
                //setting.setNumOfRecord(rs.getInt("RowOfSubject"));
                list.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return list;
        }
    }

    public ArrayList<Student> filterStatus(int parameter) {
        ArrayList<Student> list = new ArrayList<>();
        try {
            String query = "SELECT \n"
                    + "s.student_id,t.team_id,u.fullname,u.email,u.role_id,s.team_leader,s.status\n"
                    + "FROM spm.class_user s,spm.class su,spm.team t,spm.user u \n"
                    + "where s.team_id = t.team_id and u.user_id = s.user_id and s.status = ?\n";
            PreparedStatement stm = getConnection().prepareStatement(query);
            stm.setInt(1,parameter);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Student student = new Student(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7));
                //setting.setNumOfRecord(rs.getInt("RowOfSubject"));
                list.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return list;
        }
    }

    public int change(String status, String id) {
        try {
            String sql = "UPDATE class_user\n"
                    + "SET status = ?\n"
                    + "WHERE student_id = ?";
            PreparedStatement stm = getConnection().prepareStatement(sql);
            stm.setInt(1, Integer.parseInt(status));
            stm.setInt(2, Integer.parseInt(id));
            return stm.executeUpdate();
        } catch (SQLException e) {
        }
        return -1;
    }

}
