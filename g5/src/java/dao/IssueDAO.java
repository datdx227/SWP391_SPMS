/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Issue;
import entity.Type;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author quang
 */
public class IssueDAO extends MySQLDAO {

    public List<Issue> getIssues(String query, int page) {
        List<Issue> list = new ArrayList<>();
        try {
            String q = "SELECT i.issue_id, i.issue_title, i.issue_type, f.title, m.milestone_name, (select u.full_name from spm.user u where u.user_id = i.assigner_id) as assigner_name, (select u.full_name from spm.user u where u.user_id = i.assignee_id) as assignee_name, t.team_name, i.status \n"
                    + "FROM spm.issue i, spm.function f, spm.milestone m, spm.team t\n"
                    + "WHERE i.function_id = f.function_id \n"
                    + "AND i.milestone_id = m.milestone_id\n"
                    + "AND i.team_id = t.team_id" + query;
            PreparedStatement stm = getConnection().prepareStatement(q);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Issue i = new Issue();
                i.setIssue_id(rs.getInt("issue_id"));
                i.setIssue_title(rs.getString("issue_title"));
                i.setIssue_type(rs.getString("issue_type"));
                i.setFunction_title(rs.getString("title"));
                i.setMilestone_name(rs.getString("milestone_name"));
                i.setAssigner_name(rs.getString("assigner_name"));
                i.setAssignee_name(rs.getString("assignee_name"));
                i.setTeam_name(rs.getString("team_name"));
                i.setStatus(rs.getBoolean("status"));
                list.add(i);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }
    
    public ArrayList<Type> getTypeList() {
        ArrayList<Type> listType = new ArrayList<>();
        Type type = null;
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT issue_type FROM spm.issue");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                type = new Type();
                type.setType_name(rs.getString("issue_type"));
                listType.add(type);
            }

        } catch (Exception e) {
        }
        if (!listType.isEmpty()) {
            ArrayList<Type> newListType = new ArrayList<>();
            for (int i = 0; i < listType.size(); i++) {
                if (newListType.isEmpty()) {
                    newListType.add(listType.get(i));
                } else {
                    int check = 0;
                    for (int j = 0; j < newListType.size(); j++) {
                        if (listType.get(i).getType_name().equalsIgnoreCase(newListType.get(j).getType_name())) {
                            check = 1;
                        }
                    }
                    if (check == 0) {
                        newListType.add(listType.get(i));
                    }
                }

            }
            return newListType;
        }
        return listType;
    }
}
