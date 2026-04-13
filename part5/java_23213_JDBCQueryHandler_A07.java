import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_23213_JDBCQueryHandler_A07 {
    private Connection connection;

    public java_23213_JDBCQueryHandler_A07(String dbUrl, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(dbUrl, username, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public void close() throws SQLException {
        connection.close();
    }
}

// Usage:

try {
    JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydatabase", "username", "password");

    String query = "SELECT * FROM Users WHERE username = '" + username + "' AND password = '" + password + "'";

    ResultSet resultSet = handler.executeQuery(query);

    while (resultSet.next()) {
        // Handle the result set
    }

    handler.close();
} catch (SQLException e) {
    e.printStackTrace();
}