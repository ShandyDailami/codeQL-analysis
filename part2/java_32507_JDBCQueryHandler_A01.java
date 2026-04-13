import java.sql.*;
import java.util.Properties;

public class java_32507_JDBCQueryHandler_A01 {
    private static Connection connection = null;
    private static Statement statement = null;

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "root";

        try {
            connectDB(url, username, password);
            executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnectDB();
        }
    }

    private static void connectDB(String url, String username, String password) throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", username);
        props.setProperty("password", password);
        props.setProperty("characterEncoding", "utf-8");
        Connection conn = DriverManager.getConnection(url, props);
        connection = conn;
        statement = conn.createStatement();
    }

    private static void executeQuery() throws SQLException {
        String sql = "SELECT * FROM users";
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
        }
    }

    private static void disconnectDB() {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}