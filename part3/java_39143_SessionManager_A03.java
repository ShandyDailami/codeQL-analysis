import java.sql.*;
import java.util.*;

public class java_39143_SessionManager_A03 {

    private static HashMap<String, Connection> connections = new HashMap<>();
    private static String url = "jdbc:mysql://localhost:3306/test";
    private static String username = "root";
    private static String password = "password";

    public static Connection getConnection() throws SQLException {
        if (connections.isEmpty()) {
            createConnection();
        }
        return connections.get(0);
    }

    private static void createConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        connections.put(UUID.randomUUID().toString(), connection);
    }

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username + ", Password: " + password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}