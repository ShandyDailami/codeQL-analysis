import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_25178_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Execute a query
            String query = "SELECT * FROM Employee";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            // Step 4: Process the results
            while (rs.next()) {
                String employeeId = rs.getString("employeeId");
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");

                System.out.println("Employee ID: " + employeeId);
                System.out.println("Name: " + name);
                System.out.println("Salary: " + salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close the resources
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