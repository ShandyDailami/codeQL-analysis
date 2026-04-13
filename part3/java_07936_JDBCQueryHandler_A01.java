import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_07936_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        // Step 1: Establish a connection
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "user", "password");
            stmt = conn.createStatement();

            // Step 2: Perform a query
            String sql = "SELECT * FROM Users";
            ResultSet rs = stmt.executeQuery(sql);

            // Step 3: Handle the results
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }

            // Step 4: Clean up
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}