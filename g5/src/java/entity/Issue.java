/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author quang
 */
public class Issue {

    private int issue_id;
    private String issue_title;
    private String issue_type;
    private int function_id;
    private String function_title;
    private int milestone_id;
    private String milestone_name;
    private int assigner_id;
    private String assigner_name;
    private int assignee_id;
    private String assignee_name;
    private int team_id;
    private String team_name;
    private boolean status;

    public Issue() {
    }

    public Issue(int issue_id, String issue_title, String issue_type, int function_id, String function_title, int milestone_id, String milestone_name, int assigner_id, String assigner_name, int assignee_id, String assignee_name, int team_id, String team_name, boolean status) {
        this.issue_id = issue_id;
        this.issue_title = issue_title;
        this.issue_type = issue_type;
        this.function_id = function_id;
        this.function_title = function_title;
        this.milestone_id = milestone_id;
        this.milestone_name = milestone_name;
        this.assigner_id = assigner_id;
        this.assigner_name = assigner_name;
        this.assignee_id = assignee_id;
        this.assignee_name = assignee_name;
        this.team_id = team_id;
        this.team_name = team_name;
        this.status = status;
    }

    public int getIssue_id() {
        return issue_id;
    }

    public void setIssue_id(int issue_id) {
        this.issue_id = issue_id;
    }

    public String getIssue_title() {
        return issue_title;
    }

    public void setIssue_title(String issue_title) {
        this.issue_title = issue_title;
    }

    public String getIssue_type() {
        return issue_type;
    }

    public void setIssue_type(String issue_type) {
        this.issue_type = issue_type;
    }

    public int getFunction_id() {
        return function_id;
    }

    public void setFunction_id(int function_id) {
        this.function_id = function_id;
    }

    public String getFunction_title() {
        return function_title;
    }

    public void setFunction_title(String function_title) {
        this.function_title = function_title;
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

    public int getAssigner_id() {
        return assigner_id;
    }

    public void setAssigner_id(int assigner_id) {
        this.assigner_id = assigner_id;
    }

    public String getAssigner_name() {
        return assigner_name;
    }

    public void setAssigner_name(String assigner_name) {
        this.assigner_name = assigner_name;
    }

    public int getAssignee_id() {
        return assignee_id;
    }

    public void setAssignee_id(int assignee_id) {
        this.assignee_id = assignee_id;
    }

    public String getAssignee_name() {
        return assignee_name;
    }

    public void setAssignee_name(String assignee_name) {
        this.assignee_name = assignee_name;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Issue{" + "issue_id=" + issue_id + ", issue_title=" + issue_title + ", issue_type=" + issue_type + ", function_id=" + function_id + ", function_title=" + function_title + ", milestone_id=" + milestone_id + ", milestone_name=" + milestone_name + ", assigner_id=" + assigner_id + ", assigner_name=" + assigner_name + ", assignee_id=" + assignee_id + ", assignee_name=" + assignee_name + ", team_id=" + team_id + ", team_name=" + team_name + ", status=" + status + '}';
    }


}
