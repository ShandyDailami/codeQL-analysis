import java.sql.*;
import java.util.logging.*;

public class java_22282_JDBCQueryHandler_A07 {
    private static final Logger logger = Logger.getLogger(JDBCQueryHandler.class.getName());

    private String url;
    private String username;
    private String password;

    public java_22282_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            logger.severe("Error executing query: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Provide your own URL, username, and password.
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
        handler.executeQuery("SELECT * FROM Users WHERE username = 'test' AND password = 'test'");
    }
}