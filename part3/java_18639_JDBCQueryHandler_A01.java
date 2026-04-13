import java.sql.*;
import java.util.Properties;

public class java_18639_JDBCQueryHandler_A01 {
    private Properties properties;

    public java_18639_JDBCQueryHandler_A01() {
        properties = new Properties();
        try {
            properties.load(getClass().getResourceAsStream("/database.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        String query = "SELECT * FROM users WHERE username = ?";
        try (ResultSet resultSet = handler.executeQuery(query)) {
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                if ("admin".equals(username)) {
                    System.out.println("Access granted");
                } else {
                    System.out.println("Access denied");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}