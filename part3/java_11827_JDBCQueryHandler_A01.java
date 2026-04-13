import java.sql.*;

public class java_11827_JDBCQueryHandler_A01 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "username";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Establish the database connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 2: Create a statement object
            stmt = conn.createStatement();

            // Step 3: Execute a query
            rs = stmt.executeQuery("SELECT * FROM Employees WHERE salary > 50000");

            // Step 4: Process the result
            while (rs.next()) {
                String name = rs.getString("name");
                int salary = rs.getInt("salary");
                System.out.println("Name: " + name + ", Salary: " + salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}