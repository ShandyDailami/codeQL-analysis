import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_34199_JDBCQueryHandler_A07 {

    private static final String URL = "jdbc:mysql://localhost:3306/db_name";
    private static final String USER = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Load MySQL driver
            Class.forName("com.mysql.jdbc.Driver");

            // Step 2: Open connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Create statement
            stmt = conn.createStatement();

            // Step 4: Execute SQL query
            String sql = "SELECT * FROM table_name";
            rs = stmt.executeQuery(sql);

            // Step 5: Handle the result
            while (rs.next()) {
                String name = rs.getString("column_name");
                System.out.println("Name: " + name);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close resources
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}