import java.sql.*;

public class java_30968_JDBCQueryHandler_A07 {

    // Database credentials
    private static final String DB_USERNAME = "username";
    private static final String DB_PASSWORD = "password";

    // Database URL
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";

    // Database driver
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";

    private Connection connection;

    public java_30968_JDBCQueryHandler_A07() {
        establishConnection();
    }

    // Establish a connection to the database
    private void establishConnection() {
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Execute a query
    public void executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                // Process the result here
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Execute a non-query
    public void executeNonQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Close the connection
    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}