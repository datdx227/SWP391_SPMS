/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Milestone;
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
public class MilestoneDAO extends MySQLDAO {
    public List<Milestone> getAll(){
        List<Milestone> list = new ArrayList<>();
        try(Connection conn = getConnection()){
            String query = "SELECT * FROM spm.milestone order by from_date";
            PreparedStatement stm = conn.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                Milestone ms = new Milestone();
                ms.setMilestone_id(rs.getInt(1));
                ms.setIteration_id(rs.getInt(3));
                ms.setClass_id(rs.getInt(4));
                ms.setFrom_date(rs.getDate(5));
                ms.setTo_date(rs.getDate(6));
                ms.setDescription(rs.getString(7));
                ms.setStatus(rs.getInt(8));
                list.add(ms);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MilestoneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return list;
        }
    }
    public void changeStatus(int id, int status){
        try(Connection conn = getConnection()){
            String query = "UPDATE `spm`.`milestone` SET `status` = ? WHERE (`milestone_id` = ?);";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setInt(2, id);
            stm.setInt(1, status);
            stm.execute();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClassSettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   public Milestone get(int id){
         Milestone ms = null;
        try(Connection conn = getConnection()){
            String query = "SELECT * FROM spm.milestone WHERE milestone_id = ?";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                 ms = new Milestone();
                ms.setMilestone_id(rs.getInt(1));
                ms.setIteration_id(rs.getInt(3));
                ms.setClass_id(rs.getInt(4));
                ms.setFrom_date(rs.getDate(5));
                ms.setTo_date(rs.getDate(6));
                ms.setDescription(rs.getString(7));
                ms.setStatus(rs.getInt(8));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(MilestoneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return ms;
        }
    }
    public void update(Milestone a){
        try(Connection conn = getConnection()){
            String query = "UPDATE `spm`.`milestone` "
                    + "SET `iteration_id` = ?, `class_id` = ?, `from_date` = ?, "
                    + "`to_date` = ?, `description` = ? "
                    + "WHERE (`milestone_id` = ?);\n" ;
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setInt(1, a.getIteration_id());
            stm.setInt(2,a.getClass_id());
            stm.setDate(3, a.getFrom_date());
            stm.setDate(4, a.getTo_date());
            stm.setString(5, a.getDescription());
            stm.setInt(6, a.getMilestone_id());
            stm.execute();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClassSettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<Milestone> getMileStoneList() {
        ArrayList<Milestone> list = new ArrayList<>();
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM spm.milestone");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                Milestone mile = new Milestone();
                mile.setMilestone_id(rs.getInt("milestone_id"));
                mile.setIteration_id(rs.getInt("iteration_id"));
                mile.setMilestone_name(rs.getString("milestone_name"));
                mile.setClass_id(rs.getInt("class_id"));
                mile.setFrom_date(rs.getDate("from_date"));
                mile.setTo_date(rs.getDate("to_date"));
                mile.setDescription(rs.getString("description"));
                mile.setStatus(rs.getInt("status"));
                list.add(mile);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
