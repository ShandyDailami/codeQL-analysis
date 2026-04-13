import java.sql.*;

public class java_05088_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/db";
    private static final String username = "username";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 1. Establish a connection
            conn = DriverManager.getConnection(url, username, password);

            // 2. Create a statement
            stmt = conn.createStatement();

            // 3. Execute a query
            rs = stmt.executeQuery("SELECT * FROM Users WHERE id = " + args[0]);

            // 4. Process the result
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 5. Clean up
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