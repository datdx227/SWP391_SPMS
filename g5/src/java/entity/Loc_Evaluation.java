/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Acer
 */
public class Loc_Evaluation {
    private int id;
    private int function_id;
    private int milestone_id;
    private int complexity_id;
    private int quality_id;
    private String converted_loc;
    private int is_late_submit;
    private String comment;
    private int new_milestone_id;
    private int new_complexity_id;
    private int new_quality_id;
    private String new_converted_loc;
    private String function_name;
    private String complexity_name;
    private String quality_name;
    private int student_id;

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }
    
    public String getFunction_name() {
        return function_name;
    }

    public void setFunction_name(String function_name) {
        this.function_name = function_name;
    }

    public String getComplexity_name() {
        return complexity_name;
    }

    public void setComplexity_name(String complexity_name) {
        this.complexity_name = complexity_name;
    }

    public String getQuality_name() {
        return quality_name;
    }

    public void setQuality_name(String quality_name) {
        this.quality_name = quality_name;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFunction_id() {
        return function_id;
    }

    public void setFunction_id(int function_id) {
        this.function_id = function_id;
    }

    public int getMilestone_id() {
        return milestone_id;
    }

    public void setMilestone_id(int milestone_id) {
        this.milestone_id = milestone_id;
    }

    public int getComplexity_id() {
        return complexity_id;
    }

    public void setComplexity_id(int complexity_id) {
        this.complexity_id = complexity_id;
    }

    public int getQuality_id() {
        return quality_id;
    }

    public void setQuality_id(int quality_id) {
        this.quality_id = quality_id;
    }

    public String getConverted_loc() {
        return converted_loc;
    }

    public void setConverted_loc(String converted_loc) {
        this.converted_loc = converted_loc;
    }

    public int getIs_late_submit() {
        return is_late_submit;
    }

    public void setIs_late_submit(int is_late_submit) {
        this.is_late_submit = is_late_submit;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getNew_milestone_id() {
        return new_milestone_id;
    }

    public void setNew_milestone_id(int new_milestone_id) {
        this.new_milestone_id = new_milestone_id;
    }

    public int getNew_complexity_id() {
        return new_complexity_id;
    }

    public void setNew_complexity_id(int new_complexity_id) {
        this.new_complexity_id = new_complexity_id;
    }

    public int getNew_quality_id() {
        return new_quality_id;
    }

    public void setNew_quality_id(int new_quality_id) {
        this.new_quality_id = new_quality_id;
    }

    public String getNew_converted_loc() {
        return new_converted_loc;
    }

    public void setNew_converted_loc(String new_converted_loc) {
        this.new_converted_loc = new_converted_loc;
    }
    
}
