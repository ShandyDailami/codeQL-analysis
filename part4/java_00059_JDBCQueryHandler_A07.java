import java.sql.*;

public class java_00059_JDBCQueryHandler_A07 {
    private Connection connection;

    public java_00059_JDBCQueryHandler_A07(String url, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
    }

    public void authenticate(String username, String password) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Users WHERE username = ? AND password = ?");
        statement.setString(1, username);
        statement.setString(2, password);

        ResultSet result = statement.executeQuery();

        if (result.next()) {
            // Authentication successful, proceed with further operations
        } else {
            // Authentication failed, handle the error
            throw new SQLException("Authentication failure");
        }
    }

    public void performQuery(String query) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            // Process the result set
        }
    }

    public void close() throws SQLException {
        connection.close();
    }
}