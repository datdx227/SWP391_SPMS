/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Date;

/**
 *
 * @author Seth
 */
public class Milestone {

    private int milestone_id;
    private String milestone_name;
    private int iteration_id;
    private int class_id;
    private Date from_date;
    private Date to_date;
    private String description;
    private int status;

    public Milestone() {
    }

    public Milestone(int milestone_id, String milestone_name, int iteration_id, int class_id, Date from_date, Date to_date, String description, int status) {
        this.milestone_id = milestone_id;
        this.milestone_name = milestone_name;
        this.iteration_id = iteration_id;
        this.class_id = class_id;
        this.from_date = from_date;
        this.to_date = to_date;
        this.description = description;
        this.status = status;
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

    public int getIteration_id() {
        return iteration_id;
    }

    public void setIteration_id(int iteration_id) {
        this.iteration_id = iteration_id;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public Date getFrom_date() {
        return from_date;
    }

    public void setFrom_date(Date from_date) {
        this.from_date = from_date;
    }

    public Date getTo_date() {
        return to_date;
    }

    public void setTo_date(Date to_date) {
        this.to_date = to_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Milestone{" + "milestone_id=" + milestone_id + ", milestone_name=" + milestone_name + ", iteration_id=" + iteration_id + ", class_id=" + class_id + ", from_date=" + from_date + ", to_date=" + to_date + ", description=" + description + ", status=" + status + '}';
    }

}
