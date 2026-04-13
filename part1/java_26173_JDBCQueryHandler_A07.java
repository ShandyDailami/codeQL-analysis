import java.sql.*;

public class java_26173_JDBCQueryHandler_A07 {
    private Connection conn;

    public java_26173_JDBCQueryHandler_A07(String url, String username, String password) {
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler jdbcHandler = new JDBCQueryHandler("jdbcUrl", "username", "password");
        ResultSet rs = jdbcHandler.executeQuery("SELECT * FROM Users");

        try {
            while (rs.next()) {
                System.out.println("User: " + rs.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        jdbcHandler.closeConnection();
    }
}