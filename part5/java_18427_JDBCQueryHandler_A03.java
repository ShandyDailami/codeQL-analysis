import java.sql.*;

public class java_18427_JDBCQueryHandler_A03 {

    private String url;
    private String username;
    private String password;

    public java_18427_JDBCQueryHandler_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public String executeQuery(String query) {
        String result = null;
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                result = rs.getString(1); // assuming we're just trying to get a single string result
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}