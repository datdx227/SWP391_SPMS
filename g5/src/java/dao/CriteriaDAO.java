/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Criteria;
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
public class CriteriaDAO extends MySQLDAO {

    public int getTotalCriteria() {
        int count = 0;
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT COUNT(*) FROM evaluation_criteria");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }

    public int getTotalCriteriaByIterationId(int iterationId) {
        int count = 0;
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT COUNT(*) FROM evaluation_criteria WHERE iteration_id = ?");
            stmt.setInt(1, iterationId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }

    public int getTotalCriteriaBySubjectId(int subjectId) {
        int count = 0;
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT COUNT(*) FROM evaluation_criteria criteria JOIN iteration ON criteria.iteration_id = iteration.iteration_id WHERE iteration.subject_id = ?");
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

    public int getTotalCriteriaByStatus(boolean status) {
        int count = 0;
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT COUNT(*) FROM evaluation_criteria WHERE status = ?");
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

    public int getTotalCriteriaByName(String name) {
        int count = 0;
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT COUNT(*) FROM evaluation_criteria WHERE criteria_name LIKE ?");
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

    public int getTotalCriteriaBySubjectIdAndIterationId(int subjectId, int iterationId) {
        int count = 0;
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT COUNT(*) FROM evaluation_criteria criteria JOIN iteration ON criteria.iteration_id = iteration.iteration_id WHERE iteration.subject_id = ? AND criteria.iteration_id = ?");
            stmt.setInt(1, subjectId);
            stmt.setInt(2, iterationId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }

    public int getTotalCriteriaBySubjectIdAndIterationIdAndStatus(int subjectId, int iterationId, boolean status) {
        int count = 0;
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT COUNT(*) FROM evaluation_criteria criteria JOIN iteration ON criteria.iteration_id = iteration.iteration_id WHERE iteration.subject_id = ? AND criteria.iteration_id = ? AND criteria.status = ?");
            stmt.setInt(1, subjectId);
            stmt.setInt(2, iterationId);
            stmt.setBoolean(3, status);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }

    public int getTotalCriteriaBySubjectIdAndIterationIdAndName(int subjectId, int iterationId, String name) {
        int count = 0;
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT COUNT(*) FROM evaluation_criteria criteria JOIN iteration ON criteria.iteration_id = iteration.iteration_id WHERE iteration.subject_id = ? AND criteria.iteration_id = ? AND criteria.criteria_name LIKE ?");
            stmt.setInt(1, subjectId);
            stmt.setInt(2, iterationId);
            stmt.setString(3, '%' + name + '$');
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }

    public List<Criteria> getCriteriaList(int page, int entriesPerPage) {
        page -= 1;
        List<Criteria> list = new ArrayList<>();
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM evaluation_criteria LIMIT ? OFFSET ?");
            stmt.setInt(1, entriesPerPage);
            stmt.setInt(2, page * entriesPerPage);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Criteria crite = new Criteria();
                crite.setId(rs.getInt("criteria_id"));
                crite.setIterationId(rs.getInt("iteration_id"));
                crite.setCriteriaName(rs.getString("criteria_name"));
                crite.setIsTeamEval(rs.getBoolean("is_team_eval"));
                crite.setEvalWeight(rs.getInt("eval_weight"));
                crite.setMaxLoc(rs.getInt("max_loc"));
                crite.setStatus(rs.getBoolean("status"));
                crite.setDescription(rs.getString("description"));
                list.add(crite);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Criteria> getCriteriaListByIterationId(int page, int entriesPerPage, int iterationId) {
        page -= 1;
        List<Criteria> list = new ArrayList<>();
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM evaluation_criteria WHERE iteration_id = ? LIMIT ? OFFSET ?");
            stmt.setInt(1, iterationId);
            stmt.setInt(2, entriesPerPage);
            stmt.setInt(3, page * entriesPerPage);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Criteria crite = new Criteria();
                crite.setId(rs.getInt("criteria_id"));
                crite.setIterationId(rs.getInt("iteration_id"));
                crite.setCriteriaName(rs.getString("criteria_name"));
                crite.setIsTeamEval(rs.getBoolean("is_team_eval"));
                crite.setEvalWeight(rs.getInt("eval_weight"));
                crite.setMaxLoc(rs.getInt("max_loc"));
                crite.setStatus(rs.getBoolean("status"));
                crite.setDescription(rs.getString("description"));
                list.add(crite);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Criteria> getCriteriaListBySubjectId(int page, int entriesPerPage, int subjectId) {
        page -= 1;
        List<Criteria> list = new ArrayList<>();
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT criteria.criteria_id, "
                    + "criteria.iteration_id, "
                    + "criteria.criteria_name, "
                    + "criteria.is_team_eval, "
                    + "criteria.eval_weight, "
                    + "criteria.max_loc, "
                    + "criteria.status, "
                    + "criteria.description "
                    + "FROM evaluation_criteria criteria JOIN iteration "
                    + "ON criteria.iteration_id = iteration.iteration_id "
                    + "WHERE iteration.subject_id = ? LIMIT ? OFFSET ?");
            stmt.setInt(1, subjectId);
            stmt.setInt(2, entriesPerPage);
            stmt.setInt(3, page * entriesPerPage);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Criteria crite = new Criteria();
                crite.setId(rs.getInt("criteria_id"));
                crite.setIterationId(rs.getInt("iteration_id"));
                crite.setCriteriaName(rs.getString("criteria_name"));
                crite.setIsTeamEval(rs.getBoolean("is_team_eval"));
                crite.setEvalWeight(rs.getInt("eval_weight"));
                crite.setMaxLoc(rs.getInt("max_loc"));
                crite.setStatus(rs.getBoolean("status"));
                crite.setDescription(rs.getString("description"));
                list.add(crite);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Criteria> getCriteriaListBySubjectIdAndIterationId(int page, int entriesPerPage, int subjectId, int iterationId) {
        page -= 1;
        List<Criteria> list = new ArrayList<>();
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT criteria.criteria_id, "
                    + "criteria.iteration_id, "
                    + "criteria.criteria_name, "
                    + "criteria.is_team_eval, "
                    + "criteria.eval_weight, "
                    + "criteria.max_loc, "
                    + "criteria.status, "
                    + "criteria.description "
                    + "FROM evaluation_criteria criteria JOIN iteration "
                    + "ON criteria.iteration_id = iteration.iteration_id "
                    + "WHERE iteration.subject_id = ? AND criteria.iteration_id = ? LIMIT ? OFFSET ?");
            stmt.setInt(1, subjectId);
            stmt.setInt(2, iterationId);
            stmt.setInt(3, entriesPerPage);
            stmt.setInt(4, page * entriesPerPage);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Criteria crite = new Criteria();
                crite.setId(rs.getInt("criteria_id"));
                crite.setIterationId(rs.getInt("iteration_id"));
                crite.setCriteriaName(rs.getString("criteria_name"));
                crite.setIsTeamEval(rs.getBoolean("is_team_eval"));
                crite.setEvalWeight(rs.getInt("eval_weight"));
                crite.setMaxLoc(rs.getInt("max_loc"));
                crite.setStatus(rs.getBoolean("status"));
                crite.setDescription(rs.getString("description"));
                list.add(crite);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Criteria> getCriteriaListBySubjectIdAndIterationIdAndStatus(int page, int entriesPerPage, int subjectId, int iterationId, boolean status) {
        page -= 1;
        List<Criteria> list = new ArrayList<>();
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT criteria.criteria_id, "
                    + "criteria.iteration_id, "
                    + "criteria.criteria_name, "
                    + "criteria.is_team_eval, "
                    + "criteria.eval_weight, "
                    + "criteria.max_loc, "
                    + "criteria.status, "
                    + "criteria.description "
                    + "FROM evaluation_criteria criteria JOIN iteration "
                    + "ON criteria.iteration_id = iteration.iteration_id "
                    + "WHERE iteration.subject_id = ? "
                    + "AND criteria.iteration_id = ? "
                    + "AND criteria.status = ? LIMIT ? OFFSET ?");
            stmt.setInt(1, subjectId);
            stmt.setInt(2, iterationId);
            stmt.setBoolean(3, status);
            stmt.setInt(4, entriesPerPage);
            stmt.setInt(5, page * entriesPerPage);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Criteria crite = new Criteria();
                crite.setId(rs.getInt("criteria_id"));
                crite.setIterationId(rs.getInt("iteration_id"));
                crite.setCriteriaName(rs.getString("criteria_name"));
                crite.setIsTeamEval(rs.getBoolean("is_team_eval"));
                crite.setEvalWeight(rs.getInt("eval_weight"));
                crite.setMaxLoc(rs.getInt("max_loc"));
                crite.setStatus(rs.getBoolean("status"));
                crite.setDescription(rs.getString("description"));
                list.add(crite);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Criteria> getCriteriaListBySubjectIdAndIterationIdAndName(int page, int entriesPerPage, int subjectId, int iterationId, String name) {
        page -= 1;
        List<Criteria> list = new ArrayList<>();
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT criteria.criteria_id, "
                    + "criteria.iteration_id, "
                    + "criteria.criteria_name, "
                    + "criteria.is_team_eval, "
                    + "criteria.eval_weight, "
                    + "criteria.max_loc, "
                    + "criteria.status, "
                    + "criteria.description "
                    + "FROM evaluation_criteria criteria JOIN iteration "
                    + "ON criteria.iteration_id = iteration.iteration_id "
                    + "WHERE iteration.subject_id = ? "
                    + "AND criteria.iteration_id = ? "
                    + "AND criteria.criteria_name LIKE ? LIMIT ? OFFSET ?");
            stmt.setInt(1, subjectId);
            stmt.setInt(2, iterationId);
            stmt.setString(3, '%' + name + '%');
            stmt.setInt(4, entriesPerPage);
            stmt.setInt(5, page * entriesPerPage);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Criteria crite = new Criteria();
                crite.setId(rs.getInt("criteria_id"));
                crite.setIterationId(rs.getInt("iteration_id"));
                crite.setCriteriaName(rs.getString("criteria_name"));
                crite.setIsTeamEval(rs.getBoolean("is_team_eval"));
                crite.setEvalWeight(rs.getInt("eval_weight"));
                crite.setMaxLoc(rs.getInt("max_loc"));
                crite.setStatus(rs.getBoolean("status"));
                crite.setDescription(rs.getString("description"));
                list.add(crite);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Criteria> getCriteriaListBySubjectIdOrdered(int page, int entriesPerPage, int subjectId, String order) {
        page -= 1;
        List<Criteria> list = new ArrayList<>();
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT criteria.criteria_id, "
                    + "criteria.iteration_id, "
                    + "criteria.criteria_name, "
                    + "criteria.is_team_eval, "
                    + "criteria.eval_weight, "
                    + "criteria.max_loc, "
                    + "criteria.status, "
                    + "criteria.description "
                    + "FROM evaluation_criteria criteria JOIN iteration "
                    + "ON criteria.iteration_id = iteration.iteration_id "
                    + "WHERE iteration.subject_id = ? ORDER BY criteria.eval_weight " + order + " LIMIT ? OFFSET ?");
            stmt.setInt(1, subjectId);
            stmt.setInt(2, entriesPerPage);
            stmt.setInt(3, page * entriesPerPage);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Criteria crite = new Criteria();
                crite.setId(rs.getInt("criteria_id"));
                crite.setIterationId(rs.getInt("iteration_id"));
                crite.setCriteriaName(rs.getString("criteria_name"));
                crite.setIsTeamEval(rs.getBoolean("is_team_eval"));
                crite.setEvalWeight(rs.getInt("eval_weight"));
                crite.setMaxLoc(rs.getInt("max_loc"));
                crite.setStatus(rs.getBoolean("status"));
                crite.setDescription(rs.getString("description"));
                list.add(crite);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Criteria> getCriteriaListByStatus(int page, int entriesPerPage, boolean status) {
        page -= 1;
        List<Criteria> list = new ArrayList<>();
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM evaluation_criteria WHERE status = ? LIMIT ? OFFSET ?");
            stmt.setBoolean(1, status);
            stmt.setInt(2, entriesPerPage);
            stmt.setInt(3, page * entriesPerPage);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Criteria crite = new Criteria();
                crite.setId(rs.getInt("criteria_id"));
                crite.setIterationId(rs.getInt("iteration_id"));
                crite.setCriteriaName(rs.getString("criteria_name"));
                crite.setIsTeamEval(rs.getBoolean("is_team_eval"));
                crite.setEvalWeight(rs.getInt("eval_weight"));
                crite.setMaxLoc(rs.getInt("max_loc"));
                crite.setStatus(rs.getBoolean("status"));
                crite.setDescription(rs.getString("description"));
                list.add(crite);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Criteria> getCriteriaListByName(int page, int entriesPerPage, String name) {
        page -= 1;
        List<Criteria> list = new ArrayList<>();
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM evaluation_criteria WHERE criteria_name LIKE ? LIMIT ? OFFSET ?");
            stmt.setString(1, '%' + name + '%');
            stmt.setInt(2, entriesPerPage);
            stmt.setInt(3, page * entriesPerPage);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Criteria crite = new Criteria();
                crite.setId(rs.getInt("criteria_id"));
                crite.setIterationId(rs.getInt("iteration_id"));
                crite.setCriteriaName(rs.getString("criteria_name"));
                crite.setIsTeamEval(rs.getBoolean("is_team_eval"));
                crite.setEvalWeight(rs.getInt("eval_weight"));
                crite.setMaxLoc(rs.getInt("max_loc"));
                crite.setStatus(rs.getBoolean("status"));
                crite.setDescription(rs.getString("description"));
                list.add(crite);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Criteria> getCriteriaListByOrder(int page, int entriesPerPage, String order) {
        page -= 1;
        List<Criteria> list = new ArrayList<>();
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM evaluation_criteria ORDER BY eval_weight " + order + " LIMIT ? OFFSET ?");
            stmt.setInt(1, entriesPerPage);
            stmt.setInt(2, page * entriesPerPage);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Criteria crite = new Criteria();
                crite.setId(rs.getInt("criteria_id"));
                crite.setIterationId(rs.getInt("iteration_id"));
                crite.setCriteriaName(rs.getString("criteria_name"));
                crite.setIsTeamEval(rs.getBoolean("is_team_eval"));
                crite.setEvalWeight(rs.getInt("eval_weight"));
                crite.setMaxLoc(rs.getInt("max_loc"));
                crite.setStatus(rs.getBoolean("status"));
                crite.setDescription(rs.getString("description"));
                list.add(crite);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Criteria getIterationCriteriaDetails(int id) {
        Criteria crite = null;
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM evaluation_criteria WHERE criteria_id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                crite = new Criteria();
                crite.setId(rs.getInt("criteria_id"));
                crite.setIterationId(rs.getInt("iteration_id"));
                crite.setCriteriaName(rs.getString("criteria_name"));
                crite.setIsTeamEval(rs.getBoolean("is_team_eval"));
                crite.setEvalWeight(rs.getInt("eval_weight"));
                crite.setMaxLoc(rs.getInt("max_loc"));
                crite.setStatus(rs.getBoolean("status"));
                crite.setDescription(rs.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return crite;
    }

    public void updateCriteriaStatus(int id, int updaterId, boolean status) {
        Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        try {
            PreparedStatement stmt = getConnection().prepareStatement("UPDATE evaluation_criteria SET status = ?, updater_id = ?, updated_time = ? WHERE criteria_id = ?");
            stmt.setBoolean(1, status);
            stmt.setInt(2, updaterId);
            stmt.setTimestamp(3, date);
            stmt.setInt(4, id);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCriteriaDetails(Criteria crite, int updaterId) {
        Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        try {
            PreparedStatement stmt = getConnection().prepareStatement("UPDATE evaluation_criteria SET criteria_name = ?, "
                    + "is_team_eval = ?, "
                    + "eval_weight = ?, "
                    + "max_loc = ?, "
                    + "status = ?, "
                    + "description = ?, "
                    + "updater_id = ?, "
                    + "updated_time = ? "
                    + "WHERE criteria_id = ?");
            stmt.setString(1, crite.getCriteriaName());
            stmt.setBoolean(2, crite.isIsTeamEval());
            stmt.setInt(3, crite.getEvalWeight());
            stmt.setInt(4, crite.getMaxLoc());
            stmt.setBoolean(5, crite.isStatus());
            stmt.setString(6, crite.getDescription());
            stmt.setInt(7, updaterId);
            stmt.setTimestamp(8, date);
            stmt.setInt(9, crite.getId());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getSubjectNameByCriteriaId(int id) {
        String subjectName = "";
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT subject.subject_name "
                    + "FROM evaluation_criteria criteria "
                    + "JOIN iteration iteration "
                    + "ON criteria.iteration_id = iteration.iteration_id "
                    + "JOIN subject subject "
                    + "ON iteration.subject_id = subject.subject_id "
                    + "WHERE criteria.criteria_id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                subjectName = rs.getString("subject_name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subjectName;
    }

    public String getIterationNameByCriteriaId(int id) {
        String iterationName = "";
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT iteration.iteration_name "
                    + "FROM evaluation_criteria criteria "
                    + "JOIN iteration iteration "
                    + "ON criteria.iteration_id = iteration.iteration_id "
                    + "WHERE criteria.criteria_id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                iterationName = rs.getString("iteration_name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return iterationName;
    }

    public void addNewCriteria(Criteria crite, int updaterId) {
        Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        try {
            PreparedStatement stmt = getConnection().prepareStatement("INSERT INTO evaluation_criteria (iteration_id, criteria_name, is_team_eval, eval_weight, max_loc, status, description, creator_id, created_time) VALUES (?,?,?,?,?,?,?,?,?)");
            stmt.setInt(1, crite.getIterationId());
            stmt.setString(2, crite.getCriteriaName());
            stmt.setBoolean(3, crite.isIsTeamEval());
            stmt.setInt(4, crite.getEvalWeight());
            stmt.setInt(5, crite.getMaxLoc());
            stmt.setBoolean(6, crite.isStatus());
            stmt.setString(7, crite.getDescription());
            stmt.setInt(8, updaterId);
            stmt.setTimestamp(9, date);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
