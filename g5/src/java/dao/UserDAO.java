/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Assignee;
import entity.Manager;
import entity.Trainer;
import entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Seth
 */
public class UserDAO extends MySQLDAO {

    public String getPassword(String email) {
        try {
            PreparedStatement stmt
                    = getConnection().prepareStatement("SELECT password FROM user WHERE username = ?");
            stmt.setString(1, email);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                return result.getString("email");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void changePassword(String pass, int id) {
        try {
            PreparedStatement stmt = getConnection().prepareStatement("update user set password = ? where user_id = ?");
            stmt.setString(1, pass);
            stmt.setInt(2, id);
            stmt.execute();
        } catch (Exception e) {
        }
    }

    public User getUser(String email) {
        User user = null;
        try {
            PreparedStatement stmt
                    = getConnection().prepareStatement("SELECT * FROM user WHERE email = ?");
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("user_id"));
                user.setFullname(rs.getString("full_name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRoleId(rs.getInt("role_id"));
                user.setAvatar_link(rs.getString("avatar_link"));
                user.setStatus(rs.getInt("status"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }
    
    public User getUserById(int id) {
        User user = null;
        try {
            PreparedStatement stmt
                    = getConnection().prepareStatement("SELECT * FROM user WHERE user_id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("user_id"));
                user.setFullname(rs.getString("full_name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRoleId(rs.getInt("role_id"));
                user.setAvatar_link(rs.getString("avatar_link"));
                user.setStatus(rs.getInt("status"));
                user.setPhone(rs.getString("phone"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    public void registerUser(User user) {
        Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        try {
            PreparedStatement stmt
                    = getConnection()
                            .prepareStatement("INSERT INTO user (full_name, email, password, role_id, status, created_time) VALUES(?, ?, ?, ? ,?, ?)");
            stmt.setString(1, user.getFullname());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setInt(4, 5);
            stmt.setInt(5, 1);
            stmt.setTimestamp(6, date);
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean updateUser(String email, String phone, int uid) {
        try {
            PreparedStatement stmt = getConnection().prepareStatement("Update user set email = ?, phone = ? where user_id = ?");
            stmt.setString(1, email);
            stmt.setString(2, phone);
            stmt.setInt(3, uid);
            stmt.execute();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public List<User> getUsers(){
        List<User> list = new ArrayList<>();
        try(Connection conn= new MySQLDAO().getConnection()){
            String query = "SELECT * FROM spm.user;";
            PreparedStatement stm = conn.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                int roleId = rs.getInt(5);
                String role = "";
                if (roleId== 1) role ="Admin";
                if (roleId == 2) role = "User";
                User user = new User();
                user.setId(rs.getInt(1));
                user.setFullname(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setPassword(rs.getString(4));
                user.setAvatar_link(rs.getString(6));
                user.setGender(rs.getInt(7));
                user.setPhone(rs.getString(8));
                user.setStatus(rs.getInt("status"));
                user.setRoleId(roleId);
                list.add(user);
            }
            rs.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return list;
        }
    }
    public ArrayList<Assignee> getAssignees(){
        ArrayList<Assignee> list = new ArrayList<>();
        try(Connection conn= new MySQLDAO().getConnection()){
            String query = "SELECT user_id, full_name FROM spm.user where role_id = 5";
            PreparedStatement stm = conn.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                Assignee a = new Assignee();
                a.setAssignee_id(rs.getInt("user_id"));
                a.setAssignee_name(rs.getString("full_name"));
                list.add(a);
            }
            rs.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return list;
        }
    }
    
    public ArrayList<Manager> getManagers(){
        ArrayList<Manager> list = new ArrayList<>();
        try(Connection conn= new MySQLDAO().getConnection()){
            String query = "SELECT user_id, full_name FROM spm.user where role_id = 3";
            PreparedStatement stm = conn.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                Manager m = new Manager();
                m.setManager_id(rs.getInt("user_id"));
                m.setManager_name(rs.getString("full_name"));
                list.add(m);
            }
            rs.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return list;
        }
    }
    
    public User getUser(int id){
       User user = null;
        try(Connection conn= new MySQLDAO().getConnection()){
            String query = "SELECT * FROM spm.user where user_id = ?";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                int roleId = rs.getInt(5);
                String role = "";
                if (roleId== 1) role ="Admin";
                user = new User();
                user.setId(rs.getInt(1));
                user.setFullname(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setPassword(rs.getString(4));
                user.setAvatar_link(rs.getString(6));
                user.setGender(rs.getInt(7));
                user.setPhone(rs.getString(8));
                user.setRoleId(roleId);
                //user.setStatus(rs.getInt("status"));
                user.setStatus(rs.getInt("status"));
            }
            rs.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return user;
        }
    }
    
    public void changeStatus(int id,int status){
        try(Connection conn= new MySQLDAO().getConnection()){
            String query = "UPDATE `spm`.`user` SET `status` = ? WHERE (`user_id` = ?);";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setInt(2, id);
            stm.setInt(1, status);
            stm.execute();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
        }
    }
    
    public void updateUser(User user,int role_id){
        try(Connection conn= new MySQLDAO().getConnection()){
            String query = "UPDATE `spm`.`user` SET `full_name` = ?, `email` = ?, `password` = ?,"
                    + " `role_id`=?  ,`phone` = ?, `gender`=? WHERE (`user_id` = ?);";
            PreparedStatement stm = conn.prepareStatement(query);
            //stm.setInt(2, id);
            stm.setString(1, user.getFullname());
            stm.setString(2, user.getEmail());
            stm.setString(3, user.getPassword());
            stm.setInt(4, role_id);
            stm.setString(5, user.getPhone());
            stm.setInt(6, user.getGender());
            stm.setInt(7, user.getId());
            stm.execute();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
        }
    }
    
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM spm.user WHERE role_id = 3");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("user_id"));
                u.setFullname(rs.getString("full_name"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setRoleId(rs.getInt("role_id"));
                u.setAvatar_link(rs.getString("avatar_link"));
                u.setStatus(rs.getInt("status"));
                u.setPhone(rs.getString("phone"));
                u.setGender(rs.getInt("gender"));
                list.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<User> getStudentList() {
        List<User> list = new ArrayList<>();
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM user WHERE role_id = 5");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("user_id"));
                user.setFullname(rs.getString("full_name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRoleId(rs.getInt("role_id"));
                user.setAvatar_link(rs.getString("avatar_link"));
                user.setStatus(rs.getInt("status"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<Trainer> getTrainers(){
        ArrayList<Trainer> list = new ArrayList<>();
        try(Connection conn= new MySQLDAO().getConnection()){
            String query = "SELECT user_id, full_name FROM spm.user where role_id = 4";
            PreparedStatement stm = conn.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                Trainer tr = new Trainer();
                tr.setTrainer_id(rs.getInt("user_id"));
                tr.setTrainer_name(rs.getString("full_name"));
                list.add(tr);
            }
            rs.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return list;
        }
    }
}
