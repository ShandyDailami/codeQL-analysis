import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_27633_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        // Step 1: Establish a connection
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            String url = "jdbc:mysql://localhost:3306/mydb"; // replace with your database url
            String username = "root"; // replace with your username
            String password = "password"; // replace with your password

            conn = DriverManager.getConnection(url, username, password);

            // Step 2: Create a statement
            stmt = conn.createStatement();

            // Step 3: Execute a query
            rs = stmt.executeQuery("SELECT * FROM my_table"); // replace with your query

            // Step 4: Process the results
            while (rs.next()) {
                System.out.println(rs.getString("my_column")); // replace with your column name
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close the resources
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) {}
            }
            if (stmt != null) {
                try { stmt.close(); } catch (SQLException e) {}
            }
            if (conn != null) {
                try { conn.close(); } catch (SQLException e) {}
            }
        }
    }
}