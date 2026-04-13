import java.sql.*;

public class java_12599_JDBCQueryHandler_A01 {
    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "myuser";
    private static final String PASS = "mypassword";

    public static void main(String[] args) {
        // Create a connection
        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS)) {
            System.out.println("Connected to the database");

            // Create a statement
            try (Statement stmt = con.createStatement()) {
                // Execute the query
                String sql = "INSERT INTO employees (name, email, salary) VALUES ('John', 'john@example.com', 70000)";
                stmt.executeUpdate(sql);
                System.out.println("Inserted new row into the database");
            }
        } catch (SQLException ex) {
            System.out.println("Error while connecting to the database");
            ex.printStackTrace();
        }
    }
}