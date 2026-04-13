import java.sql.*;

public class java_30653_JDBCQueryHandler_A03 {

    // Database credentials
    private static final String DB_USERNAME = "username";
    private static final String DB_PASSWORD = "password";

    // Database URL
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";

    // Creating connection
    public Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Executing SQL Query
    public void executeQuery(String query) {
        Connection connection = createConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                // TODO: Handle result set data
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Execute non-query such as INSERT, UPDATE, DELETE
    public void executeNonQuery(String query) {
        Connection connection = createConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}