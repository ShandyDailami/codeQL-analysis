import java.sql.*;
import java.util.Properties;

public class java_05522_JDBCQueryHandler_A01 {
    private Connection connection;

    public java_05522_JDBCQueryHandler_A01(String dbUrl, String userName, String password) {
        try {
            Properties props = new Properties();
            props.setProperty("user", userName);
            props.setProperty("password", password);
            props.setProperty("characterEncoding", "utf-8");
            props.setProperty("useSSL", "false");
            props.setProperty("verifyServerCertificate", "false");
            props.setProperty("requireSSL", "false");

            connection = DriverManager.getConnection(dbUrl, props);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement stmt = connection.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void executeUpdate(String query) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}