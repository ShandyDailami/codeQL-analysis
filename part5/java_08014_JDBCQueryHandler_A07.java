import java.sql.*;
import java.util.Properties;

public class java_08014_JDBCQueryHandler_A07 {
    private static Connection connection;

    public static void main(String[] args) {
        try {
            establishConnection();
            executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void establishConnection() throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", "username");
        props.setProperty("password", "password");
        props.setProperty("useSSL", "false");
        props.setProperty("serverTimezone", "UTC");
        props.setProperty("characterEncoding", "utf8");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/database", props);
    }

    private static void executeQuery() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE username = '" + "username" + "' AND password = '" + "password" + "'");
        while (resultSet.next()) {
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
        }
        resultSet.close();
        statement.close();
    }
}