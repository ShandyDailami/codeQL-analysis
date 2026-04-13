import java.sql.*;

public class java_34299_JDBCQueryHandler_A08 {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Setup connection to database
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 2: Create statement
            stmt = conn.createStatement();

            // Step 3: Execute SQL query
            String sql = "SELECT * FROM mytable";
            ResultSet rs = stmt.executeQuery(sql);

            // Step 4: Process results
            while (rs.next()) {
                System.out.println(rs.getString("column1") + " - " + rs.getString("column2"));
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