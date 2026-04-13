import java.sql.*;

public class java_02473_JDBCQueryHandler_A08 {

    // Connection instance
    private Connection connection;

    // SQL Query
    private String query;

    // Constructor
    public java_02473_JDBCQueryHandler_A08(String url, String username, String password, String query) throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
        this.query = query;
    }

    // Execute query method
    public ResultSet executeQuery() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        return resultSet;
    }

    // Execute update method
    public int executeUpdate() throws SQLException {
        Statement statement = connection.createStatement();
        int rowsUpdated = statement.executeUpdate(query);
        return rowsUpdated;
    }

    // Close connection
    public void closeConnection() throws SQLException {
        connection.close();
    }

    // Main method to test the code
    public static void main(String[] args) {
        try {
            // Assuming database url, username and password are provided.
            JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler("url", "username", "password", "SELECT * FROM table");
            ResultSet resultSet = jdbcQueryHandler.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("column_name"));
            }

            jdbcQueryHandler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}