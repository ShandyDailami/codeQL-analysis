import java.sql.*;
import java.util.logging.*;

public class java_28991_JDBCQueryHandler_A07 {

    private static final Logger LOGGER = Logger.getLogger(JDBCQueryHandler.class.getName());

    private String url;
    private String username;
    private String password;

    public java_28991_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                // Process the result set data
                System.out.println(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            LOGGER.severe("Failed to execute query: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Replace with your actual URL, username, and password
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myuser";
        String password = "mypassword";

        JDBCQueryHandler queryHandler = new JDBCQueryHandler(url, username, password);
        queryHandler.executeQuery("SELECT * FROM Users WHERE username = ?");
    }
}