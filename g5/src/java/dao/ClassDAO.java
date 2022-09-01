/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.Class;
import entity.Term;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quang
 */
public class ClassDAO extends MySQLDAO {

    public List<Class> getClassesSubjectId2(int page, int entriesPerPage, int subjectId) {
        page -= 1;
        List<Class> list = new ArrayList<>();
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT c.class_id, s.subject_name, c.class_code, se.setting_name, c.is_block5, u.full_name, c.status\n"
                    + "FROM spm.class c, spm.user u, spm.subject s, spm.setting se\n"
                    + "where c.subject_id = s.subject_id\n"
                    + "	and c.term_id = se.setting_id\n"
                    + "    and u.user_id = c.trainer_id\n"
                    + "    and c.subject_id = ? LIMIT ? OFFSET ?");
            stmt.setInt(1, subjectId);
            stmt.setInt(2, entriesPerPage);
            stmt.setInt(3, page * entriesPerPage);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Class c = new Class();
                c.setId(rs.getInt("class_id"));
                c.setSubject_name(rs.getString("subject_name"));
                c.setClass_code(rs.getString("class_code"));
                c.setTerm_name(rs.getString("setting_name"));
                c.setIs_block5(rs.getBoolean("is_block5"));
                c.setTrainer_name(rs.getString("full_name"));
                c.setStatus(rs.getBoolean("status"));
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Class> getClasses(String query, int page) {
        List<Class> list = new ArrayList<>();
        try {
            String q = "SELECT c.class_id, s.subject_name, c.class_code, c.term_name, c.is_block5, (select u.full_name from spm.user u where u.user_id = c.trainer_id) as trainer_name, c.status\n"
                    + "FROM spm.class c, spm.user u, spm.subject s\n"
                    + "WHERE c.subject_id = s.subject_id\n"
                    + "AND u.user_id = c.trainer_id" + query;
            PreparedStatement stm = getConnection().prepareStatement(q);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Class c = new Class();
                c.setId(rs.getInt("class_id"));
                c.setSubject_name(rs.getString("subject_name"));
                c.setClass_code(rs.getString("class_code"));
                c.setTerm_name(rs.getString("term_name"));
                c.setIs_block5(rs.getBoolean("is_block5"));
                c.setTrainer_name(rs.getString("trainer_name"));
                c.setStatus(rs.getBoolean("status"));
                list.add(c);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public ArrayList<Term> getTermList() {
        ArrayList<Term> listTerm = new ArrayList<>();
        Term term = null;
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT term_name FROM spm.class");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                term = new Term();
                term.setTerm_name(rs.getString("term_name"));
                listTerm.add(term);
            }

        } catch (Exception e) {
        }
        if (!listTerm.isEmpty()) {
            ArrayList<Term> newlistTerm = new ArrayList<>();
            for (int i = 0; i < listTerm.size(); i++) {
                if (newlistTerm.isEmpty()) {
                    newlistTerm.add(listTerm.get(i));
                } else {
                    int check = 0;
                    for (int j = 0; j < newlistTerm.size(); j++) {
                        if (listTerm.get(i).getTerm_name().equalsIgnoreCase(newlistTerm.get(j).getTerm_name())) {
                            check = 1;
                        }
                    }
                    if (check == 0) {
                        newlistTerm.add(listTerm.get(i));
                    }
                }

            }
            return newlistTerm;
        }
        return listTerm;
    }

    public void updateClassStatus(int id, int updater_id, boolean status) {
        Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        try {
            PreparedStatement stmt = getConnection().prepareStatement("UPDATE spm.class SET status = ?, updater_id = ?, updated_time = ? WHERE class_id = ?");
            stmt.setBoolean(1, status);
            stmt.setInt(2, updater_id);
            stmt.setTimestamp(3, date);
            stmt.setInt(4, id);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Class getClassDetails(int id) {
        try {
            String query = "SELECT * FROM spm.class WHERE class_id = " + id;
            PreparedStatement stmt = getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Class c = new Class();
                c.setId(rs.getInt("class_id"));
                c.setSubject_id(rs.getInt("subject_id"));
                c.setClass_code(rs.getString("class_code"));
                c.setTerm_name(rs.getString("term_name"));
                c.setTrainer_id(rs.getInt("trainer_id"));
                c.setIs_block5(rs.getBoolean("is_block5"));
                c.setStatus(rs.getBoolean("status"));
                return c;
            }
        } catch (SQLException e) {

        }
        return null;
    }

    public void updateClassDetails(Class c, int user_id) {
        Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        try {
            PreparedStatement stmt = getConnection().prepareStatement("UPDATE spm.class\n"
                    + "SET subject_id = ?, class_code = ?, term_name = ?, is_block5 = ?, trainer_id = ?, status = ?, updater_id = ?, updated_time = ?\n"
                    + "WHERE class_id = ?");
            stmt.setInt(1, c.getSubject_id());
            stmt.setString(2, c.getClass_code());
            stmt.setString(3, c.getTerm_name());
            stmt.setBoolean(4, c.isIs_block5());
            stmt.setInt(5, c.getTrainer_id());
            stmt.setBoolean(6, c.isStatus());
            stmt.setInt(7, user_id);
            stmt.setTimestamp(8, date);
            stmt.setInt(9, c.getId());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addNewClass(Class c, int user_id) {
        Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        try {
            PreparedStatement stmt = getConnection().prepareStatement("INSERT INTO class (subject_id, class_code, term_name, trainer_id, is_block5, status, creator_id, created_time) "
                    + "VALUES (?,?,?,?,?,?,?,?)");
            stmt.setInt(1, c.getSubject_id());
            stmt.setString(2, c.getClass_code());
            stmt.setString(3, c.getTerm_name());
            stmt.setInt(4, c.getTrainer_id());
            stmt.setBoolean(5, c.isIs_block5());
            stmt.setBoolean(6, c.isStatus());
            stmt.setInt(7, user_id);
            stmt.setTimestamp(8, date);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
