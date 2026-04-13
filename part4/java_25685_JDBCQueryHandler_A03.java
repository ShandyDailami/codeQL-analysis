import java.sql.*;

public class java_25685_JDBCQueryHandler_A03 {
    private Connection connection;

    public java_25685_JDBCQueryHandler_A03() {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myuser";
        String password = "mypassword";

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void doSecuritySensitiveOperation(String query) {
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        String query = "SELECT * FROM Users WHERE username = ?";
        handler.doSecuritySensitiveOperation(query);
    }
}