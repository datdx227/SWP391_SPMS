/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author quang
 */
public class Iteration_Evaluation {

    private int evaluation_id;
    private int milestone_id;
    private String milestone_name;
    private int team_id;
    private String team_name;
    private int class_id;
    private String class_name;
    private int user_id;
    private String user_name;
    private int loc;
    private int bonus;
    private int total_grade;
    private String comment;
    private String indi_comment;

    public Iteration_Evaluation() {
    }

    public Iteration_Evaluation(int evaluation_id, int milestone_id, String milestone_name, int team_id, String team_name, int class_id, String class_name, int user_id, String user_name, int loc, int bonus, int total_grade, String comment, String indi_comment) {
        this.evaluation_id = evaluation_id;
        this.milestone_id = milestone_id;
        this.milestone_name = milestone_name;
        this.team_id = team_id;
        this.team_name = team_name;
        this.class_id = class_id;
        this.class_name = class_name;
        this.user_id = user_id;
        this.user_name = user_name;
        this.loc = loc;
        this.bonus = bonus;
        this.total_grade = total_grade;
        this.comment = comment;
        this.indi_comment = indi_comment;
    }

    public int getEvaluation_id() {
        return evaluation_id;
    }

    public void setEvaluation_id(int evaluation_id) {
        this.evaluation_id = evaluation_id;
    }

    public int getMilestone_id() {
        return milestone_id;
    }

    public void setMilestone_id(int milestone_id) {
        this.milestone_id = milestone_id;
    }

    public String getMilestone_name() {
        return milestone_name;
    }

    public void setMilestone_name(String milestone_name) {
        this.milestone_name = milestone_name;
    }

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getLoc() {
        return loc;
    }

    public void setLoc(int loc) {
        this.loc = loc;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getTotal_grade() {
        return total_grade;
    }

    public void setTotal_grade(int total_grade) {
        this.total_grade = total_grade;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getIndi_comment() {
        return indi_comment;
    }

    public void setIndi_comment(String indi_comment) {
        this.indi_comment = indi_comment;
    }

    @Override
    public String toString() {
        return "Iteration_Evaluation{" + "evaluation_id=" + evaluation_id + ", milestone_id=" + milestone_id + ", milestone_name=" + milestone_name + ", team_id=" + team_id + ", team_name=" + team_name + ", class_id=" + class_id + ", class_name=" + class_name + ", user_id=" + user_id + ", user_name=" + user_name + ", loc=" + loc + ", bonus=" + bonus + ", total_grade=" + total_grade + ", comment=" + comment + ", indi_comment=" + indi_comment + '}';
    }

}
