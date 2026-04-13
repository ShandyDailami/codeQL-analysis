import java.sql.*;

public class java_00775_JDBCQueryHandler_A01 {
    private Connection conn;
    private Statement stmt;

    public java_00775_JDBCQueryHandler_A01(String dbURL, String user, String password) throws SQLException {
        conn = DriverManager.getConnection(dbURL, user, password);
        stmt = conn.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return stmt.executeQuery(query);
    }

    public void close() throws SQLException {
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();
    }

    public static void main(String[] args) {
        try {
            // replace with your actual database URL, username and password
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
            ResultSet rs = handler.executeQuery("SELECT * FROM mytable");
            while (rs.next()) {
                System.out.println(rs.getString("mycolumn"));
            }
            handler.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}