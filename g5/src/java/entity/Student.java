/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author BarePC
 */
public class Student {
    private int student_id;
    private int class_id;
    private int team_id;
    private String fullname;
    private String mail;
    private int roll;
    private int user_id;
    private int team_leader;
    private String dropout_date;
    private String user_notes;
    private String ongoing_eval;
    private String final_pres_eval;
    private String final_topic_eval;
    private int status;
    private String description;
    

    public Student() {
    }

    public Student(int student_id,int team_id,String fullname, String mail, int roll, int team_leader,int status) {
        this.student_id = student_id;
        this.team_id = team_id;
        this.fullname = fullname;
        this.mail = mail;
        this.roll = roll;
        this.team_leader = team_leader;
        this.status = status;
    }
    public Student(int class_id, int team_id, int user_id, int team_leader, String dropout_date, String user_notes, String ongoing_eval, String final_pres_eval, String final_topic_eval, int status, String description) {
        this.class_id = class_id;
        this.team_id = team_id;
        this.user_id = user_id;
        this.team_leader = team_leader;
        this.dropout_date = dropout_date;
        this.user_notes = user_notes;
        this.ongoing_eval = ongoing_eval;
        this.final_pres_eval = final_pres_eval;
        this.final_topic_eval = final_topic_eval;
        this.status = status;
        this.description = description;
    }
    

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getTeam_leader() {
        return team_leader;
    }

    public void setTeam_leader(int team_leader) {
        this.team_leader = team_leader;
    }

    public String getDropout_date() {
        return dropout_date;
    }

    public void setDropout_date(String dropout_date) {
        this.dropout_date = dropout_date;
    }

    public String getUser_notes() {
        return user_notes;
    }

    public void setUser_notes(String user_notes) {
        this.user_notes = user_notes;
    }

    public String getOngoing_eval() {
        return ongoing_eval;
    }

    public void setOngoing_eval(String ongoing_eval) {
        this.ongoing_eval = ongoing_eval;
    }

    public String getFinal_pres_eval() {
        return final_pres_eval;
    }

    public void setFinal_pres_eval(String final_pres_eval) {
        this.final_pres_eval = final_pres_eval;
    }

    public String getFinal_topic_eval() {
        return final_topic_eval;
    }

    public void setFinal_topic_eval(String final_topic_eval) {
        this.final_topic_eval = final_topic_eval;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
