import java.sql.*;

public class java_05635_JDBCQueryHandler_A07 {
    private Connection connection;

    public java_05635_JDBCQueryHandler_A07(String dbURL, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(dbURL, username, password);
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
        connection.close();
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "username", "password");
            ResultSet resultSet = handler.executeQuery("SELECT * FROM users WHERE username = 'test' AND password = 'test'");

            while (resultSet.next()) {
                System.out.println("Username: " + resultSet.getString("username"));
            }

            handler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}