import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_05441_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        // Step 1: Load the Driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // This line is for MySQL Database
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        // Step 2: Establish Connection
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {

            // Step 3: Execute Query
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE id = " + 123);

            // Step 4: Process Result
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("Name: " + name + ", Age: " + age);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}