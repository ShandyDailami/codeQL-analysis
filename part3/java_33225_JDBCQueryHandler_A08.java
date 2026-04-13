import java.sql.*;

public class java_33225_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:test.db"; // SQLite database
        String selectQuery = "SELECT * FROM Users"; // SQL query

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(selectQuery)) {

            // print out each record
            while (rs.next()) {
                System.out.println("ID = " + rs.getString("id"));
                System.out.println("Name = " + rs.getString("name"));
                System.out.println("Email = " + rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}