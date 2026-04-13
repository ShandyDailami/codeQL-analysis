import java.sql.*;
import java.util.Properties;

public class java_16948_JDBCQueryHandler_A03 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a Connection
            Connection conn = getConnection();

            // Step 2: Prepare the Statement
            Statement stmt = conn.createStatement();

            // Step 3: Execute the Query
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");

            // Step 4: Process the ResultSet
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Step 5: Close the Connection
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() {
        Properties props = new Properties();
        props.setProperty("user", USERNAME);
        props.setProperty("password", PASSWORD);
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, props);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}