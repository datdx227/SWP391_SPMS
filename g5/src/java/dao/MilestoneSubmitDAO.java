/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Evaluation_Criteria;
import entity.Team;
import entity.Team_Evaluation;
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
public class MilestoneSubmitDAO extends MySQLDAO{
    public List<Team> getTeams(){
        List<Team> list = new ArrayList<>();
        try(Connection conn= getConnection()){
            String query = "SELECT * FROM spm.team;";
            PreparedStatement stm = conn.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                Team team = new Team();
                team.setTeam_id(rs.getInt(1));
                team.setProject_code(rs.getString(2));
                team.setTopic_code(rs.getString(3));
                team.setTopic_name(rs.getString(4));
                team.setStatus(rs.getBoolean("status"));
                
                team.setDescription(rs.getString("description"));
                team.setTeam_name(rs.getString("team_name"));
                team.setStatus1(rs.getString("status1"));
                team.setSubmit(rs.getString("submit"));
                list.add(team);
            }
            rs.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(MilestoneSubmitDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return list;
        }
    }
    public List<Evaluation_Criteria> getEvas(){
        List<Evaluation_Criteria> list = new ArrayList<>();
        try(Connection conn= getConnection()){
            String query = "SELECT * FROM spm.evaluation_criteria;";
            PreparedStatement stm = conn.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                Evaluation_Criteria eva = new Evaluation_Criteria();
                eva.setCriteria_id(rs.getInt(1));
                eva.setIteration_id(rs.getInt(2));
                eva.setIs_team_eval(rs.getInt(3));
                eva.setEval_weight(rs.getInt(4));
                eva.setMax_loc(rs.getInt(5));
                eva.setDescription(rs.getString(6));
                eva.setStatus(rs.getInt(7));
                
                //list.add(team);
                list.add(eva);
            }
            rs.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(MilestoneSubmitDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return list;
        }
    }
    public void updateEva(Evaluation_Criteria eva){
        try(Connection conn= getConnection()){
            String query = "UPDATE `spm`.`evaluation_criteria` SET `is_team_eval` = ?, "
                    + "`eval_weight` = ?, `description` = ? "
                    + " WHERE (`criteria_id` = ?);";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setBoolean(1, true);
            stm.setInt(2, eva.getEval_weight());
            stm.setString(3,eva.getDescription());
            stm.setInt(4, eva.getCriteria_id());
            
            stm.execute();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(MilestoneSubmitDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<Team_Evaluation> getTeamEva(){
        List<Team_Evaluation> list = new ArrayList<Team_Evaluation>();
        try(Connection conn = getConnection()){
            String query = "SELECT * FROM spm.team_evaluation";
            PreparedStatement stm = conn.prepareStatement(query);
            ResultSet rs =stm.executeQuery();
            while (rs.next()){
                Team_Evaluation teamEva = new Team_Evaluation();
                teamEva.setId(rs.getInt(1));
                teamEva.setCriteria_id(rs.getInt(2));
                teamEva.setGrade(rs.getDouble(3));
                teamEva.setComment(rs.getString(4));
                teamEva.setMilestone_id(rs.getInt(5));
                teamEva.setTeam_id(rs.getInt(6));
                teamEva.setCriteria_name(rs.getString("criteria_name"));
                list.add(teamEva);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MilestoneSubmitDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return list;
        }
    }
    public void updateTeamEva(int teamEva_id, double grade, String comment){
        try(Connection conn = getConnection()){
            String query ="UPDATE `spm`.`team_evaluation` "
                    + "SET `grade` = ?, `comment` = ? "
                    + "WHERE (`id` = ?);";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setInt(3, teamEva_id);
            stm.setDouble(1, grade);
            stm.setString(2, comment);
            stm.execute();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(MilestoneSubmitDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
