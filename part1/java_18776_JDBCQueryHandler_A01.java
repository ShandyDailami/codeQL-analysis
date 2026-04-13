import java.sql.*;
import java.util.Properties;

public class java_18776_JDBCQueryHandler_A01 {

    private Connection connection;
    private Statement statement;

    public java_18776_JDBCQueryHandler_A01(String url, String username, String password) {
        try {
            Properties props = new Properties();
            props.setProperty("user", username);
            props.setProperty("password", password);

            connection = DriverManager.getConnection(url, props);
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

    public void executeUpdate(String query) {
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (statement != null)
                statement.close();
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "username", "password");
        ResultSet result = handler.executeQuery("SELECT * FROM users WHERE role='admin'");

        try {
            while (result.next()) {
                System.out.println("User: " + result.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        handler.closeConnection();
    }
}