import java.sql.*;
import java.util.Properties;

public class java_40067_JDBCQueryHandler_A08 {
    private Connection conn;

    public java_40067_JDBCQueryHandler_A08(String dbURL, String user, String password) {
        try {
            Properties props = new Properties();
            props.setProperty("user", user);
            props.setProperty("password", password);
            props.setProperty("autoReconnect", "true");
            props.setProperty("useSSL", "false");
            props.setProperty("databaseName", "master");

            this.conn = DriverManager.getConnection(dbURL, props);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void executeUpdate(String query) {
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:oracle:thin:@localhost:1521:xe", "user", "password");

        // Example query
        ResultSet rs = handler.executeQuery("SELECT * FROM USERS");

        while (rs.next()) {
            System.out.println(rs.getString("username"));
        }

        handler.executeUpdate("INSERT INTO USERS (username, password) VALUES ('newuser', 'newpassword')");
    }
}