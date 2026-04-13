import java.sql.*;

public class java_03963_JDBCQueryHandler_A03 {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Establish a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to the database");

            // Step 2: Create a statement
            stmt = conn.createStatement();
            System.out.println("Statement created");

            // Step 3: Execute a SQL query
            String sql = "SELECT * FROM Users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'";
            ResultSet rs = stmt.executeQuery(sql);

            // Step 4: Process the ResultSet
            while (rs.next()) {
                System.out.println("Found user: " + rs.getString("username"));
            }

            // Step 5: Clean up the statement and connection
            rs.close();
            stmt.close();
            conn.close();
            System.out.println("Connection and statement closed");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}