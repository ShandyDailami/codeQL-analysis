import java.sql.*;

public class java_42057_JDBCQueryHandler_A01 {
    private Connection conn = null;

    public java_42057_JDBCQueryHandler_A01(String url, String user, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Driver class for MySQL
            this.conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet query(String query) {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/db", "username", "password");
        ResultSet rs = handler.query("SELECT * FROM Users"); // Replace with your actual SQL query
        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }
        handler.closeConnection();
    }
}