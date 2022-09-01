/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Setting;
import entity.SettingClass;
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
 * @author Seth
 */
public class SettingDAO extends MySQLDAO {
    
    public int updateSetting(SettingClass setting) {
        int n = 0;
        
        String sql = "UPDATE setting SET `setting_id` = ?, "
                + "`setting_order` = ?, `setting_name` = ?, "
                + "`setting_value` = ?, `status` = ?, `description` = ? "
                + "WHERE (`setting_id` = ?);";
        try {
            PreparedStatement pre = getConnection().prepareStatement(sql);
            pre.setInt(1, setting.getSettingId());
            pre.setInt(2, setting.getOrder());
            pre.setString(3, setting.getSettingName());
            pre.setString(4, setting.getValue());
            pre.setInt(5, setting.getStatus());
            pre.setString(6, setting.getDescription());
            
            n = pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }
    
    public SettingClass getSettingById(int settingId) {
        try {
            String sql = "SELECT * FROM setting where setting_id = ?;";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, settingId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new SettingClass(rs.getInt("setting_id"), rs.getInt("setting_order"), rs.getString("setting_name"), rs.getString("setting_value"), rs.getInt("status"), rs.getString("note"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<SettingClass> getSettings() {
        List<SettingClass> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM spm.setting;";
            PreparedStatement stm = getConnection().prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                int a = rs.getInt(1);
                String b = rs.getString(2);
                b = rs.getString(3);
                a = rs.getInt(4);
                SettingClass setting = new SettingClass();
                setting.setSettingId(rs.getInt(1));
                setting.setSettingName(rs.getString(2));
                setting.setValue(rs.getString(3));
                setting.setTypeId(rs.getInt(4));
                setting.setOrder(0);
                setting.setStatus(rs.getInt("status"));
                list.add(setting);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return list;
        }
    }
    
    public void changeStatus(int id, int status) {
        try ( Connection conn = new MySQLDAO().getConnection()) {
            String query = "UPDATE spm.setting SET spm.setting.status = ? where setting_id =?";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setInt(2, id);
            stm.setInt(1, status);
            stm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<SettingClass> getAllSettings() {
        List<SettingClass> list = new ArrayList<>();
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM spm.setting");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                SettingClass se = new SettingClass();
                se.setSettingId(rs.getInt("setting_id"));
                se.setSettingName(rs.getString("setting_name"));
                se.setValue(rs.getString("setting_value"));
                se.setOrder(rs.getInt("setting_order"));
                se.setStatus(rs.getInt("status"));
                se.setDescription(rs.getString("note"));
                se.setTypeId(rs.getInt("type_id"));
                list.add(se);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<SettingClass> getContactType() {
        List<SettingClass> list = new ArrayList<>();
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM setting WHERE type_id = 6");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                SettingClass contactType = new SettingClass();
                contactType.setSettingId(rs.getInt("setting_id"));
                contactType.setSettingName(rs.getString("setting_name"));
                list.add(contactType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
