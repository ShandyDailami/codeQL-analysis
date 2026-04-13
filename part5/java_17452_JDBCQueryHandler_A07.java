import java.sql.*;

public class java_17452_JDBCQueryHandler_A07 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String user = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();

            String sql = "SELECT * FROM my_table"; // replace with your SQL query
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                // process each row of the result set
                System.out.println(rs.getString("column_name"));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error in JDBC operation: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e2) {
                System.out.println("Error closing statement: " + e2.getMessage());
            }

            try {
                if (conn != null) conn.close();
            } catch (SQLException e3) {
                System.out.println("Error closing connection: " + e3.getMessage());
            }
        }
    }
}