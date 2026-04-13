import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_17953_JDBCQueryHandler_A08 {
    private String url;
    private String username;
    private String password;

    public java_17953_JDBCQueryHandler_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public List<String> executeQuery(String query) {
        List<String> results = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                results.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }
}