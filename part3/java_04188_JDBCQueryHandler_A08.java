import java.sql.*;

public class java_04188_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:your_database_url";
    private static final String USER = "your_username";
    private static final String PASS = "your_password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Load the Driver
            Class.forName("com.mysql.jdbc.Driver");

            // Step 2: Open a Connection
            conn = DriverManager.getConnection(URL, USER, PASS);

            // Step 3: Execute a Query
            stmt = conn.createStatement();
            String sql = "SELECT * FROM your_table"; // replace with your SQL
            ResultSet rs = stmt.executeQuery(sql);

            // Step 4: Process the ResultSet
            while (rs.next()) {
                System.out.println("ID: " + rs.getString("id"));
                System.out.println("Name: " + rs.getString("name"));
            }

            // Step 5: Clean Up
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {}
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}