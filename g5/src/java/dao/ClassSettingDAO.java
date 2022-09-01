/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.ClassSetting;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class ClassSettingDAO extends MySQLDAO{
    public List<ClassSetting> getAll(){
        List<ClassSetting> list = new ArrayList<>();
        try(Connection conn = getConnection()){
            String query = "SELECT * FROM spm.class_setting;";
            PreparedStatement stm = conn.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                ClassSetting a = new ClassSetting();
                a.setSetting_id(rs.getInt(1));
                a.setSetting_title(rs.getString(2));
                a.setSetting_value(rs.getString(3));
                a.setDisplay_order(rs.getInt(4));
                a.setDescription(rs.getString(6));
                a.setStatus(rs.getInt(7));
                a.setType_id(rs.getInt(8));
                list.add(a);
            }
            rs.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClassSettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return list;
        }
    }
    public void changeStatus(int id, int status){
        try(Connection conn = getConnection()){
            String query = "UPDATE `spm`.`class_setting` SET `status` = ? WHERE (`setting_id` = ?);";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setInt(2, id);
            stm.setInt(1, status);
            stm.execute();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClassSettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ClassSetting get(int id){
        ClassSetting a = null;
        try(Connection conn = getConnection()){
            String query = "SELECT * FROM spm.class_setting WHERE setting_id = ? ";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                a = new ClassSetting();
                a.setSetting_id(rs.getInt(1));
                a.setSetting_title(rs.getString(2));
                a.setSetting_value(rs.getString(3));
                a.setDisplay_order(rs.getInt(4));
                a.setDescription(rs.getString(6));
                a.setStatus(rs.getInt(7));
                a.setType_id(rs.getInt(8));
                
            }
            rs.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClassSettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return a;
        }
    }
    public void update(ClassSetting a){
        try(Connection conn = getConnection()){
            String query = "UPDATE `spm`.`class_setting` SET `setting_title` = ?, "
                    + "`setting_value` = ?, `display_order` = ?, `class_id` = ?, "
                    + "`description` = ?, `type_id` =?"
                    + " WHERE (`setting_id` = ?); ";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setString(1, a.getSetting_title());
            stm.setString(2, a.getSetting_value());
            stm.setInt(3, a.getDisplay_order());
            stm.setInt(4, 1);
            stm.setString(5, a.getDescription());
            stm.setInt(6, a.getType_id());
            stm.setInt(7, a.getSetting_id());
            stm.execute();
            //rs.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClassSettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
