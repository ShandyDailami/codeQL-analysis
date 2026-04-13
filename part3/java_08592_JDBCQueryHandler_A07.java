import java.sql.*;

public class java_08592_JDBCQueryHandler_A07 {
    private Connection connection;

    public java_08592_JDBCQueryHandler_A07(String dbUrl, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(dbUrl, user, password);
    }

    public boolean authenticate(String username, String password) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Users WHERE Username = ? AND Password = ?");
        statement.setString(1, username);
        statement.setString(2, password);

        ResultSet result = statement.executeQuery();

        return result.next();
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost/test", "username", "password");
            boolean authenticated = handler.authenticate("user", "password");
            if (authenticated) {
                System.out.println("Authentication successful!");
            } else {
                System.out.println("Authentication failed!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}