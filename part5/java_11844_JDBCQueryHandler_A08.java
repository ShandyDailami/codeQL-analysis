import java.sql.*;

public class java_11844_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myuser";
        String password = "mypassword";

        try (Connection con = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM mytable WHERE mycondition";
            try (Statement stmt = con.createStatement()) {
                try (ResultSet rs = stmt.executeQuery(sql)) {
                    while (rs.next()) {
                        // process each row of the result set
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error in handling database operations: " + e.getMessage());
        }
    }
}