import java.sql.*;

public class java_01906_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:your_db_url";
    private static final String username = "username";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Establish the connection
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database");

            // Step 2: Create a statement
            stmt = conn.createStatement();
            System.out.println("Statement created");

            // Step 3: Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM your_table");
            System.out.println("Query executed");

            // Step 4: Process the results
            while (rs.next()) {
                System.out.println("Row: " + rs.getString(1) + ", " + rs.getString(2));
            }

            // Step 5: Close the connection
            rs.close();
            stmt.close();
            conn.close();
            System.out.println("Connection closed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}