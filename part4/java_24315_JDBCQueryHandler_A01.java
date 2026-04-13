import java.sql.*;

public class java_24315_JDBCQueryHandler_A01 {
    private Connection conn;
    private Statement stmt;

    public java_24315_JDBCQueryHandler_A01(String dbUrl, String user, String password) {
        try {
            conn = DriverManager.getConnection(dbUrl, user, password);
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
        // Provide your database URL, username, and password
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/testdb", "username", "password");
        handler.executeQuery("SELECT * FROM users");
    }
}