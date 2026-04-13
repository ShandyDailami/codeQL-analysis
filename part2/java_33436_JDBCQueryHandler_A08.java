import java.sql.*;

public class java_33436_JDBCQueryHandler_A08 {

    // Establish a connection to the database
    public Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "username";
        String password = "password";

        return DriverManager.getConnection(url, username, password);
    }

    // Execute a query and print the result
    public void processQuery(Connection connection) throws SQLException {
        String query = "SELECT * FROM users";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            System.out.println(resultSet.getString("username"));
        }

        // Close the statement and connection
        statement.close();
        connection.close();
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();

        try {
            Connection connection = handler.getConnection();
            handler.processQuery(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}