import java.sql.*;

public class java_30393_JDBCQueryHandler_A03 {
    private Connection conn = null;
    private Statement stmt = null;
    
    public void connect(String url, String username, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // assuming mysql driver
            this.conn = DriverManager.getConnection(url, username, password);
            this.stmt = this.conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("username"));
                System.out.println(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.connect("jdbc:mysql://localhost/testdb", "username", "password");
        handler.executeQuery("SELECT username, password FROM Users WHERE username = 'test'");
    }
}