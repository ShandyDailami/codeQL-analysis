import java.sql.*;

public class java_19132_JDBCQueryHandler_A07 {
    private String url;
    private String username;
    private String password;

    public java_19132_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }

    public void executeUpdate(String query) throws SQLException {
        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);
   
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "username", "password");

        try {
            ResultSet rs = handler.executeQuery("SELECT * FROM Users");
            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }
}