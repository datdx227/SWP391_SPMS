/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author quang
 */
public class Subject {

    private int id;
    private String subject_code;
    private String subject_name;
    private int manager_id;
    private String manager_name;
    private boolean status;
    private String description;

    public Subject() {
    }

    public Subject(int id, String subject_code, String subject_name, int manager_id, String manager_name, boolean status, String description) {
        this.id = id;
        this.subject_code = subject_code;
        this.subject_name = subject_name;
        this.manager_id = manager_id;
        this.manager_name = manager_name;
        this.status = status;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject_code() {
        return subject_code;
    }

    public void setSubject_code(String subject_code) {
        this.subject_code = subject_code;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public String getManager_name() {
        return manager_name;
    }

    public void setManager_name(String manager_name) {
        this.manager_name = manager_name;
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

    @Override
    public String toString() {
        return "Subject{" + "id=" + id + ", subject_code=" + subject_code + ", subject_name=" + subject_name + ", manager_id=" + manager_id + ", manager_name=" + manager_name + ", status=" + status + ", description=" + description + '}';
    }

}
