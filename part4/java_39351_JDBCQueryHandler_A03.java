import java.sql.*;

public class java_39351_JDBCQueryHandler_A03 {
    // Database credentials
    private static final String USER = "username";
    private static final String PASS = "password";
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";

    public static void main(String[] args) {
        Connection connection = null;
        Statement stmt = null;
        try {
            // Step 1: Establish a connection
            connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connected successfully to MySQL server");

            // Step 2: Create a statement
            stmt = connection.createStatement();

            // Step 3: Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM employees WHERE id = " + args[0]);

            // Step 4: Process the result set
            while (rs.next()) {
                System.out.println("id = " + rs.getInt("id"));
                System.out.println("name = " + rs.getString("name"));
            }

            // Step 5: Clean up
            rs.close();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}