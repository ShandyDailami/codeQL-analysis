import java.sql.*;

public class java_21452_JDBCQueryHandler_A07 {
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "myuser";
    private static final String password = "mypassword";

    public static void main(String[] args) {
        executeQuery("SELECT * FROM Users WHERE username = '" + args[0] + "'");
    }

    private static void executeQuery(String query) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println("Username: " + rs.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}