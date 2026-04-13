import java.sql.*;

public class java_33749_JDBCQueryHandler_A07 {

    public Connection getConnection() throws SQLException {
        // Assuming you have a database with user information
        String url = "jdbc:your_database_url";
        String username = "your_username";
        String password = "your_password";
        return DriverManager.getConnection(url, username, password);
    }

    public ResultSet executeQuery(Connection connection, String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        Connection connection = null;
        ResultSet resultSet = null;

        try {
            connection = handler.getConnection();
            resultSet = handler.executeQuery(connection, "SELECT * FROM users WHERE username='your_username' AND password='your_password'");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
                System.out.println(resultSet.getString("password"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            handler.closeConnection(connection);
        }
    }
}