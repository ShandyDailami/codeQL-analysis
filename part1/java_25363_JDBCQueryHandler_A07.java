import java.sql.*;

public class java_25363_JDBCQueryHandler_A07 {
    private Connection connection;

    public java_25363_JDBCQueryHandler_A07() {
        // Establish the database connection
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb", "username", "password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean authenticateUser(String username, String password) {
        String query = "SELECT * FROM users WHERE username = ?";

        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                String dbPassword = rs.getString("password");
                return password.equals(dbPassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}