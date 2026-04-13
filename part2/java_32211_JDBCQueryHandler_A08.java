import java.sql.*;

public class java_32211_JDBCQueryHandler_A08 {
    private static final String DB_URL = "jdbc:sqlite:test.db";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Create a connection to the database
            conn = DriverManager.getConnection(DB_URL);

            // Step 2: Create a statement
            stmt = conn.createStatement();

            // Step 3: Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM Employees WHERE salary > 50000");

            // Step 4: Process the result set
            while (rs.next()) {
                String name = rs.getString("name");
                int salary = rs.getInt("salary");
                System.out.println(name + ", " + salary);
            }

            // Step 5: Clean up
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}