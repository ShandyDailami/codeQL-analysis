import java.sql.*;

public class java_21153_JDBCQueryHandler_A08 {
    private Connection connection;

    public java_21153_JDBCQueryHandler_A08(String dbURL, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(dbURL, username, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public void executeUpdate(String update) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(update);
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public static void main(String[] args) {
        try {
            new VanillaJDBCQueryHandler("jdbc:your_db_url", "username", "password")
                    .executeQuery("SELECT * FROM your_table");
            System.out.println("Query executed successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to execute query: " + e.getMessage());
        } finally {
            try {
                new VanillaJDBCQueryHandler("jdbc:your_db_url", "username", "password").closeConnection();
            } catch (SQLException e) {
                System.out.println("Failed to close connection: " + e.getMessage());
            }
        }
    }
}