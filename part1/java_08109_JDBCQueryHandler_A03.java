import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class java_08109_JDBCQueryHandler_A03 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 3: Execute a query
            String sql = "SELECT id, name, department FROM employees";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            // Step 4: Process the results
            List<Employee> employees = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                employees.add(new Employee(id, name, department));
            }

            // Step 5: Print the results
            for (Employee employee : employees) {
                System.out.println("ID: " + employee.getId());
                System.out.println("Name: " + employee.getName());
                System.out.println("Department: " + employee.getDepartment());
           .
.
.
.

                // This is just a placeholder for real world usage. In real world, the Employee class and fields would be more complex.
                }
            } finally {
                // Step 6: Clean up resources
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

class Employee {
    private int id;
    private String name;
    private String department;

    public java_08109_JDBCQueryHandler_A03(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    // getters and setters here...
}