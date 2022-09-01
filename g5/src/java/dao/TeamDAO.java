/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Team;
import entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Computer
 */
public class TeamDAO extends MySQLDAO {

    public ArrayList<Team> getTeamList() {
        ArrayList<Team> listTeam = new ArrayList<>();
        Team team = null;
        try {
            PreparedStatement stmt = getConnection().prepareStatement("select * from spm.team");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                team = new Team();
                team.setTeam_id(rs.getInt("team_id"));
                team.setTeam_name(rs.getString("team_name"));
                team.setProject_code(rs.getString("project_code"));
                team.setTopic_code(rs.getString("topic_code"));
                team.setTopic_name(rs.getString("topic_name"));
                team.setStatus(rs.getBoolean("status"));
                team.setDescription(rs.getString("description"));
                listTeam.add(team);
            }

        } catch (Exception e) {
        }
        return listTeam;
    }

    public Team getTeamById(int id) {
        Team team = null;
        try {
            PreparedStatement stmt
                    = getConnection().prepareStatement("SELECT * FROM spm.team WHERE team_id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                team = new Team();
                team.setTeam_id(rs.getInt("team_id"));
                team.setProject_code(rs.getString("project_code"));
                team.setTopic_code(rs.getString("topic_code"));
                team.setTopic_name(rs.getString("topic_name"));
                team.setStatus(rs.getBoolean("status"));
                team.setDescription(rs.getString("description"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return team;
    }
    
//    public List<Team> getSubjectListByUID(int trainerId) {
//        List<Team> list = new ArrayList<>();
//        try {
//            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM subject WHERE manager_id = ?");
//            stmt.setInt(1, managerId);
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                Subject sub = new Subject();
//                sub.setId(rs.getInt("subject_id"));
//                sub.setSubject_code(rs.getString("subject_code"));
//                sub.setSubject_name(rs.getString("subject_name"));
//                sub.setManager_id(rs.getInt("manager_id"));
//                sub.setStatus(rs.getBoolean("status"));
//                sub.setDescription(rs.getString("description"));
//                list.add(sub);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
}
