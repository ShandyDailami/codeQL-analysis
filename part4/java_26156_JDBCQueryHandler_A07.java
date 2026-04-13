import java.sql.*;

public class java_26156_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db", "username", "password");
            Statement stmt = conn.createStatement();

            // Attempt to authenticate user
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            ResultSet rs = stmt.executeQuery(sql, "user1", "password1");

            if (rs.next()) {
                System.out.println("User authenticated successfully!");
            } else {
                System.out.println("Authentication failed!");
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found!");
            e.printStackTrace();
        }
    }
}