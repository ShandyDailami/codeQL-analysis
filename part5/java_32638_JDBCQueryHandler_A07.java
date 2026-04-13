import java.sql.*;
import java.util.Properties;

public class java_32638_JDBCQueryHandler_A07 {
    private Connection connection;
    private Statement statement;

    public java_32638_JDBCQueryHandler_A07(String dbUrl, String userName, String password) {
        try {
            Properties properties = new Properties();
            properties.setProperty("user", userName);
            properties.setProperty("password", password);
            properties.setProperty("autoReconnect", "true");
            properties.setProperty("characterEncoding", "utf8");

            connection = DriverManager.getConnection(dbUrl, properties);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int executeUpdate(String query) {
        try {
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void close() {
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "username", "password");
        ResultSet result = handler.executeQuery("SELECT * FROM users");
        while (result.next()) {
            System.out.println(result.getString("username"));
        }
        handler.close();
    }
}