import java.sql.*;

public class java_07395_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        // Step 1: Establish a Connection
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connected to the database");

            // Step 2: Prepare a Statement
            try (Statement stmt = conn.createStatement()) {
                // Step 3: Execute a SQL Query
                ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE username = '" + args[0] + "'");

                // Step 4: Process the ResultSet
                while (rs.next()) {
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    System.out.println("Username: " + username);
                    System.out.println("Password: " + password);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
            e.printStackTrace();
        }
    }
}