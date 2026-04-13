import java.sql.*;

public class java_14762_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "username";
        String password = "password";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();

            // This is a dummy query, replace it with your real query
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE username='test' AND password='test'");

            if (rs.next()) {
                System.out.println("User exists");
            } else {
                System.out.println("User does not exist");
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}