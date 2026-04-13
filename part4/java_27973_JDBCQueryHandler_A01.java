import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_27973_JDBCQueryHandler_A01 {

    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private static Connection connection;

    public static void main(String[] args) {
        try {
            connect();
            executeQuery();
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void connect() throws SQLException {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private static void executeQuery() throws SQLException {
        String sql = "SELECT * FROM Users";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");

            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
        }
    }

    private static void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}