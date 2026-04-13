import java.sql.*;
import java.util.Properties;

public class java_24915_JDBCQueryHandler_A01 {
    private Connection conn;
    private Statement stmt;

    public void connect(String url, String user, String password) {
        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", password);
        try {
            conn = DriverManager.getConnection(url, props);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void executeUpdate(String query) {
        try {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        VanillaJDBCQueryHandler handler = new VanillaJDBCQueryHandler();
        handler.connect("jdbc:mysql://localhost/test", "username", "password");

        ResultSet rs = handler.executeQuery("SELECT * FROM users");
        while (rs.next()) {
            System.out.println(rs.getString("username"));
        }

        handler.close();
    }
}