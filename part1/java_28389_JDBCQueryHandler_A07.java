import java.sql.*;

public class java_28389_JDBCQueryHandler_A07 {
    private Connection connection;

    public java_28389_JDBCQueryHandler_A07(String url, String username, String password) {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void executeUpdate(String update) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(update);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // You should not expose your database credentials in your code. You should use environment variables or other secure methods to handle them.
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        JDBCQueryHandler handler = new JDBCQueryHandler(url, username, password);

        // This is a basic example of executing a query. In a real-world application, you'd likely want to handle more complex queries and updates.
        ResultSet resultSet = handler.executeQuery("SELECT * FROM users WHERE username = 'test'");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("password"));
        }

        handler.executeUpdate("UPDATE users SET password = 'newPassword' WHERE username = 'test'");
    }
}