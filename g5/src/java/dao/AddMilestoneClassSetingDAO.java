/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.ClassSetting;
import entity.Milestone;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class AddMilestoneClassSetingDAO extends MySQLDAO{
    public void addMileStone(Milestone ms){
        try(Connection conn = getConnection()){
            String query = "INSERT INTO `spm`.`milestone` (`iteration_id`, "
                    + "`class_id`, `from_date`, "
                    + "`to_date`, `description`, `status`) "
                    + "VALUES (?, ?, ?, ?, ?, '1'); ";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setInt(1, ms.getIteration_id());
            stm.setInt(2, ms.getClass_id());
            stm.setDate(3, ms.getFrom_date());
            stm.setDate(4, ms.getTo_date());
            stm.setString(5, ms.getDescription());
            stm.execute();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(AddMilestoneClassSetingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void addClassSetting(ClassSetting a){
        try(Connection conn = getConnection()){
            String query = "INSERT INTO `spm`.`class_setting` (`setting_title`, `setting_value`, "
                    + "`display_order`, `description`, `status`, `type_id`) "
                    + "VALUES (?, ?, ?, ?, b'1' , ?);";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setString(1, a.getSetting_title());
            stm.setString(2, a.getSetting_value());
            stm.setInt(3, a.getDisplay_order());
            stm.setString(4, a.getDescription());
            stm.setInt(5, a.getType_id());
            stm.execute();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(AddMilestoneClassSetingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
