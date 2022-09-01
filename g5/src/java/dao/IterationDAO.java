/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Iteration;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Seth
 */
public class IterationDAO extends MySQLDAO {

    public int getTotalIterations() {
        int count = 0;
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT COUNT(*) FROM iteration");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }

    public List<Iteration> getAllIterations() {
        List<Iteration> list = new ArrayList<>();
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM iteration");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Iteration ite = new Iteration();
                ite.setId(rs.getInt("iteration_id"));
                ite.setSubject_id(rs.getInt("subject_id"));
                ite.setIteration_name(rs.getString("iteration_name"));
                ite.setEval_weight(rs.getInt("eval_weight"));
                ite.setOn_going(rs.getBoolean("is_ongoing"));
                ite.setDescription(rs.getString("description"));
                ite.setStatus(rs.getBoolean("status"));
                list.add(ite);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Iteration> getIterations(int page, int entriesPerPage) {
        page -= 1;
        List<Iteration> list = new ArrayList<>();
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM iteration LIMIT ? OFFSET ?");
            stmt.setInt(1, entriesPerPage);
            stmt.setInt(2, page * entriesPerPage);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Iteration ite = new Iteration();
                ite.setId(rs.getInt("iteration_id"));
                ite.setSubject_id(rs.getInt("subject_id"));
                ite.setIteration_name(rs.getString("iteration_name"));
                ite.setEval_weight(rs.getInt("eval_weight"));
                ite.setOn_going(rs.getBoolean("is_ongoing"));
                ite.setDescription(rs.getString("description"));
                ite.setStatus(rs.getBoolean("status"));
                list.add(ite);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public int getTotalIterationsSubjectId(int subjectId) {
        int count = 0;
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT COUNT(*) FROM iteration WHERE subject_id = ?");
            stmt.setInt(1, subjectId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return count;
    }

    public List<Iteration> getAllIterationsSubjectId(int subjectId) {
        List<Iteration> list = new ArrayList<>();
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM iteration WHERE subject_id = ?");
            stmt.setInt(1, subjectId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Iteration ite = new Iteration();
                ite.setId(rs.getInt("iteration_id"));
                ite.setSubject_id(rs.getInt("subject_id"));
                ite.setIteration_name(rs.getString("iteration_name"));
                ite.setEval_weight(rs.getInt("eval_weight"));
                ite.setOn_going(rs.getBoolean("is_ongoing"));
                ite.setDescription(rs.getString("description"));
                ite.setStatus(rs.getBoolean("status"));
                list.add(ite);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Iteration> getIterationsSubjectId(int page, int entriesPerPage, int subjectId) {
        page -= 1;
        List<Iteration> list = new ArrayList<>();
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM iteration WHERE subject_id = ? LIMIT ? OFFSET ?");
            stmt.setInt(1, subjectId);
            stmt.setInt(2, entriesPerPage);
            stmt.setInt(3, page * entriesPerPage);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Iteration ite = new Iteration();
                ite.setId(rs.getInt("iteration_id"));
                ite.setSubject_id(rs.getInt("subject_id"));
                ite.setIteration_name(rs.getString("iteration_name"));
                ite.setEval_weight(rs.getInt("eval_weight"));
                ite.setOn_going(rs.getBoolean("is_ongoing"));
                ite.setDescription(rs.getString("description"));
                ite.setStatus(rs.getBoolean("status"));
                list.add(ite);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public int getTotalIterationsSubjectIdAndStatus(int subjectId, boolean status) {
        int count = 0;
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT COUNT(*) FROM iteration WHERE subject_id = ? AND status = ?");
            stmt.setInt(1, subjectId);
            stmt.setBoolean(2, status);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return count;
    }

    public List<Iteration> getIterationsSubjectIdAndStatus(int page, int entriesPerPage, int subjectId, boolean status) {
        page -= 1;
        List<Iteration> list = new ArrayList<>();
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM iteration WHERE subject_id = ? AND status = ? LIMIT ? OFFSET ?");
            stmt.setInt(1, subjectId);
            stmt.setBoolean(2, status);
            stmt.setInt(3, entriesPerPage);
            stmt.setInt(4, page * entriesPerPage);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Iteration ite = new Iteration();
                ite.setId(rs.getInt("iteration_id"));
                ite.setSubject_id(rs.getInt("subject_id"));
                ite.setIteration_name(rs.getString("iteration_name"));
                ite.setEval_weight(rs.getInt("eval_weight"));
                ite.setOn_going(rs.getBoolean("is_ongoing"));
                ite.setDescription(rs.getString("description"));
                ite.setStatus(rs.getBoolean("status"));
                list.add(ite);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public int getTotalIterationsSubjectIdAndName(int subjectId, String name) {
        int count = 0;
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT COUNT(*) FROM iteration WHERE subject_id = ? AND iteration_name LIKE ?");
            stmt.setInt(1, subjectId);
            stmt.setString(2, '%' + name + '%');
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return count;
    }

    public List<Iteration> getIterationsSubjectIdAndName(int page, int entriesPerPage, int subjectId, String name) {
        page -= 1;
        List<Iteration> list = new ArrayList<>();
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM iteration WHERE subject_id = ? AND iteration_name LIKE ? LIMIT ? OFFSET ?");
            stmt.setInt(1, subjectId);
            stmt.setString(2, '%' + name + '%');
            stmt.setInt(3, entriesPerPage);
            stmt.setInt(4, page * entriesPerPage);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Iteration ite = new Iteration();
                ite.setId(rs.getInt("iteration_id"));
                ite.setSubject_id(rs.getInt("subject_id"));
                ite.setIteration_name(rs.getString("iteration_name"));
                ite.setEval_weight(rs.getInt("eval_weight"));
                ite.setOn_going(rs.getBoolean("is_ongoing"));
                ite.setDescription(rs.getString("description"));
                ite.setStatus(rs.getBoolean("status"));
                list.add(ite);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Iteration> getIterationsSubjectIdAndOrder(int page, int entriesPerPage, int subjectId, String order) {
        page -= 1;
        List<Iteration> list = new ArrayList<>();
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM iteration WHERE subject_id = ? ORDER BY eval_weight " + order + " LIMIT ? OFFSET ?");
            stmt.setInt(1, subjectId);
            stmt.setInt(2, entriesPerPage);
            stmt.setInt(3, page * entriesPerPage);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Iteration ite = new Iteration();
                ite.setId(rs.getInt("iteration_id"));
                ite.setSubject_id(rs.getInt("subject_id"));
                ite.setIteration_name(rs.getString("iteration_name"));
                ite.setEval_weight(rs.getInt("eval_weight"));
                ite.setOn_going(rs.getBoolean("is_ongoing"));
                ite.setDescription(rs.getString("description"));
                ite.setStatus(rs.getBoolean("status"));
                list.add(ite);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public int getTotalIterationsName(String name) {
        int count = 0;
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT COUNT(*) FROM iteration WHERE iteration_name LIKE ?");
            stmt.setString(1, '%' + name + '%');
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return count;
    }

    public List<Iteration> getIterationsName(int page, int entriesPerPage, String name) {
        page -= 1;
        List<Iteration> list = new ArrayList<>();
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM iteration WHERE iteration_name LIKE ? LIMIT ? OFFSET ?");
            stmt.setString(1, '%' + name + '%');
            stmt.setInt(2, entriesPerPage);
            stmt.setInt(3, page * entriesPerPage);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Iteration ite = new Iteration();
                ite.setId(rs.getInt("iteration_id"));
                ite.setSubject_id(rs.getInt("subject_id"));
                ite.setIteration_name(rs.getString("iteration_name"));
                ite.setEval_weight(rs.getInt("eval_weight"));
                ite.setOn_going(rs.getBoolean("is_ongoing"));
                ite.setDescription(rs.getString("description"));
                ite.setStatus(rs.getBoolean("status"));
                list.add(ite);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public int getTotalIterationsStatus(boolean status) {
        int count = 0;
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT COUNT(*) FROM iteration WHERE status = ?");
            stmt.setBoolean(1, status);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return count;
    }

    public List<Iteration> getIterationsStatus(int page, int entriesPerPage, boolean status) {
        page -= 1;
        List<Iteration> list = new ArrayList<>();
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM iteration WHERE status = ? LIMIT ? OFFSET ?");
            stmt.setBoolean(1, status);
            stmt.setInt(2, entriesPerPage);
            stmt.setInt(3, page * entriesPerPage);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Iteration ite = new Iteration();
                ite.setId(rs.getInt("iteration_id"));
                ite.setSubject_id(rs.getInt("subject_id"));
                ite.setIteration_name(rs.getString("iteration_name"));
                ite.setEval_weight(rs.getInt("eval_weight"));
                ite.setOn_going(rs.getBoolean("is_ongoing"));
                ite.setDescription(rs.getString("description"));
                ite.setStatus(rs.getBoolean("status"));
                list.add(ite);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Iteration> getIterationsOrder(int page, int entriesPerPage, String order) {
        page -= 1;
        List<Iteration> list = new ArrayList<>();
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM iteration ORDER BY eval_weight " + order + " LIMIT ? OFFSET ?");
            stmt.setInt(1, entriesPerPage);
            stmt.setInt(2, page * entriesPerPage);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Iteration ite = new Iteration();
                ite.setId(rs.getInt("iteration_id"));
                ite.setSubject_id(rs.getInt("subject_id"));
                ite.setIteration_name(rs.getString("iteration_name"));
                ite.setEval_weight(rs.getInt("eval_weight"));
                ite.setOn_going(rs.getBoolean("is_ongoing"));
                ite.setDescription(rs.getString("description"));
                ite.setStatus(rs.getBoolean("status"));
                list.add(ite);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateIterationStatus(int id, int updater_id, boolean status) {
        Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        try {
            PreparedStatement stmt = getConnection().prepareStatement("UPDATE iteration SET status = ?, updater_id = ?, updated_time = ? WHERE iteration_id = ?");
            stmt.setBoolean(1, status);
            stmt.setInt(2, updater_id);
            stmt.setTimestamp(3, date);
            stmt.setInt(4, id);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Iteration getIterationDetails(int id) {
        Iteration ite = null;
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM iteration WHERE iteration_id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ite = new Iteration();
                ite.setId(rs.getInt("iteration_id"));
                ite.setSubject_id(rs.getInt("subject_id"));
                ite.setIteration_name(rs.getString("iteration_name"));
                ite.setEval_weight(rs.getInt("eval_weight"));
                ite.setOn_going(rs.getBoolean("is_ongoing"));
                ite.setDescription(rs.getString("description"));
                ite.setStatus(rs.getBoolean("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ite;
    }

    public void updateIterationDetails(Iteration ite, int user_id) {
        Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        try {
            PreparedStatement stmt = getConnection().prepareStatement("UPDATE iteration SET "
                    + "subject_id = ?, "
                    + "iteration_name = ?, "
                    + "eval_weight = ?, "
                    + "is_ongoing = ?, "
                    + "status = ?, "
                    + "description = ?, "
                    + "updater_id = ?, "
                    + "updated_time = ? "
                    + "WHERE iteration_id = ?");
            stmt.setInt(1, ite.getSubject_id());
            stmt.setString(2, ite.getIteration_name());
            stmt.setInt(3, ite.getEval_weight());
            stmt.setBoolean(4, ite.isOn_going());
            stmt.setBoolean(5, ite.isStatus());
            stmt.setString(6, ite.getDescription());
            stmt.setInt(7, user_id);
            stmt.setTimestamp(8, date);
            stmt.setInt(9, ite.getId());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addNewIteration(Iteration ite, int user_id) {
        Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        try {
            PreparedStatement stmt = getConnection().prepareStatement("INSERT INTO iteration (subject_id, iteration_name, eval_weight, is_ongoing, status, description, creator_id, created_time) VALUES (?,?,?,?,?,?,?,?)");
            stmt.setInt(1, ite.getSubject_id());
            stmt.setString(2, ite.getIteration_name());
            stmt.setInt(3, ite.getEval_weight());
            stmt.setBoolean(4, ite.isOn_going());
            stmt.setBoolean(5, ite.isStatus());
            stmt.setString(6, ite.getDescription());
            stmt.setInt(7, user_id);
            stmt.setTimestamp(8, date);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
