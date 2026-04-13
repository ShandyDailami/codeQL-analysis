import java.sql.*;

public class java_25814_JDBCQueryHandler_A01 {
    private Connection connection;
    private Statement statement;

    public java_25814_JDBCQueryHandler_A01(String url, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return statement.executeQuery(query);
    }

    public int executeUpdate(String query) throws SQLException {
        return statement.executeUpdate(query);
    }

    public void close() throws SQLException {
        statement.close();
        connection.close();
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:your_database_url", "username", "password");

            // Example of a query
            ResultSet rs = handler.executeQuery("SELECT * FROM your_table");

            while (rs.next()) {
                // Process the result set here
            }

            handler.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}