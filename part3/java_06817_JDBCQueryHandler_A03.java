import java.sql.*;

public class java_06817_JDBCQueryHandler_A03 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        // Create connection
        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            // Create statement
            try (Statement stmt = con.createStatement()) {
                // Execute SQL query
                ResultSet rs = stmt.executeQuery("SELECT * FROM Users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'");

                // Process result
                while (rs.next()) {
                    System.out.println("User found!");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error in JDBC operation: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}