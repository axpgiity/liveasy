package com.example.Liveasy;

import java.sql.DriverManager;

public class DriverTest {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("PostgreSQL JDBC Driver Registered!");
            DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/Load_Management_System",
                    "postgres",
                    "your_password"
            );
            System.out.println("Connection successful!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}