import java.sql.*;

public class java_19928_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        // Set up the database connection
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            // Set up the SQL statement
            String sql = "SELECT * FROM my_table";

            // Prepare the statement
            try (Statement stmt = conn.createStatement()) {
                // Execute the SQL statement
                ResultSet rs = stmt.executeQuery(sql);

                // Process the results
                while (rs.next()) {
                    String column1 = rs.getString("column1");
                    String column2 = rs.getString("column2");
                    // ... and so on for each column in your table

                    System.out.println("Column1: " + column1);
                    System.out.println("Column2: " + column2);
                    // ... and so on for each column in your table
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}