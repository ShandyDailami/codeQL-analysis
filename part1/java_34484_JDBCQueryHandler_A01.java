import java.sql.*;

public class java_34484_JDBCQueryHandler_A01 {
    private Connection connection;

    public java_34484_JDBCQueryHandler_A01(String url, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    // Example usage
    public static void main(String[] args) {
        String url = "jdbc:your_database_url";
        String username = "your_username";
        String password = "your_password";

        try {
            JDBCQueryHandler handler = new JDBCQueryHandler(url, username, password);
            ResultSet resultSet = handler.executeQuery("SELECT * FROM your_table");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("column_name"));
            }

            handler.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }
}