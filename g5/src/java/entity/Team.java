/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.List;

/**
 *
 * @author Computer
 */
public class Team {
    private int team_id;
    private String project_code;
    private String topic_code;
    private String topic_name;
    private String description;
    private boolean status;
    private String team_name;
    private String status1;
    private String submit;

    public String getSubmit() {
        return submit;
    }

    public void setSubmit(String submit) {
        this.submit = submit;
    }
    
    public String getStatus1() {
        return status1;
    }

    public void setStatus1(String status1) {
        this.status1 = status1;
    }
    
    private List<Team_Evaluation> teamEvaList;

    public List<Team_Evaluation> getTeamEvaList() {
        return teamEvaList;
    }

    public void setTeamEvaList(List<Team_Evaluation> teamEvaList) {
        this.teamEvaList = teamEvaList;
    }
    public Team() {
    }

    public Team(int team_id, String team_name, String project_code, String topic_code, String topic_name, boolean status, String description) {
        this.team_id = team_id;
        this.team_name = team_name;
        this.project_code = project_code;
        this.topic_code = topic_code;
        this.topic_name = topic_name;
        this.status = status;
        this.description = description;
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

    public String getProject_code() {
        return project_code;
    }

    public void setProject_code(String project_code) {
        this.project_code = project_code;
    }

    public String getTopic_code() {
        return topic_code;
    }

    public void setTopic_code(String topic_code) {
        this.topic_code = topic_code;
    }

    public String getTopic_name() {
        return topic_name;
    }

    public void setTopic_name(String topic_name) {
        this.topic_name = topic_name;
    }

    public boolean isStatus() {
        return status;
    }
    
    public boolean getStatus() {
        return status;
    }
    
    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
 
}
