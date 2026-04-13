import java.sql.*;

public class java_17056_JDBCQueryHandler_A08 {
    private static final String DB_URL = "your_database_url";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 2: Prepare a statement
            String query = "SELECT * FROM your_table";
            Statement stmt = conn.createStatement();

            // Step 3: Execute the query
            ResultSet rs = stmt.executeQuery(query);

            // Step 4: Process the result set
            while (rs.next()) {
                // ... process rs
            }

            // Step 5: Close the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error in connecting to database or executing query: " + e);
        }
    }
}