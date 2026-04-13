import java.sql.*;

public class java_31413_JDBCQueryHandler_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASS = "mypassword";

    public static void main(String[] args) {
        try {
            // Step 1: Establish the connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to the database");

            // Step 2: Prepare the SQL statement
            String sql = "SELECT * FROM Users WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 123); // Set the id here

            // Step 3: Execute the query
            ResultSet rs = pstmt.executeQuery();

            // Step 4: Process the result
            while (rs.next()) {
                String username = rs.getString("username");
                // More operations here...
            }

            // Step 5: Clean up
            rs.close();
            pstmt.close();
            conn.close();
            System.out.println("Disconnected from the database");

        } catch (SQLException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}