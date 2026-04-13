import java.sql.*;

public class java_17285_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:test.db"; // specify your database file
        String sql = "SELECT * FROM Users";
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(url);
            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            // Extract data from result set
            while (rs.next()) {
                String userId = rs.getString("UserId");
                String userName = rs.getString("UserName");
                System.out.println("UserId: " + userId);
                System.out.println("UserName: " + userName);
            }

            // Close connection and statement
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}