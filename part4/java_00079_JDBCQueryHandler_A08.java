import java.sql.*;

public class java_00079_JDBCQueryHandler_A08 {
    private String url;
    private String username;
    private String password;

    public java_00079_JDBCQueryHandler_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void runQuery(String query) {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                // Print out each column in the result set
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Replace with your actual database connection info
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:your_db_url", "username", "password");
        handler.runQuery("SELECT * FROM your_table");
    }
}