import java.sql.*;

public class java_27630_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String username = "username";
    private static final String password = "password";

    public static void main(String[] args) {
        String usernameToCheck = "testuser";
        try {
            checkUsernameExists(usernameToCheck);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void checkUsernameExists(String username) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            String query = "SELECT * FROM Users WHERE username = ?";
            resultSet = statement.executeQuery(query, username);

            if (resultSet.next()) {
                System.out.println("Username exists");
            } else {
                System.out.println("Username does not exist");
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}