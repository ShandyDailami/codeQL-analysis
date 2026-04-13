import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_40184_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mock:books"; // This is a fake URL for the books database
        String username = "username";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {

            String sql = "SELECT * FROM books";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println("Book ID: " + rs.getInt("book_id"));
                System.out.println("Book Title: " + rs.getString("book_title"));
                System.out.println("Book Author: " + rs.getString("book_author"));
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        }
    }
}