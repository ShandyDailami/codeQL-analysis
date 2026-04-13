import java.sql.*;

public class java_10104_JDBCQueryHandler_A03 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    private Connection connection;
    private Statement statement;

    public java_10104_JDBCQueryHandler_A03() {
        try {
            connectToDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void connectToDatabase() throws SQLException {
        connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        statement = connection.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return statement.executeQuery(query);
    }

    public int executeUpdate(String query) throws SQLException {
        return statement.executeUpdate(query);
    }

    public void closeConnection() throws SQLException {
        if (statement != null) statement.close();
        if (connection != null) connection.close();
    }

    public static void main(String[] args) {
        JDBCQueryHandler queryHandler = new JDBCQueryHandler();

        // Execute a simple query
        try (ResultSet resultSet = queryHandler.executeQuery("SELECT * FROM Users")) {
            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Execute a simple update
        try {
            int rowsUpdated = queryHandler.executeUpdate("UPDATE Users SET password='new_password' WHERE username='test'");
            System.out.println("Rows updated: " + rowsUpdated);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Close the connection
        try {
            queryHandler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}