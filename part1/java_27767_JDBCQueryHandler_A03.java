import java.sql.*;

public class java_27767_JDBCQueryHandler_A03 {
    private String url;
    private String username;
    private String password;

    public java_27767_JDBCQueryHandler_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public ResultSet executeQuery(String query) {
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, username, password);
            PreparedStatement stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}