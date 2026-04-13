import java.sql.*;

public class java_26571_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "username";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            if (connection != null) {
                executeQuery(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    private static void executeQuery(Connection connection) throws SQLException {
        String query = "SELECT * FROM Users WHERE role = 'admin'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String role = resultSet.getString("role");
            System.out.println("Name: " + name + ", Role: " + role);
        }

        statement.close();
        connection.close();
    }
}