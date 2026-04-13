import java.sql.*;

public class java_22275_JDBCQueryHandler_A03 {
    private Connection connection;

    public java_22275_JDBCQueryHandler_A03(String url, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        return statement.executeQuery();
    }

    public void executeUpdate(String query) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        statement.executeUpdate();
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}

// Example usage:

String url = "jdbc:mysql://localhost:3306/mydatabase";
String username = "myuser";
String password = "mypassword";

try {
    JDBCQueryHandler handler = new JDBCQueryHandler(url, username, password);

    ResultSet resultSet = handler.executeQuery("SELECT * FROM mytable");

    while (resultSet.next()) {
        System.out.println(resultSet.getString("mycolumn"));
    }

    handler.closeConnection();
} catch (SQLException e) {
    System.out.println("An error occurred while connecting to the database: " + e.getMessage());
}