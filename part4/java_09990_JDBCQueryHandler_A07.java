import java.sql.*;

public class java_09990_JDBCQueryHandler_A07 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection to the database
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 2: Create a statement object
            Statement stmt = conn.createStatement();

            // Step 3: Execute a SQL query
            String sql = "SELECT * FROM table_name WHERE condition = 'value'";
            ResultSet rs = stmt.executeQuery(sql);

            // Step 4: Process the result set
            while (rs.next()) {
                // TODO: handle data, consider security sensitive operations
            }

            // Step 5: Cleanup
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}