import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_15794_JDBCQueryHandler_A03 {

    private static final String URL = "jdbc:mysql://localhost:3306/dbname";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 1. Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // 3. Prepare statement
            stmt = conn.prepareStatement("SELECT * FROM table_name");

            // 4. Execute query
            rs = stmt.executeQuery();

            // 5. Process result
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                // You can add more operations based on the query
                System.out.println("ID: " + id + ", Name: " + name);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // 6. Close resources
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