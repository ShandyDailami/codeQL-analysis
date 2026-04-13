import java.sql.*;

public class java_40187_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "myuser";
    private static final String password = "mypassword";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a statement
            String sql = "INSERT INTO mytable (column1, column2) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Step 3: Set the parameters
            pstmt.setString(1, "value1");
            pstmt.setInt(2, 1234);

            // Step 4: Execute the statement
            int rowsInserted = pstmt.executeUpdate();
            System.out.println("Rows inserted: " + rowsInserted);

            // Step 5: Clean up
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}