import java.sql.*;

public class java_28230_JDBCQueryHandler_A01 {
    // Connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // Security-sensitive operations related to Broken Access Control
    public void executeQuery(String query) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Print the result set
            while (rs.next()) {
                System.out.println(rs.getString("columnName"));
            }

        } catch (SQLException e) {
            // Handle SQLException
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.executeQuery("SELECT * FROM users");
    }
}