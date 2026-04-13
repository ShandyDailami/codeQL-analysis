import java.sql.*;

public class java_29179_JDBCQueryHandler_A01 {
    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String user = "root";
    private static final String password = "root";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            conn = DriverManager.getConnection(url, user, password);

            // Step 3: Execute a query
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Employees");

            // Step 4: Process the results
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                double salary = rs.getDouble("salary");

                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Salary: " + salary);
            }

            // Step 5: Cleanup
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Ensure resources are closed
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}