import java.sql.*;

public class java_41985_JDBCQueryHandler_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // 1. Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // 2. Create a statement
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            // 3. Execute a query
            System.out.println("Executing query...");
            ResultSet rs = stmt.executeQuery("SELECT * FROM mytable");

            // 4. Process the results
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }

            // 5. Clean up
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            // Handle the exception here
            e.printStackTrace();
        }
    }
}