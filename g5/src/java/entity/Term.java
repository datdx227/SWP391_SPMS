/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author quang
 */
public class Term {

    private int term_id;
    private String term_name;

    public Term() {
    }

    public Term(int term_id, String term_name) {
        this.term_id = term_id;
        this.term_name = term_name;
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

    @Override
    public String toString() {
        return "Term{" + "term_id=" + term_id + ", term_name=" + term_name + '}';
    }

}
