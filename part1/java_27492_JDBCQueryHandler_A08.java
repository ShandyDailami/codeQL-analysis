import java.sql.*;

public class java_27492_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "username";
        String password = "password";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();

            // Example of a query that could potentially access data that is not allowed
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE id = '123'");

            while (rs.next()) {
                // Your code here that uses the returned data
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}