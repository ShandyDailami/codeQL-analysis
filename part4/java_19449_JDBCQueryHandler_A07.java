import java.sql.*;

public class java_19449_JDBCQueryHandler_A07 {

    private String url;
    private String username;
    private String password;

    public java_19449_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                // Process the result set
            }
        } catch (SQLException e) {
            // Handle the exception
        }
    }
}