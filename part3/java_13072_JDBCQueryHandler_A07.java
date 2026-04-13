import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_13072_JDBCQueryHandler_A07 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "myuser";
        String password = "mypassword";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database");

            String sql = "SELECT * FROM users WHERE username = 'myuser' AND password = 'mypassword'";

            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                while (rs.next()) {
                    System.out.println("Found user in the database");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error in connecting to database: " + e.getMessage());
        }
    }
}