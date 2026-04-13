import java.sql.*;

public class java_01681_JDBCQueryHandler_A01 {

    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";

    // Database credentials
    private static final String USER = "username";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName(DB_DRIVER);

            // Step 2: Open a connection
            con = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 3: Execute a query
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE WHERE AGE > " + getAge());

            // Step 4: Extract data from result set
            while (rs.next()) {
                // Print the data
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
            }
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
        }
    }

    // Simulating secure operation that returns age of a person
    private static int getAge() {
        // This operation is secure as it only accesses data from the database
        // We are using a mock age here for demonstration
        return 20;
    }
}