import java.sql.*;

public class java_24908_JDBCQueryHandler_A08 {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public java_24908_JDBCQueryHandler_A08(String url, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        resultSet = statement.executeQuery(query);
        return resultSet;
    }

    public void executeUpdate(String query) throws SQLException {
        statement.executeUpdate(query);
    }

    public void close() throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}

// usage
String url = "jdbc:mysql://localhost:3306/test";
String username = "root";
String password = "password";

try {
    JDBCQueryHandler handler = new JDBCQueryHandler(url, username, password);
    ResultSet resultSet = handler.executeQuery("SELECT * FROM users WHERE role='ADMIN'");
    
    while (resultSet.next()) {
        String name = resultSet.getString("name");
        String email = resultSet.getString("email");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }
    
    handler.close();
} catch (SQLException e) {
    System.out.println("Error: " + e.getMessage());
}