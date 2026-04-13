import java.sql.*;

public class java_14696_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a Connection
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare a Statement
            String sql = "SELECT * FROM users WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Step 3: Set Parameters
            pstmt.setInt(1, 1); // For example, we're looking for the user with id 1

            // Step 4: Execute the Statement
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // Step 5: Handle the Result
                System.out.println(rs.getString("username"));
            }

            // Step 6: Close the Statement and Connection
            rs.close();
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            // Handle Security-sensitive operations related to A08_IntegrityFailure
            System.out.println("An error occurred while connecting to the database. Error: " + e.getMessage());
        }
    }
}