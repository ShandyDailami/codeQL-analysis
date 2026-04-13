import java.sql.*;

public class java_05053_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();

            // Query 1
            String query1 = "SELECT * FROM users WHERE email = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query1);
            preparedStmt.setString(1, "test@example.com");
            ResultSet rs = preparedStmt.executeQuery();

            while (rs.next()) {
                String email = rs.getString("email");
                String password = rs.getString("password");
                System.out.println("Email: " + email);
                System.out.println("Password: " + password);
            }

            // Query 2
            String query2 = "INSERT INTO users (email, password) VALUES (?, ?)";
            PreparedStatement preparedStmt2 = conn.prepareStatement(query2);
            preparedStmt2.setString(1, "newuser@example.com");
            preparedStmt2.setString(2, "newpassword");
            preparedStmt2.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}