import java.sql.*;

public class java_34230_JDBCQueryHandler_A07 {

    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    
    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    private static Connection conn = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;

    public static void main(String[] args) {

        try {
            // Load the MySQL driver
            Class.forName(DB_DRIVER);

            // Establish a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Prepare a statement
            stmt = conn.createStatement();

            // Execute SQL query
            String sql = "SELECT * FROM employees";
            rs = stmt.executeQuery(sql);

            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String dept = rs.getString("dept");

                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Department: " + dept);
            }

            // Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //finally block used to close resources
        }
    }
}