import java.sql.*;

public class java_26746_JDBCQueryHandler_A03 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Establish a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connected to the database");

            // Step 2: Create a statement
            stmt = conn.createStatement();
            System.out.println("Statement created");

            // Step 3: Execute a query
            rs = stmt.executeQuery("SELECT * FROM Employees WHERE salary > 50000");
            System.out.println("Query executed");

            // Step 4: Process the results
            while (rs.next()) {
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");
                System.out.println("Name: " + name + ", Salary: " + salary);
            }

            // Step 5: Clean up
            rs.close();
            stmt.close();
            conn.close();
            System.out.println("Connection closed");
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            // Step 6: Always close the connection, statement, and result set
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
        }
    }
}