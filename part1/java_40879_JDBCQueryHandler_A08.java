import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_40879_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        // Step 1: Establish a connection to the database
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "username";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            // Step 2: Prepare a statement
            try (Statement stmt = conn.createStatement()) {
                // Step 3: Execute a query
                ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE age < 18");

                // Step 4: Process the results
                while (rs.next()) {
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    System.out.println("Name: " + name + ", Age: " + age);
                }
            }
        } catch (SQLException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}