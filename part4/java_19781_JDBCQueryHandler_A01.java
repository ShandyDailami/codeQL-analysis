import java.sql.*;

public class java_19781_JDBCQueryHandler_A01 {
    private static String url = "jdbc:mysql://localhost:3306/test";
    private static String username = "username";
    private static String password = "password";

    public static void main(String[] args) {
        try {
            connectDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void connectDatabase() throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        String query = "SELECT * FROM users WHERE role = 'admin'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String role = resultSet.getString("role");
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
            System.out.println("Role: " + role);
        }

        statement.close();
        connection.close();
    }
}