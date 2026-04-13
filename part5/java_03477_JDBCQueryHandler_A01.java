import java.sql.*;

public class java_03477_JDBCQueryHandler_A01 {
    private String url;
    private String username;
    private String password;

    public java_03477_JDBCQueryHandler_A01(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void runQuery(String query) {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Example of how to create a new JDBCQueryHandler instance
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydatabase", "username", "password");

        // Example of how to run a query
        handler.runQuery("SELECT * FROM mytable");
    }
}