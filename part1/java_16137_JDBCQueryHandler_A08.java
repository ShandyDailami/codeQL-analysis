import java.sql.*;

public class java_16137_JDBCQueryHandler_A08 {
    private String url;
    private String username;
    private String password;

    public java_16137_JDBCQueryHandler_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void performQuery(String query) {
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                // Here you can handle the result of the query
                System.out.println("Result: " + rs.getString("column_name"));
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}