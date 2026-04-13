import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_25986_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the connection
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb", "username", "password");

            // Step 3: Create a statement object
            stmt = conn.createStatement();

            // Step 4: Execute the query
            rs = stmt.executeQuery("SELECT * FROM my_table");

            // Step 5: Process the results
            while (rs.next()) {
                System.out.println(rs.getString("my_column"));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close the resources
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