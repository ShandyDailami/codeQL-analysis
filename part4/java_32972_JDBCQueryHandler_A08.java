import java.sql.*;
import java.util.Properties;

public class java_32972_JDBCQueryHandler_A08 {
    private static Connection connection;
    private static Statement statement;

    static {
        try {
            Properties properties = new Properties();
            properties.setProperty("user", "username");
            properties.setProperty("password", "password");
            properties.setProperty("useSSL", "false");
            properties.setProperty("autoReconnect", "true");
            properties.setProperty("characterEncoding", "utf8");
            properties.setProperty("useJDBCDriver", "true");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbname", properties);
            connection.setAutoCommit(false);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            String query = "SELECT * FROM table_name WHERE condition";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                // Perform security-sensitive operations here
            }

            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}