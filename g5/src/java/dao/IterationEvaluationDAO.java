/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Iteration_Evaluation;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author quang
 */
public class IterationEvaluationDAO extends MySQLDAO {

    public List<Iteration_Evaluation> getIterValuas(String query, int page) {
        List<Iteration_Evaluation> list = new ArrayList<>();
        try {
            String q = "SELECT ie.evaluation_id, u.full_name, t.team_name, ie.total_grade, ie.comment, ie.indi_comment, ie.loc, ie.bonus\n"
                    + "FROM spm.iteration_evaluation ie, spm.team t, spm.user u\n"
                    + "WHERE ie.team_id = t.team_id\n"
                    + "AND ie.user_id = u.user_id\n" + query;
            PreparedStatement stm = getConnection().prepareStatement(q);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Iteration_Evaluation ie = new Iteration_Evaluation();
                ie.setEvaluation_id(rs.getInt("evaluation_id"));
                ie.setUser_name(rs.getString("full_name"));
                ie.setTeam_name(rs.getString("team_name"));
                ie.setTotal_grade(rs.getInt("total_grade"));
                ie.setLoc(rs.getInt("loc"));
                ie.setComment(rs.getString("comment"));
                ie.setIndi_comment(rs.getString("indi_comment"));
                ie.setBonus(rs.getInt("bonus"));
                list.add(ie);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public void importEvaluation(Iteration_Evaluation ie, int user_id) {
        Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        try {
            PreparedStatement stmt = getConnection().prepareStatement("INSERT INTO spm.iteration_evaluation (comment, indi_comment, creator_id, created_time) VALUES (?,?,?,?)");
            stmt.setString(1, ie.getComment());
            stmt.setString(2, ie.getIndi_comment());
            stmt.setInt(3, user_id);
            stmt.setTimestamp(4, date);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
