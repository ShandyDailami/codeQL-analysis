import java.sql.*;

public class java_28854_JDBCQueryHandler_A01 {
    // Create a constant for the database URL, username, and password
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "myuser";
    private static final String PASS = "mypass";

    // Method to perform a query
    public void performQuery(String query) {
        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Prepare a statement for execution
            Statement stmt = conn.createStatement();

            // Execute the query and get the result set
            ResultSet rs = stmt.executeQuery(query);

            // Process the result set
            while (rs.next()) {
                // Here, we assume the query is a simple select query and we print the values.
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
            }

            // Close the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error in JDBC operation: " + e.getMessage());
        }
    }
}