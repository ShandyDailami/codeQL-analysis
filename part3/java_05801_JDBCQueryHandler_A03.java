import java.sql.*;

public class java_05801_JDBCQueryHandler_A03 {
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    private final String url = "jdbc:mysql://localhost:3306/test";
    private final String user = "root";
    private final String password = "password";

    public java_05801_JDBCQueryHandler_A03() {
        try {
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.executeQuery("SELECT * FROM users WHERE id = 1");
    }
}