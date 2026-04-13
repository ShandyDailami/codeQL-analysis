import java.sql.*;

public class java_23450_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb"; // replace with your database URL
        String username = "username"; // replace with your username
        String password = "password"; // replace with your password

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM table_name"; // replace with your SQL query
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("column_name")); // replace with your column name
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}