import java.sql.*;

public class java_27507_JDBCQueryHandler_A03 {
    private String url;
    private String user;
    private String password;

    public java_27507_JDBCQueryHandler_A03(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public void executeQuery(String query) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}