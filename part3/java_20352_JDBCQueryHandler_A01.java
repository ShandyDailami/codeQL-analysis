import java.sql.*;

public class java_20352_JDBCQueryHandler_A01 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Establish a connection to the database
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connected to the database");

            // Step 2: Create a statement
            stmt = conn.createStatement();
            System.out.println("Statement created");

            // Step 3: Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users");
            System.out.println("Query executed");

            // Step 4: Process the results
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }
            rs.close();

            // Step 5: Close the statement and connection
            stmt.close();
            conn.close();
            System.out.println("Connection and statement closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Ensure all resources are closed
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            System.out.println("All resources were closed");
        }
    }
}