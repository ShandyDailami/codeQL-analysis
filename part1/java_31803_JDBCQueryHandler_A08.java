import java.sql.*;

public class java_31803_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String username = "root";
    private static final String password = "password";
    private static Connection connection;

    public static void main(String[] args) {
        connectToDatabase();
        executeQuery("SELECT * FROM Users WHERE id = '" + args[0] + "'");
        closeConnection();
    }

    private static void connectToDatabase() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database successfully");
        } catch (SQLException e) {
            System.out.println("Failed to connect to database");
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println("User found with ID: " + resultSet.getString("id"));
            }
        } catch (SQLException e) {
            System.out.println("Failed to execute query");
            e.printStackTrace();
        }
    }

    private static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed successfully");
            }
        } catch (SQLException e) {
            System.out.println("Failed to close connection");
            e.printStackTrace();
        }
    }
}