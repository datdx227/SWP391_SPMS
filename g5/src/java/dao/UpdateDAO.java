/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Update;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Seth
 */
public class UpdateDAO extends MySQLDAO {

    public List<Update> getUpdateListByFunctionId(int functionId) {
        List<Update> list = new ArrayList<>();
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM `update` where function_id = ?");
            stmt.setInt(1, functionId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Update update = new Update();
                update.setId(rs.getInt("id"));
                update.setTitle(rs.getString("title"));
                update.setDescription(rs.getString("description"));
                update.setUpdateDate(rs.getTimestamp("update_date"));
                update.setFunctionId(rs.getInt("function_id"));
                update.setMilestoneId(rs.getInt("milestone_id"));
                list.add(update);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Update getUpdateById(int id) {
        Update update = null;
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM `update` where id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                update = new Update();
                update.setId(rs.getInt("id"));
                update.setTitle(rs.getString("title"));
                update.setDescription(rs.getString("description"));
                update.setUpdateDate(rs.getTimestamp("update_date"));
                update.setFunctionId(rs.getInt("function_id"));
                update.setMilestoneId(rs.getInt("milestone_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    public void addNewUpdate(Update update, int userId) {
        Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        try {
            PreparedStatement stmt = getConnection()
                    .prepareStatement("INSERT INTO `update` (title, description, update_date, function_id, milestone_id, creator_id, created_time) VALUES (?,?,?,?,?,?,?)");
            stmt.setString(1, update.getTitle());
            stmt.setString(2, update.getDescription());
            stmt.setTimestamp(3, update.getUpdateDate());
            stmt.setInt(4, update.getFunctionId());
            stmt.setInt(5, update.getMilestoneId());
            stmt.setInt(6, userId);
            stmt.setTimestamp(7, date);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUpdate(Update update, int userId) {
        Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        try {
            PreparedStatement stmt = getConnection()
                    .prepareStatement("UPDATE `update` SET title = ?, description = ?, update_date = ?, milestone_id = ?, updater_id = ?, updated_time = ? WHERE id = ?");
            stmt.setString(1, update.getTitle());
            stmt.setString(2, update.getDescription());
            stmt.setTimestamp(3, update.getUpdateDate());
            stmt.setInt(4, update.getMilestoneId());
            stmt.setInt(5, userId);
            stmt.setTimestamp(6, date);
            stmt.setInt(7, update.getId());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUpdate(int id) {
        try {
            PreparedStatement stmt = getConnection()
                    .prepareStatement("DELETE FROM `update` WHERE id = ?");
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
