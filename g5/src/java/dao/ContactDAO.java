/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Contact;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author Seth
 */
public class ContactDAO extends MySQLDAO {

    public void addNewContact(Contact contact) {
        Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        try {
            PreparedStatement stmt = getConnection().prepareStatement("INSERT INTO web_contact(full_name, email, mobile, category_id, message, status, created_time) "
                    + "VALUES (?,?,?,?,?,?,?)");
            stmt.setString(1, contact.getFullname());
            stmt.setString(2, contact.getEmail());
            stmt.setString(3, contact.getPhone());
            stmt.setInt(4, contact.getCategoryId());
            stmt.setString(5, contact.getMessage());
            stmt.setInt(6, 0);
            stmt.setTimestamp(7, date);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
