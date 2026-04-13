import java.sql.*;

public class java_16767_JDBCQueryHandler_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "myuser";
    private static final String PASS = "mypassword";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public static void main(String[] args) throws SQLException {
        String query = "SELECT * FROM users WHERE role = 'Admin'";
        JDBCQueryHandler handler = new JDBCQueryHandler();
        ResultSet resultSet = handler.executeQuery(query);

        while (resultSet.next()) {
            String username = resultSet.getString("username");
            String role = resultSet.getString("role");
            System.out.println("Username: " + username + ", Role: " + role);
        }

        resultSet.close();
        connection.close();
    }
}