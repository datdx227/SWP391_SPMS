/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Function;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Seth
 */
public class FunctionDAO extends MySQLDAO {

    public ArrayList<Function> getFunctionList() {
        ArrayList<Function> list = new ArrayList<>();
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM spm.`function`");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Function func = new Function();
                func.setFunctionId(rs.getInt("function_id"));
                func.setTeamId(rs.getInt("team_id"));
                func.setTitle(rs.getString("title"));
                func.setFeature(rs.getString("feature"));
                func.setPriority(rs.getInt("priority"));
                func.setIsClosed(rs.getBoolean("is_closed"));
                func.setSubmitStatus(rs.getBoolean("submit_status"));
                func.setDescription(rs.getString("description"));
                list.add(func);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<Function> getFunctionListByIteration(int iterationId) {
        List<Function> list = new ArrayList<>();
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM `function` func JOIN tracking track ON func.function_id = track.function_id JOIN milestone mile ON track.milestone_id  = mile.milestone_id WHERE mile.iteration_id = ?");
            stmt.setInt(1, iterationId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Function func = new Function();
                func.setFunctionId(rs.getInt("function_id"));
                func.setTeamId(rs.getInt("team_id"));
                func.setTitle(rs.getString("title"));
                func.setFeature(rs.getString("feature"));
                func.setPriority(rs.getInt("priority"));
                func.setIsClosed(rs.getBoolean("is_closed"));
                func.setSubmitStatus(rs.getBoolean("submit_status"));
                func.setDescription(rs.getString("description"));
                list.add(func);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
