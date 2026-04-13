import java.sql.*;

public class java_15245_JDBCQueryHandler_A01 {
    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASS = "mypassword";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Establish the connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 2: Create a statement
            stmt = conn.createStatement();

            // Step 3: Execute the query
            rs = stmt.executeQuery("SELECT * FROM mytable WHERE mycolumn = 'myvalue'");

            // Step 4: Process the results
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close the connections
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