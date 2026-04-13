import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_02732_JDBCQueryHandler_A03 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 3: Prepare statement
            String sql = "SELECT * FROM employees WHERE id = ?";
            pstmt = conn.prepareStatement(sql);

            // Step 4: Set parameters and execute query
            pstmt.setInt(1, 123); // Set parameter 1

            // Step 5: Execute query
            ResultSet rs = pstmt.executeQuery();

            // Process the ResultSet
            while (rs.next()) {
                System.out.println("Found employee");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Salary: " + rs.getDouble("salary"));
            }

            // Close resources
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}