/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Acer
 */
public class MySQLDAO {
    private Connection connection = null;

    public Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                String url
                        = System.getProperty("JDBC_URL", "jdbc:mysql://localhost:3306/SPM?useSSL=false");
                String username = System.getProperty("JDBC_USERNAME", "root");
                String password = System.getProperty("JDBC_PASSWORD", "1234");
                connection = DriverManager.getConnection(url, username, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
