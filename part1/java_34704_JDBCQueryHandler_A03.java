import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_34704_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        // Step 1: Establish the connection
        String url = "jdbc:mysql://localhost:3306/testdb"; // update this to your database URL
        String username = "username"; // update this to your username
        String password = "password"; // update this to your password

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            // Step 2: Prepare the statement
            String sql = "SELECT * FROM User WHERE username = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                // Step 3: Set the parameter and execute the statement
                pstmt.setString(1, "user1"); // update this to the username you're looking for
                pstmt.executeUpdate();

                // Step 4: Process the result
                try (ResultSet rs = pstmt.getResultSet()) {
                    while (rs.next()) {
                        System.out.println(rs.getString("password"));
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error in connecting to database: " + e.getMessage());
        }
    }
}