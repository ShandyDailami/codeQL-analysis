import java.sql.*;

public class java_20034_JDBCQueryHandler_A03 {
    // private static fields
    private static String url;
    private static String username;
    private static String password;
    private static Connection connection;

    // constructor to initialize fields
    public java_20034_JDBCQueryHandler_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    // method to open a connection to the database
    public Connection openConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }

    // method to close the connection to the database
    public void closeConnection(Connection connection) throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    // method to perform a query using prepared statements
    public ResultSet performQuery(String query, Object[] parameters) throws SQLException {
        Connection connection = openConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        for (int i = 0; i < parameters.length; i++) {
            statement.setObject(i + 1, parameters[i]);
        }
        ResultSet resultSet = statement.executeQuery();
        closeConnection(connection);
        return resultSet;
    }

    // main method
    public static void main(String[] args) {
        // Initialize the connection
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:your_database_url", "username", "password");

        // Perform a query with parameters
        String query = "SELECT * FROM users WHERE id = ?";
        Object[] parameters = {123};
        try (ResultSet resultSet = handler.performQuery(query, parameters)) {
            while (resultSet.next()) {
                // Process the result set here
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}