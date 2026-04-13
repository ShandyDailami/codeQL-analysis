import java.sql.*;

public class java_11217_JDBCQueryHandler_A03 {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            if (connection != null) {
                performSecuritySensitiveOperation(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
    }

    private static void performSecuritySensitiveOperation(Connection connection) throws SQLException {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "testuser");
        preparedStatement.setString(2, "testpassword");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            // Do something with the result set
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}