import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_09663_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL JDBC driver
            String url = "jdbc:mysql://localhost:3306/mydb"; // database URL
            String username = "username"; // username
            String password = "password"; // password

            Connection conn = DriverManager.getConnection(url, username, password);

            System.out.println("Connected to database!");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE id = '1'"); // Query

            while (rs.next()) {
                System.out.println("User found: " + rs.getString("username"));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error connecting to database or executing query: " + e.getMessage());
        }
    }
}