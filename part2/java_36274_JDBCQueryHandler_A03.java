import java.sql.*;

public class java_36274_JDBCQueryHandler_A03 {
    private Connection connection;

    public java_36274_JDBCQueryHandler_A03(String url, String username, String password) throws SQLException {
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
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public static void main(String[] args) {
        try {
            new VanillaJDBCQueryHandler("jdbc:mysql://localhost:3306/test", "username", "password")
                    .executeQuery("SELECT * FROM users");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}