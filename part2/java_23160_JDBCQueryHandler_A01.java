import java.sql.*;
import java.security.*;

public class java_23160_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Load the database credentials
            Properties props = new Properties();
            props.setProperty("user", "username");
            props.setProperty("password", "password");
            props.setProperty("useSSL", "false");
            props.setProperty("verifyServerCertificate", "false");
            props.setProperty("requireSSL", "false");

            // Establish the database connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", props);

            // Create a statement
            stmt = conn.createStatement();

            // Sample SQL query
            String sql = "SELECT * FROM Users WHERE username = '" + username + "' AND password = '" + password + "'";

            // Execute the query
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                // Print the username and password
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException se) {
            se.printStackTrace();
        }
    }
}