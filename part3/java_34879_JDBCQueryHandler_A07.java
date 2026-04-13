import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_34879_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        // Step 1: Register JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Step 2: Establish connection
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydatabase", "username", "password")) {

            // Step 3: Create a statement
            try (Statement stmt = conn.createStatement()) {

                // Step 4: Execute a query
                try (ResultSet rs = stmt.executeQuery("SELECT * FROM my_table")) {

                    // Step 5: Process the results
                    while (rs.next()) {
                        // Assuming that we have columns called 'column1' and 'column2' in our table
                        String value1 = rs.getString("column1");
                        String value2 = rs.getString("column2");

                        // Handle the results
                        // Realistic example: print them out
                        System.out.println("Value1: " + value1);
                        System.out.println("Value2: " + value2);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}