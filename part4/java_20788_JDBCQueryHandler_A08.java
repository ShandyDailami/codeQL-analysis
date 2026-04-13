import java.sql.*;

public class java_20788_JDBCQueryHandler_A08 {

    // Define the database url, username and password
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "username";
    private static final String PASS = "password";

    // Define the SQL query
    private static final String SELECT_USER_SQL = "SELECT * FROM users WHERE username = ?";
    private static final String UPDATE_USER_SQL = "UPDATE users SET password = ? WHERE username = ?";
    private static final String DELETE_USER_SQL = "DELETE FROM users WHERE username = ?";

    // Create a connection
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    // Query for a user by username
    public ResultSet selectUser(String username) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_SQL);
        preparedStatement.setString(1, username);
        return preparedStatement.executeQuery();
    }

    // Update the password of a user
    public int updateUserPassword(String username, String newPassword) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_SQL);
        preparedStatement.setString(1, newPassword);
        preparedStatement.setString(2, username);
        return preparedStatement.executeUpdate();
    }

    // Delete a user
    public int deleteUser(String username) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_SQL);
        preparedStatement.setString(1, username);
        return preparedStatement.executeUpdate();
    }

    // Close the connection
    public void closeConnection(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}