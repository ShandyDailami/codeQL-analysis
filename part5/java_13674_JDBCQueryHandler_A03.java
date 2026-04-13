import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class java_13674_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Prepare a statement
            String sql = "INSERT INTO EMPLOYEE(ID, NAME, AGE, ADDRESS) VALUES(?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);

            // Insert a row of data into the table
            pstmt.setInt(1, 1000);
            pstmt.setString(2, "John");
            pstmt.setInt(3, 28);
            pstmt.setString(4, "New York");
            pstmt.executeUpdate();

            System.out.println("Insert completed successfully!");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // Cleanup environment
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}