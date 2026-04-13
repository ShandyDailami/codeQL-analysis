import java.sql.*;

public class java_25319_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "myuser";
        String password = "mypassword";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM mytable WHERE condition = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, "value"); // Replace 'value' with your actual condition

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("column_name")); // Replace 'column_name' with your actual column name
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while connecting to database: " + e.getMessage());
        }
    }
}