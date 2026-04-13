import java.sql.*;

public class java_27346_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/db_name";
    private static final String USER = "user_name";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Load Driver
            Class.forName("com.mysql.jdbc.Driver");

            // Step 2: Open Connection
            conn = DriverManager.getConnection(URL, USER, PASS);

            // Step 3: Create Statement
            stmt = conn.createStatement();

            // Step 4: Execute SQL Query
            String sql = "SELECT * FROM table_name"; // replace table_name with your actual table name
            ResultSet rs = stmt.executeQuery(sql);

            // Step 5: Process the ResultSet
            while (rs.next()) {
                // replace column_name with your actual column name
                String userName = rs.getString("column_name");
                // add more if required
            }

            // Step 6: Clean up
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Always close the connection
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}