import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_20895_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        // Load MySQL driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Java driver not found.");
        }

        // Connect to database
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbname", "username", "password");
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
            return;
        }

        // Prepare and execute a query
        String query = "SELECT * FROM employees WHERE salary > ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setDouble(1, 50000); // set parameter value

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");
                System.out.println("Employee: " + name + ", Salary: " + salary);
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error while executing query.");
            e.printStackTrace();
        }
    }
}