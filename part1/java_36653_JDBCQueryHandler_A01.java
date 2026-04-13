import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_36653_JDBCQueryHandler_A01 {
    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Load the driver
            Class.forName(DB_DRIVER);

            // Establish a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // SQL query
            String SQL = "SELECT * FROM Users WHERE id = ?";
            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, 123); // set parameter value

            // Execute the query
            rs = pstmt.executeQuery();

            // Extract data from result set
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Cleanup the statement
            if (pstmt != null) {
                try { pstmt.close(); } catch(SQLException e) {}
            }
            if (conn != null) {
                try { conn.close(); } catch(SQLException e) {}
            }
        }
    }
}