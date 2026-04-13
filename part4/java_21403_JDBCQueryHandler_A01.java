import java.sql.*;

public class java_21403_JDBCQueryHandler_A01 {

    private Connection connection;

    public java_21403_JDBCQueryHandler_A01(String dbUrl, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(dbUrl, username, password);
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
        // Use a try-with-resources statement to ensure that the connection is closed even if an exception occurs
        try (JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:your_db_url", "username", "password")) {
            ResultSet resultSet = handler.executeQuery("SELECT * FROM your_table");
            while (resultSet.next()) {
                // Process the result set
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}