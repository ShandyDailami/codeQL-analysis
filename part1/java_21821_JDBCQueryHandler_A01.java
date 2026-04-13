import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_21821_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        // Step 1: Load the database driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Java Connector failed to load its driver");
            e.printStackTrace();
            return;
        }

        // Step 2: Establish a connection
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "username", "password")) {

            // Step 3: Execute a query
            try (Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery("SELECT * FROM Employee");

                // Step 4: Process the result set
                while (rs.next()) {
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    System.out.println("Name: " + name + ", Age: " + age);
                }

            } catch (SQLException e) {
                System.out.println("Failed to execute query: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Failed to connect to database: " + e.getMessage());
        }
    }
}