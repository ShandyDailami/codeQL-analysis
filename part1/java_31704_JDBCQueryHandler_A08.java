import java.sql.*;

public class java_31704_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String selectQuery = "SELECT * FROM users WHERE role = ?";
            PreparedStatement pstmt = conn.prepareStatement(selectQuery);
            pstmt.setString(1, "admin"); // admin is a role

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String role = rs.getString("role");
                int id = rs.getInt("id");
                String name = rs.getString("name");

                System.out.println("Role: " + role);
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}