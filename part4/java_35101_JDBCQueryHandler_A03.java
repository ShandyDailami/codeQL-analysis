import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_35101_JDBCQueryHandler_A03 {

    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Step 1: Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Create a SQL query
            String sql = "SELECT * FROM employees WHERE id = ?";

            // Step 4: Prepare the statement
            pstmt = conn.prepareStatement(sql);

            // Step 5: Set parameters
            pstmt.setInt(1, 101);

            // Step 6: Execute the query
            pstmt.executeUpdate();

            // Step 7: Process the result
            // Here we assume that the database has a table named 'employees' with a 'id' column.
            // You should replace the code below with your actual code.

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 8: Close the resources
            if (pstmt != null) {
                try { pstmt.close(); } catch (SQLException e) { /* intentionally empty */ }
            }
            if (conn != null) {
                try { conn.close(); } catch (SQLException e) { /* intentionally empty */ }
            }
        }
    }
}