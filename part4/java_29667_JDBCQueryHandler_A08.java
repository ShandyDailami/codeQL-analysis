import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_29667_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/dbname";
        String username = "username";
        String password = "password";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection to MySQL database
            conn = DriverManager.getConnection(url, username, password);

            // Step 3: Execute a SQL query
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM tablename"); // replace "tablename" with your table name

            // Step 4: Retrieve data and print
            while (rs.next()) {
                System.out.println(rs.getString("columnname")); // replace "columnname" with your column name
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close the connection
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