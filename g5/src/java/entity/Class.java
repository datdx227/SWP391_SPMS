package entity;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author quang
 */
public class Class {

    private int id;
    private int subject_id;
    private String subject_name;
    private String class_code;
    private int term_id;
    private String term_name;
    private boolean is_block5;
    private int trainer_id;
    private String trainer_name;
    private boolean status;

    public Class() {
    }

    public Class(int id, String subject_name, String class_code, String term_name, boolean is_block5, String trainer_name, boolean status) {
        this.id = id;
        this.subject_name = subject_name;
        this.class_code = class_code;
        this.term_name = term_name;
        this.is_block5 = is_block5;
        this.trainer_name = trainer_name;
        this.status = status;
    }

    public Class(int id, int subject_id, String class_code, int term_id, boolean is_block5, int trainer_id, boolean status) {
        this.id = id;
        this.subject_id = subject_id;
        this.class_code = class_code;
        this.term_id = term_id;
        this.is_block5 = is_block5;
        this.trainer_id = trainer_id;
        this.status = status;
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

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getClass_code() {
        return class_code;
    }

    public void setClass_code(String class_code) {
        this.class_code = class_code;
    }

    public int getTerm_id() {
        return term_id;
    }

    public void setTerm_id(int term_id) {
        this.term_id = term_id;
    }

    public String getTerm_name() {
        return term_name;
    }

    public void setTerm_name(String term_name) {
        this.term_name = term_name;
    }

    public boolean isIs_block5() {
        return is_block5;
    }

    public void setIs_block5(boolean is_block5) {
        this.is_block5 = is_block5;
    }

    public int getTrainer_id() {
        return trainer_id;
    }

    public void setTrainer_id(int trainer_id) {
        this.trainer_id = trainer_id;
    }

    public String getTrainer_name() {
        return trainer_name;
    }

    public void setTrainer_name(String trainer_name) {
        this.trainer_name = trainer_name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    

    @Override
    public String toString() {
        return "Class{" + "id=" + id + ", subject_id=" + subject_id + ", class_code=" + class_code + ", term_id=" + term_id + ", is_block5=" + is_block5 + ", trainer_id=" + trainer_id + ", status=" + status + '}';
    }
    
}
