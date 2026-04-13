import java.sql.*;

public class java_15254_JDBCQueryHandler_A07 {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            executeQuery(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
    }

    private static void executeQuery(Connection connection) throws SQLException {
        String query = "SELECT * FROM Users WHERE auth_failure = true";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");

            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}