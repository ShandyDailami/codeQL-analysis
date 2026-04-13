import java.sql.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.net.*;
import java.math.*;
import java.awt.*;
import java.nio.file.*;
import java.nio.charset.*;
import javax.sql.*;

public class java_18338_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();

            String selectSQL = "SELECT * FROM Users";
            ResultSet rs = stmt.executeQuery(selectSQL);

            while (rs.next()) {
                String passwordDB = rs.getString("Password");
                System.out.println("Password in database: " + passwordDB);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}