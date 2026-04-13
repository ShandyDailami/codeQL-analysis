import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_24294_JDBCQueryHandler_A03 {

    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Load the driver
            Class.forName(DB_DRIVER);

            // Establish the connection
            con = DriverManager.getConnection(DB_URL, USER, PASS);

            // Prepare statement
            pstmt = con.prepareStatement("SELECT * FROM my_table WHERE id = ?");
            pstmt.setInt(1, 123); // Example injection

            // Execute statement
            rs = pstmt.executeQuery();

            // Process the result
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
            }
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC driver not found");
        } catch (SQLException e) {
            System.out.println("SQL Exception encountered");
        } finally {
            // Clean up
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) {}
            }
            if (pstmt != null) {
                try { pstmt.close(); } catch (SQLException e) {}
            }
            if (con != null) {
                try { con.close(); } catch (SQLException e) {}
            }
        }
    }
}