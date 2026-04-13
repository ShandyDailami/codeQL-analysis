import java.sql.*;

public class java_22248_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM my_table WHERE my_column = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Set the parameter value
            pstmt.setString(1, "example_value");

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // Process the result
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}