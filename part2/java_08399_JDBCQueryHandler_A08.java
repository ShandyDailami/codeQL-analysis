import java.sql.*;

public class java_08399_JDBCQueryHandler_A08 {

    // JDBC driver name and database URL
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        try {
            // Step 1: Register JDBC driver
            Class.forName(DRIVER);

            // Step 2: Open a connection
            con = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 3: Execute a query
            stmt = con.createStatement();
            String sql = "SELECT * FROM Employee";
            ResultSet rs = stmt.executeQuery(sql);

            // Step 4: Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("name: " + name + ", age: " + age);
            }

            // Step 5: Clean-up environment
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Always close the connection, regardless of exceptions
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }
}