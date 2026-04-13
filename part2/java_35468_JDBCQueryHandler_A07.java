import java.sql.*;

public class java_35468_JDBCQueryHandler_A07 {
    // Define the database connection URL, username, and password
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "password";

    // Main method
    public static void main(String[] args) {
        // Try-with-resources statement to automatically close the statement and the connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {

            // Use the connection and statement objects to execute SQL queries
            ResultSet rs = stmt.executeQuery("SELECT * FROM my_table");

            // Process the result set
            while (rs.next()) {
                // Get the values from the result set
                String column1 = rs.getString("column1");
                int column2 = rs.getInt("column2");

                // Do something with the values
                System.out.println("Column 1: " + column1);
                System.out.println("Column 2: " + column2);
            }
        } catch (SQLException e) {
            // Handle any SQL exceptions that occur
            e.printStackTrace();
        }
    }
}