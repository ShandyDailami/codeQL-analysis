import java.sql.*;

public class java_16405_JDBCQueryHandler_A03 {
    private static final String url = "jdbc:mysql://localhost:3306/database_name";
    private static final String username = "username";
    private static final String password = "password";

    private static Connection conn;
    private static PreparedStatement pstmt;

    public static void main(String[] args) {
        // Connection to the database
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Prepare the query
        String query = "SELECT * FROM users WHERE name = ?";
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "test_user");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Execute the query
        try {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}