import java.sql.*;

public class java_02332_JDBCQueryHandler_A07 {
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    private Connection connection;

    public java_02332_JDBCQueryHandler_A07() {
        try {
            Class.forName(DB_DRIVER);
            this.connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean authenticate(String username, String password) {
        String sql = "SELECT * FROM Users WHERE username = ?";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql, username);
            if (rs.next()) {
                return rs.getString("password").equals(password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        boolean isAuthenticated = handler.authenticate("username", "password");
        System.out.println("Is Authenticated? " + isAuthenticated);
    }
}