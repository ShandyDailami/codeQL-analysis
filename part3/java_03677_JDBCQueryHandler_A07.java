import java.sql.*;

public class java_03677_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myuser";
        String password = "mypassword";

        try (Connection con = DriverManager.getConnection(url, username, password);
             Statement stmt = con.createStatement()) {

            // create a new user
            String sql = "INSERT INTO Users (username, password) VALUES (?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "newuser");
            pstmt.setString(2, "newpassword");
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getResultSet();
            while (rs.next()) {
                System.out.println(rs.getString("username") + " " + rs.getString("password"));
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}