import java.sql.*;

public class java_01546_JDBCQueryHandler_A01 {
    private Connection connection;

    public java_01546_JDBCQueryHandler_A01(String url, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
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
            VanillaJDBCQueryHandler jdbcHandler = new VanillaJDBCQueryHandler("url", "username", "password");
            ResultSet resultSet = jdbcHandler.executeQuery("SELECT * FROM users WHERE role='ADMIN'");

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String role = resultSet.getString("role");
                System.out.println("Username: " + username + ", Role: " + role);
            }

            jdbcHandler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}