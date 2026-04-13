import java.sql.*;
import java.util.Properties;

public class java_22034_JDBCQueryHandler_A07 {
    private Connection conn;
    private Statement stmt;

    public java_22034_JDBCQueryHandler_A07(String dbUrl, String user, String password) {
        try {
            Properties props = new Properties();
            props.setProperty("user", user);
            props.setProperty("password", password);
            props.setProperty("characterEncoding", "utf-8");
            props.setProperty("useSSL", "false");

            conn = DriverManager.getConnection(dbUrl, props);
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

    public int executeUpdate(String query) {
        int count = 0;
        try {
            count = stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public void closeConnection() {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "root", "password");
        ResultSet rs = handler.executeQuery("SELECT * FROM Users");
        try {
            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            handler.closeConnection();
        }
    }
}