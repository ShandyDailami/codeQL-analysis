import java.sql.*;

public class java_17540_JDBCQueryHandler_A01 {
    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // Step 1: Register JDBC driver
            Class.forName(DB_DRIVER);

            // Step 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 3: Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT * FROM SECRET_DATA";
            ResultSet rs = stmt.executeQuery(sql);

            // Step 4: Extract data from result set
            while (rs.next()) {
                System.out.println("ID: " + rs.getString("ID"));
                System.out.println("Name: " + rs.getString("Name"));
                System.out.println("Address: " + rs.getString("Address"));
                System.out.println("Email: " + rs.getString("Email"));
            }
            // Step 5: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Finally block used to close resources
        }
    }
}