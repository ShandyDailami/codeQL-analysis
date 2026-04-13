import java.sql.*;
import java.util.Properties;

public class java_37729_JDBCQueryHandler_A03 {
    private static Connection connection;

    public static Connection openConnection() throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", "username");
        props.setProperty("password", "password");
        props.setProperty("driver", "com.mysql.jdbc.Driver");
        props.setProperty("url", "jdbc:mysql://localhost:3306/testdb");
        connection = DriverManager.getConnection(props);
        return connection;
    }

    public static void closeConnection(Connection connection) throws SQLException {
        if (connection != null && connection.isClosed()) {
            connection.close();
        }
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public int executeUpdate(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeUpdate(query);
    }
}