/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Seth
 */
public class Criteria {

    private int id;
    private int iterationId;
    private String criteriaName;
    private boolean isTeamEval;
    private int evalWeight;
    private int maxLoc;
    private boolean status;
    private String description;

    public Criteria() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIterationId() {
        return iterationId;
    }

    public void setIterationId(int iterationId) {
        this.iterationId = iterationId;
    }

    public String getCriteriaName() {
        return criteriaName;
    }

    public void setCriteriaName(String criteriaName) {
        this.criteriaName = criteriaName;
    }

    public boolean isIsTeamEval() {
        return isTeamEval;
    }

    public void setIsTeamEval(boolean isTeamEval) {
        this.isTeamEval = isTeamEval;
    }

    public int getEvalWeight() {
        return evalWeight;
    }

    public void setEvalWeight(int evalWeight) {
        this.evalWeight = evalWeight;
    }

    public int getMaxLoc() {
        return maxLoc;
    }

    public void setMaxLoc(int maxLoc) {
        this.maxLoc = maxLoc;
    }

    public boolean isStatus() {
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
