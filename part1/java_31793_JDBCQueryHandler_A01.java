import java.sql.*;
import java.util.Properties;

public class java_31793_JDBCQueryHandler_A01 {
    private Connection conn;

    public java_31793_JDBCQueryHandler_A01(String dbURL, String user, String password) {
        try {
            Properties props = new Properties();
            props.setProperty("user", user);
            props.setProperty("password", password);
            props.setProperty("driver", "com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(dbURL, props);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int executeUpdate(String query) {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler jdbc = new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "username", "password");
        ResultSet rs = jdbc.executeQuery("SELECT * FROM Users");
        while (rs.next()) {
            System.out.println(rs.getString("username"));
        }
        jdbc.closeConnection();
    }
}