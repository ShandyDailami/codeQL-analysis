import java.sql.*;

public class java_20721_JDBCQueryHandler_A03 {
    private String url;
    private String username;
    private String password;

    public java_20721_JDBCQueryHandler_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void query(String query) {
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                System.out.println(rs.getString("column_name"));
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Provide the JDBC driver name and database credentials
        JDBCQueryHandler handler = new JDBCQueryHandler("url", "username", "password");
        handler.query("select * from table");
    }
}