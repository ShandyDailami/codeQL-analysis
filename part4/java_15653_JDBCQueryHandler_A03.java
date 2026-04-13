import java.sql.*;

public class java_15653_JDBCQueryHandler_A03 {
    private Connection conn;

    public java_15653_JDBCQueryHandler_A03(String url, String username, String password) throws SQLException {
        conn = DriverManager.getConnection(url, username, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(query);
        return stmt.executeQuery();
    }

    public void closeConnection() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/testdb", "username", "password");
            ResultSet rs = handler.executeQuery("SELECT * FROM users WHERE username = ?");

            while (rs.next()) {
                String username = rs.getString("username");
                System.out.println("Username: " + username);
            }

            handler.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }
}