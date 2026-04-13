import java.sql.*;

public class java_00866_JDBCQueryHandler_A07 {
    private Connection connection;

    public java_00866_JDBCQueryHandler_A07(String url, String username, String password) throws SQLException {
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

    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/test";
            String username = "root";
            String password = "password";
            new JDBCQueryHandler(url, username, password).executeUpdate("CREATE TABLE users (id INT PRIMARY KEY, username VARCHAR(50), password VARCHAR(50))");
            new JDBCQueryHandler(url, username, password).executeUpdate("INSERT INTO users (id, username, password) VALUES (1, 'test', 'test')");
            ResultSet resultSet = new JDBCQueryHandler(url, username, password).executeQuery("SELECT * FROM users");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String username = resultSet.getString(2);
                String password = resultSet.getString(3);
                System.out.println("ID: " + id + ", Username: " + username + ", Password: " + password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}