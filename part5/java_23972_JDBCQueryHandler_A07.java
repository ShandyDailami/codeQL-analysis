import java.sql.*;
import java.util.Properties;

public class java_23972_JDBCQueryHandler_A07 {

    public Connection getConnection(String dbUrl, String userName, String password) throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", userName);
        props.setProperty("password", password);
        props.setProperty("characterSet", "UTF8");
        return DriverManager.getConnection(dbUrl, props);
    }

    public ResultSet executeQuery(Connection conn, String query) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }

    public void closeConnection(Connection conn) throws SQLException {
        conn.close();
    }

    public void handleAuthFailure(String dbUrl, String userName, String password) {
        try {
            Connection conn = getConnection(dbUrl, userName, password);
            ResultSet rs = executeQuery(conn, "SELECT * FROM USERS WHERE USERNAME = '" + userName + "' AND PASSWORD = '" + password + "'");
            if (rs.next()) {
                System.out.println("Authentication Successful");
            } else {
                System.out.println("Authentication Failed");
            }
            closeConnection(conn);
        } catch (SQLException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}