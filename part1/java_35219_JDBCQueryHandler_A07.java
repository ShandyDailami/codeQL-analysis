import java.sql.*;

public class java_35219_JDBCQueryHandler_A07 {

    private Connection connection;

    public java_35219_JDBCQueryHandler_A07(String url, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public void executeUpdate(String query) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    public void closeConnection() throws SQLException {
        if (connection != null && connection.isClosed()) {
            connection.close();
        }
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost/db", "username", "password");

            ResultSet resultSet = handler.executeQuery("SELECT * FROM Users");

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username + ", Password: " + password);
            }

            handler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}