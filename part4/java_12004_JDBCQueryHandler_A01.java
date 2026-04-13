import java.sql.*;

public class java_12004_JDBCQueryHandler_A01 {
    private Connection conn;

    public java_12004_JDBCQueryHandler_A01(String url, String username, String password) throws SQLException {
        this.conn = DriverManager.getConnection(url, username, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(query);
        return stmt.executeQuery();
    }

    public void executeUpdate(String query) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.executeUpdate();
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        try {
            JDBCQueryHandler handler = new JDBCQueryHandler(url, username, password);
            ResultSet rs = handler.executeQuery("SELECT * FROM users WHERE username = ?");

            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Username: " + username + ", Password: " + password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}