import java.sql.*;

public class java_25751_JDBCQueryHandler_A08 {

    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            if (connection != null) {
                performSecuritySensitiveOperations(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private static void performSecuritySensitiveOperations(Connection connection) throws SQLException {
        String query = "SELECT * FROM users WHERE role='admin'";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");

            // Do some security-sensitive operation with the username and password here...

        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}