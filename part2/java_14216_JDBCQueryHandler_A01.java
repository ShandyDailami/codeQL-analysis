import java.sql.*;

public class java_14216_JDBCQueryHandler_A01 {
    private String url;
    private String username;
    private String password;

    public java_14216_JDBCQueryHandler_A01(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public String executeQuery(String query) {
        String result = "";
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                result += rs.getString(1) + " ";
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}