import java.sql.*;

public class java_08182_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String username = "your_username";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM your_table"; // Replace with your SQL query
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getString("your_column")); // Replace with your column name
            }
        } catch (SQLException e) {
            System.out.println("Authentication failure. Please check your credentials.");
            e.printStackTrace();
        }
    }
}