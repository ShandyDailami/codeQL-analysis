import java.sql.*;

public class java_30845_JDBCQueryHandler_A08 {
    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "username";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // Step 1: Establish the connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 2: Create a statement object
            stmt = conn.createStatement();

            // Step 3: Execute the SQL query
            String sql = "INSERT INTO my_table (column1, column2) VALUES ('value1', 'value2')";
            stmt.executeUpdate(sql);

            // Step 4: Handle the result set
            ResultSet rs = stmt.executeQuery("SELECT * FROM my_table");
            while (rs.next()) {
                System.out.println(rs.getString("column1") + " - " + rs.getString("column2"));
            }

            // Step 5: Clean up
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}