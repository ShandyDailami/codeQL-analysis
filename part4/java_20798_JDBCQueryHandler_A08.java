import java.sql.*;
import java.util.logging.*;

public class java_20798_JDBCQueryHandler_A08 {

    private static final Logger LOGGER = Logger.getLogger(JDBCQueryHandler.class.getName());

    private String url;
    private String username;
    private String password;

    public java_20798_JDBCQueryHandler_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                LOGGER.info(resultSet.getString("field_name"));
            }
        } catch (SQLException e) {
            LOGGER.warning("Error executing query: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/db_name", "username", "password");
        handler.executeQuery("SELECT * FROM table_name");
    }
}