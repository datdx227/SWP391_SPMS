/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.IterationEvaluation;
import entity.Loc_Evaluation;
import entity.MemberEvaluation;
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
public class StudentEvaluationDAO extends MySQLDAO{
    public List<IterationEvaluation> getIteEvas(){
        List<IterationEvaluation> list = new ArrayList<IterationEvaluation>();
        try(Connection conn = getConnection()){
            String query = "SELECT * FROM spm.iteration_evaluation;";
            PreparedStatement stm = conn.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                IterationEvaluation iEva = new IterationEvaluation();
                iEva.setEvaId(rs.getInt(1));
                iEva.setMileStoneId(rs.getInt(2));
                iEva.setTeamId(rs.getInt(3));
                iEva.setUserId(rs.getInt(5));
                iEva.setBonus(rs.getDouble(7));
                iEva.setTotalGrade(rs.getDouble(8));
                iEva.setComment(rs.getString(9));
                list.add(iEva);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentEvaluationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return list;
        }
    }
    public List<MemberEvaluation> getMemberEvas(){
        List<MemberEvaluation> list = new ArrayList<>();
        try(Connection conn = getConnection()){
            String query = "SELECT * FROM spm.member_evaluation;";
            PreparedStatement stm = conn.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                MemberEvaluation memEva = new MemberEvaluation();
                memEva.setId(rs.getInt(1));
                memEva.setEvaluationId(rs.getInt(2));
                memEva.setCriteriaId(rs.getInt(3));
                memEva.setTotalLoc(rs.getInt(4));
                memEva.setGrade(rs.getDouble(5));
                memEva.setComment(rs.getString(6));
                memEva.setStudent_id(rs.getInt("student_id"));
                memEva.setTeam_id(rs.getInt("team_id"));
                memEva.setCriteria_name(rs.getString("criteria_name"));
                list.add(memEva);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentEvaluationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return list;
        }
    }
    public List<Loc_Evaluation> getLocEvas(){
        List<Loc_Evaluation> list = new ArrayList<>();
        try(Connection conn = getConnection()){
            String query = "SELECT * FROM spm.loc_evaluation;";
            PreparedStatement stm = conn.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                Loc_Evaluation loc = new Loc_Evaluation();
                loc.setId(rs.getInt("id"));
                loc.setFunction_name(rs.getString("function_name"));
                loc.setQuality_name(rs.getString("quality_name"));
                loc.setConverted_loc(rs.getString("converted_loc"));
                loc.setComplexity_name(rs.getString("complexity_name"));
                loc.setStudent_id(rs.getInt("student_id"));
                list.add(loc);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentEvaluationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return list;
        }
    }
}
