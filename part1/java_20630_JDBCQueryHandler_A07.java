import java.sql.*;

public class java_20630_JDBCQueryHandler_A07 {

    private String url;
    private String username;
    private String password;

    public java_20630_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        VanillaJavaJDBCQueryHandler handler = new VanillaJavaJDBCQueryHandler("jdbc:mysql://localhost:3306/test", "username", "password");
        handler.executeQuery("SELECT name FROM users WHERE username='admin' AND password='password'");
    }
}