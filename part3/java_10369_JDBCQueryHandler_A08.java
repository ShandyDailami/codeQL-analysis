import java.sql.*;

public class java_10369_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/db";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    private Connection connection;

    public java_10369_JDBCQueryHandler_A08() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int executeUpdate(String query) {
        try {
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(query);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}