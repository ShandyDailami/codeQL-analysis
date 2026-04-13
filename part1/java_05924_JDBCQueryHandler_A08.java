import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_05924_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        // MySQL connection string
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myuser";
        String password = "mypassword";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {

            // SQL query
            String sql = "SELECT * FROM mytable";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println("Record " + rs.getInt("id") + ": " + rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}