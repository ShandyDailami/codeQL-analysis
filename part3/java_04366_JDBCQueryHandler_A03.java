import java.sql.*;

public class java_04366_JDBCQueryHandler_A03 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Establish a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to database!");

            // Step 2: Create a statement
            stmt = conn.createStatement();
            System.out.println("Statement created!");

            // Step 3: Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE id = '" + args[0] + "'");
            System.out.println("Query executed!");

            // Step 4: Process the ResultSet
            while (rs.next()) {
                System.out.println("User id: " + rs.getString("id"));
                System.out.println("User name: " + rs.getString("name"));
            }

            // Step 5: Close connections
            rs.close();
            stmt.close();
            conn.close();
            System.out.println("Disconnected from database!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}