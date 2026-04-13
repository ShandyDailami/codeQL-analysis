import java.sql.*;

public class java_29415_JDBCQueryHandler_A03 {
    private String url;
    private String username;
    private String password;

    public java_29415_JDBCQueryHandler_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public void executeUpdate(String query) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "username", "password");

        String query = "SELECT * FROM users";

        try {
            ResultSet resultSet = handler.executeQuery(query);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                // do something with the result
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}