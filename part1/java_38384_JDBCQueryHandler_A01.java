import java.sql.*;

public class java_38384_JDBCQueryHandler_A01 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Establish a Connection
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 2: Create a Statement
            stmt = conn.createStatement();

            // Step 3: Execute a Query
            String query = "SELECT * FROM Users"; // Example query
            ResultSet rs = stmt.executeQuery(query);

            // Step 4: Process the ResultSet
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("Name: " + name + ", Age: " + age);
            }

            // Step 5: Close the ResultSet and Statement
            rs.close();
            stmt.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            // Step 6: Close the Connection
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}