import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_20037_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        // Load the driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Connect to the database
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "username", "password")) {
            // Create a statement
            try (Statement stmt = conn.createStatement()) {
                // Execute the statement and get the result set
                try (ResultSet rs = stmt.executeQuery("SELECT * FROM Employees")) {
                    // Print the result
                    while (rs.next()) {
                        System.out.println("Employee ID: " + rs.getInt("id"));
                        System.out.println("Employee Name: " + rs.getString("name"));
                        System.out.println("Employee Salary: " + rs.getDouble("salary"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}