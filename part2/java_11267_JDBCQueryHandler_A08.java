import java.sql.*;

public class java_11267_JDBCQueryHandler_A08 {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "password";

    // Open a connection
    public Connection openConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    // Close a connection
    public void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Execute a query without parameterization
    public ResultSet executeQuery(Connection connection, String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    // Execute a query with parameterization
    public ResultSet executeQueryWithParameter(Connection connection, String query, String parameter) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, parameter);
        return statement.executeQuery();
    }

    // Main function
    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        Connection connection = null;
        try {
            connection = handler.openConnection();
            ResultSet resultSet = handler.executeQueryWithParameter(connection, "SELECT * FROM users WHERE username = ?", "test");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            handler.closeConnection(connection);
        }
    }
}