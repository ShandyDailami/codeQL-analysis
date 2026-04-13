import java.sql.*;

public class java_38160_JDBCQueryHandler_A07 {
    // database credentials
    private static final String DB_USERNAME = "username";
    private static final String DB_PASSWORD = "password";
    // database URL
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";

    private Connection connection;

    public java_38160_JDBCQueryHandler_A07() {
        establishConnection();
    }

    private void establishConnection() {
        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish the connection
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            // Execute the query
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
            // Execute the update
            Statement statement = connection.createStatement();
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void closeConnection() {
        try {
            // Close the connection
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}