import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_26851_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:your_database_url";
        String username = "your_username";
        String password = "your_password";

        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the connection
            conn = DriverManager.getConnection(url, username, password);

            // Step 3: Create a statement object
            stmt = conn.createStatement();

            // Step 4: Execute a SQL query
            String sql = "SELECT * FROM your_table";
            ResultSet rs = stmt.executeQuery(sql);

            // Step 5: Process the results
            while (rs.next()) {
                System.out.println(rs.getString("your_column"));
            }

            // Step 6: Close the statement and connection
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}