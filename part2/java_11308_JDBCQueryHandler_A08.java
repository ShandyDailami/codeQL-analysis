import java.sql.*;

public class java_11308_JDBCQueryHandler_A08 {
    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "password";

    // Main method
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Establish the connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 2: Create a statement
            stmt = conn.createStatement();

            // Step 3: Execute the query
            ResultSet rs = stmt.executeQuery("SELECT * FROM myTable");

            // Step 4: Process the result
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
            }

            // Step 5: Close the resources
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}