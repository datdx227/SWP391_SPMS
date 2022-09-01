/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author quang
 */
public class Manager {

    private int manager_id;
    private String manager_name;

    public Manager() {
    }

    public Manager(int manager_id, String manager_name) {
        this.manager_id = manager_id;
        this.manager_name = manager_name;
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

    @Override
    public String toString() {
        return "Manager{" + "manager_id=" + manager_id + ", manager_name=" + manager_name + '}';
    }

}
