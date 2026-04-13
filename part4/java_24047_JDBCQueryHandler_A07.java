import java.sql.*;

public class java_24047_JDBCQueryHandler_A07 {
    private Connection conn;
    private Statement stmt;

    public java_24047_JDBCQueryHandler_A07() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "username", "password");
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.executeQuery("SELECT * FROM users WHERE role = 'admin'");
    }
}