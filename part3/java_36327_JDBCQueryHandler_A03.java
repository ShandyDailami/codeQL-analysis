import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_36327_JDBCQueryHandler_A03 {

    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // Step 1: Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.createStatement();

            // Step 3: Execute SQL query
            rs = stmt.executeQuery("SELECT * FROM employees");

            // Step 4: Process ResultSet
            while (rs.next()) {
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");
                System.out.println("Name: " + name + ", Salary: " + salary);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close resources
            if (rs != null) try { rs.close(); } catch (SQLException e) { /* unable to do anything */ }
            if (stmt != null) try { stmt.close(); } catch (SQLException e) { /* unable to do anything */ }
            if (conn != null) try { conn.close(); } catch (SQLException e) { /* unable to do anything */ }
        }
    }
}