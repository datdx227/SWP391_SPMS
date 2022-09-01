/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Seth
 */
public class Iteration {

    private int id;
    private int subject_id;
    private String iteration_name;
    private int eval_weight;
    private boolean on_going;
    private boolean status;
    private String description;

    public Iteration() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public String getIteration_name() {
        return iteration_name;
    }

    public void setIteration_name(String iteration_name) {
        this.iteration_name = iteration_name;
    }

    public int getEval_weight() {
        return eval_weight;
    }

    public void setEval_weight(int eval_weight) {
        this.eval_weight = eval_weight;
    }

    public boolean isOn_going() {
        return on_going;
    }

    public void setOn_going(boolean on_going) {
        this.on_going = on_going;
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
