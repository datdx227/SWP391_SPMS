/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Submit;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author Seth
 */
public class SubmitDAO extends MySQLDAO {

    public void addNewSubmit(Submit submit, int userId) {
        Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        try {
            PreparedStatement stmt = getConnection()
                    .prepareStatement("INSERT INTO submit (milestone_id, team_id, package_file_link, submit_date, status, creator_id, created_time) VALUES (?,?,?,?,?,?,?)");
            stmt.setInt(1, submit.getMilestoneId());
            stmt.setInt(2, submit.getTeamId());
            stmt.setString(3, submit.getPackageFileLink());
            stmt.setTimestamp(4, submit.getSubmitDate());
            stmt.setBoolean(5, submit.isStatus());
            stmt.setInt(6, userId);
            stmt.setTimestamp(7, date);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSubmit(Submit submit, int userId) {
        Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        try {
            PreparedStatement stmt = getConnection()
                    .prepareStatement("UPDATE submit SET package_file_link = ?, submit_date = ?, status = ?, updater_id = ?, updated_time = ? WHERE milestone_id = ? AND team_id = ?");
            stmt.setString(1, submit.getPackageFileLink());
            stmt.setTimestamp(2, submit.getSubmitDate());
            stmt.setBoolean(3, submit.isStatus());
            stmt.setInt(4, userId);
            stmt.setTimestamp(5, date);
            stmt.setInt(6, submit.getMilestoneId());
            stmt.setInt(7, submit.getTeamId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
