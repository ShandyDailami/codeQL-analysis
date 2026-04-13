import java.sql.*;

public class java_19850_JDBCQueryHandler_A01 {
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "username";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM mytable");

            while (rs.next()) {
                System.out.println(rs.getString("columnname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Always close connections that you're finished with
            if (stmt != null) {
                try { stmt.close(); } catch(SQLException e) {}
            }
            if (conn != null) {
                try { conn.close(); } catch(SQLException e) {}
            }
        }
    }
}