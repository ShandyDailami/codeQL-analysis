import java.sql.*;
import java.util.Properties;

public class java_23673_JDBCQueryHandler_A03 {
    private Connection connection;

    public java_23673_JDBCQueryHandler_A03(String dbURL, String userName, String password) {
        Properties props = new Properties();
        props.setProperty("user", userName);
        props.setProperty("password", password);
        props.setProperty("characterEncoding", "utf-8");

        try {
            connection = DriverManager.getConnection(dbURL, props);
        } catch (SQLException e) {
            e.printStackTrace();
            connection = null;
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int executeUpdate(String query) {
        try {
            Statement stmt = connection.createStatement();
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}