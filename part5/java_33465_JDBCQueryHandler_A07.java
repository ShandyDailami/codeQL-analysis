import java.sql.*;

public class java_33465_JDBCQueryHandler_A07 {
    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String username = "root";
    private static final String password = "password";
    private static Connection connection;

    public static void main(String[] args) {
        establishConnection();
        executeQuery();
        closeConnection();
    }

    private static void establishConnection() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established successfully!");
        } catch (SQLException e) {
            System.out.println("Error while connecting to the database: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void executeQuery() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users");
            while (resultSet.next()) {
                System.out.println("User ID: " + resultSet.getString("id"));
                System.out.println("User Name: " + resultSet.getString("name"));
                System.out.println("User Password: " + resultSet.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println("Error while executing query: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error while closing the connection: " + e.getMessage());
            e.printStackTrace();
        }
    }
}