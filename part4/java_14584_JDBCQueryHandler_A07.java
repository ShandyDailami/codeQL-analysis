import java.sql.*;

public class java_14584_JDBCQueryHandler_A07 {
    private Connection conn;

    public java_14584_JDBCQueryHandler_A07(String url, String username, String password) throws SQLException {
        conn = DriverManager.getConnection(url, username, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }

    public void close() throws SQLException {
        conn.close();
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/db", "username", "password");
            ResultSet rs = handler.executeQuery("SELECT * FROM table");
            while (rs.next()) {
                System.out.println(rs.getString("column"));
            }
            handler.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}