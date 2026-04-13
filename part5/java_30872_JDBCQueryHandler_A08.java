import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_30872_JDBCQueryHandler_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Step 1: Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Step 2: Establish a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 3: Perform SQL operation
            String sql = "UPDATE user SET password = 'newpassword' WHERE id = 1";
            int result = conn.createStatement().executeUpdate(sql);
            System.out.println("Updated " + result + " rows");

        } catch (ClassNotFoundException e) {
            System.out.println("Error: MySQL Driver not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing the connection: " + e.getMessage());
                }
            }
        }
    }
}