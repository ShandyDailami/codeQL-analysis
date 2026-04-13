import java.sql.*;

public class java_25165_JDBCQueryHandler_A07 {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "username";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Connect to the database
            Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
            System.out.println("Connected to database successfully");

            // Step 2: Run a simple query
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM my_table";
            ResultSet rs = stmt.executeQuery(query);

            // Step 3: Process the results (if any)
            while (rs.next()) {
                System.out.println("Result: " + rs.getString("column_name"));
            }

            // Close the ResultSet, Statement, and Connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            // Handle any SQL-related errors
            System.out.println("Error: " + e.getMessage());
        }
    }
}