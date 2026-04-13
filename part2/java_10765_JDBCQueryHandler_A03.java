import java.sql.*;

public class java_10765_JDBCQueryHandler_A03 {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // Step 1: Establish a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 2: Create a statement
            stmt = conn.createStatement();

            // Step 3: Execute a query
            String sql = "SELECT * FROM employees WHERE salary > ?";
            ResultSet rs = stmt.executeQuery(sql, 50000);

            // Step 4: Process the result set
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");
                System.out.println(id + " " + name + " " + salary);
            }
            rs.close();

            // Step 5: Close the statement and connection
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}