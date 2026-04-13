import java.sql.*;

public class java_29151_JDBCQueryHandler_A07 {
    private Connection conn;
    private Statement stmt;

    public java_29151_JDBCQueryHandler_A07(String dbURL, String user, String password) throws SQLException {
        conn = DriverManager.getConnection(dbURL, user, password);
        stmt = conn.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return stmt.executeQuery(query);
    }

    public void closeConnection() throws SQLException {
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost/test", "username", "password");
            ResultSet rs = handler.executeQuery("SELECT * FROM Users");

            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }

            handler.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}