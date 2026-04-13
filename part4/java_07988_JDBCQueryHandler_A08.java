import java.sql.*;

public class java_07988_JDBCQueryHandler_A08 {
    private String url;
    private String username;
    private String password;

    public java_07988_JDBCQueryHandler_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                // Security-sensitive operations, like logging or displaying the results here.
                System.out.println("Result: " + rs.getString("column_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("url", "username", "password");
        handler.executeQuery("SELECT * FROM table");
    }
}