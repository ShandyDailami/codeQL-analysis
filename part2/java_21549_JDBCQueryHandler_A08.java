import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_21549_JDBCQueryHandler_A08 {

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // 1. Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish a connection
            conn = DriverManager.getConnection(URL, USER, PASS);

            // 3. Prepare a statement
            stmt = conn.createStatement();

            // 4. Execute a query
            rs = stmt.executeQuery("SELECT * FROM mytable");

            // 5. Retrieve the result set
            while (rs.next()) {
                System.out.println(rs.getString("column1") + " " + rs.getString("column2"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // 6. Close the resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}