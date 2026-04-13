import java.sql.*;
import java.util.Properties;

public class java_26118_JDBCQueryHandler_A08 {
    private Connection conn;

    public java_26118_JDBCQueryHandler_A08(String dbURL, String userName, String password) {
        Properties props = new Properties();
        props.setProperty("user", userName);
        props.setProperty("password", password);
        try {
            this.conn = DriverManager.getConnection(dbURL, props);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = this.conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public int executeUpdate(String query) {
        Statement stmt = null;
        int result = 0;
        try {
            stmt = this.conn.createStatement();
            result = stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void closeConnection() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        VanillaJDBCQueryHandler jdbcHandler = new VanillaJDBCQueryHandler("jdbc:mysql://localhost:3306/test", "username", "password");
        ResultSet rs = jdbcHandler.executeQuery("SELECT * FROM Users");
        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }
        jdbcHandler.closeConnection();
    }
}