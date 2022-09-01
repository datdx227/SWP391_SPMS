/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author quang
 */
public class Assignee {
    private int assignee_id;
    private String assignee_name;

    public Assignee() {
    }

    public Assignee(int assignee_id, String assignee_name) {
        this.assignee_id = assignee_id;
        this.assignee_name = assignee_name;
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

    @Override
    public String toString() {
        return "Assignee{" + "assignee_id=" + assignee_id + ", assignee_name=" + assignee_name + '}';
    }
    
}
