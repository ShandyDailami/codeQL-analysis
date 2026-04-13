import java.sql.*;

public class java_08031_JDBCQueryHandler_A08 {

    private String url;
    private String user;
    private String password;

    public java_08031_JDBCQueryHandler_A08(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public void runQuery(String query) {
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println("Failed to execute query: " + e.getMessage());
        }
    }
}