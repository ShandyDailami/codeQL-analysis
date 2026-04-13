import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_36173_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        // Step 1: Establish a connection to the database
        try (Connection conn = DriverManager.getConnection("jdbc:your_database_url", "username", "password")) {
            System.out.println("Connected to the database!");

            // Step 2: Prepare the statement
            try (Statement stmt = conn.createStatement()) {
                String sql = "SELECT * FROM your_table"; // replace with your SQL query

                // Step 3: Execute the statement and get the result set
                try (ResultSet rs = stmt.executeQuery(sql)) {
                    while (rs.next()) {
                        // Step 4: Process the result set (e.g., print out the data)
                        System.out.println("Result: " + rs.getString("column_name")); // replace "column_name" with your column name
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }
}