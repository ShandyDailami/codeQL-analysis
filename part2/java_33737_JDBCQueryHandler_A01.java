import java.sql.*;

public class java_33737_JDBCQueryHandler_A01 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myusername";
    private static final String PASS = "mypassword";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM Employees WHERE salary > " + getSalaryLimit());

            while (rs.next()) {
                String name = rs.getString("name");
                int salary = rs.getInt("salary");
                System.out.println("Name: " + name + ", Salary: " + salary);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static int getSalaryLimit() {
        // This method is used to provide a placeholder for the real implementation
        // of the security-sensitive operation that retrieves the salary limit.
        return 50000;
    }
}