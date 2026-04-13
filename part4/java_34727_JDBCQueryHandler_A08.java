import java.sql.*;

public class java_34727_JDBCQueryHandler_A08 {
    private Connection connection;

    public java_34727_JDBCQueryHandler_A08(String dbUrl, String userName, String password) throws SQLException {
        connection = DriverManager.getConnection(dbUrl, userName, password);
    }

    public ResultSet executeQuery(String sqlQuery) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(sqlQuery);
    }

    public void executeUpdate(String sqlQuery) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(sqlQuery);
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public static void main(String[] args) {
        try {
            // Assume we have a database with the following schema:
            // CREATE DATABASE test;
            // USE test;
            // CREATE TABLE users (id INT PRIMARY KEY, name VARCHAR(100), email VARCHAR(100));
            String dbUrl = "jdbc:mysql://localhost:3306/test";
            String userName = "root";
            String password = "password";

            JDBCQueryHandler handler = new JDBCQueryHandler(dbUrl, userName, password);

            String sqlQuery = "INSERT INTO users (id, name, email) VALUES (1, 'Test User', 'test.user@example.com')";
            handler.executeUpdate(sqlQuery);

            sqlQuery = "SELECT * FROM users";
            ResultSet resultSet = handler.executeQuery(sqlQuery);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }

            handler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}