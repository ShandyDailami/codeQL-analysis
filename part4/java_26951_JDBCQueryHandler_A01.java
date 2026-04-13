import java.sql.*;

public class java_26951_JDBCQueryHandler_A01 {
    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Load the MySQL driver
            Class.forName(DB_DRIVER);

            // Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Prepare a statement
            stmt = conn.createStatement();

            // Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM Employee");

            // Extract data from result set
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String position = rs.getString("position");
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Position: " + position);
            }
            // Close the statement and connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // Handle any SQLException
            se.printStackTrace();
        } catch (Exception e) {
            // Handle any other exception
            e.printStackTrace();
        } finally {
            // Clean up environment
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}