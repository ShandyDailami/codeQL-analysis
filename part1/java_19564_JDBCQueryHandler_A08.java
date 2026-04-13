import java.sql.*;

public class java_19564_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish database connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Execute SQL statement
            stmt = conn.createStatement();
            String sql = "SELECT * FROM Employees WHERE Salary < :lowSalary";
            ResultSet rs = stmt.executeQuery(sql);

            // Step 4: Handle ResultSet
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");
                System.out.println(id + ", " + name + ", " + salary);
            }

            // Step 5: Close database connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Ensure resources are closed in all cases
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}