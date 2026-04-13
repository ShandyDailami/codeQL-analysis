import java.sql.*;

public class java_10451_JDBCQueryHandler_A03 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Establish a Connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 2: Create a Statement
            stmt = conn.createStatement();

            // Step 3: Execute a SQL Query
            String sql = "SELECT * FROM Employee WHERE salary > 50000";
            rs = stmt.executeQuery(sql);

            // Step 4: Process the ResultSet
            while (rs.next()) {
                String name = rs.getString("name");
                int salary = rs.getInt("salary");
                System.out.println("Name: " + name + ", Salary: " + salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close the ResultSet, Statement and Connection
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