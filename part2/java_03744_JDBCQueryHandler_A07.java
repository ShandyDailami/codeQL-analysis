import java.sql.*;
import java.util.Properties;

public class java_03744_JDBCQueryHandler_A07 {
    private Connection connection;

    public java_03744_JDBCQueryHandler_A07(String databaseURL, String user, String password) throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", password);
        props.setProperty("ssl","false");
        connection = DriverManager.getConnection(databaseURL, props);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }

    public int executeUpdate(String query) throws SQLException {
        Statement stmt = connection.createStatement();
        return stmt.executeUpdate(query);
    }

    public void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) {
        try {
            new JDBCQueryHandler("jdbc:mysql://localhost/test", "username", "password")
                    .executeQuery("SELECT * FROM Users");
            System.out.println("Successfully connected!");
        } catch (SQLException e) {
            System.out.println("Failed to connect: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                new JDBCQueryHandler("jdbc:mysql://localhost/test", "username", "password").closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}