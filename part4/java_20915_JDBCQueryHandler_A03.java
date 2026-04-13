import java.sql.*;

public class java_20915_JDBCQueryHandler_A03 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pstmt = null;

        try {
            // Step 1: Establish a connection to the database
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to the database");

            // Step 2: Create a statement object
            stmt = conn.createStatement();
            System.out.println("Statement created");

            // Step 3: Prepare a SQL query
            pstmt = conn.prepareStatement("SELECT * FROM users WHERE id = ?");
            System.out.println("Prepared statement created");

            // Set the parameter value
            pstmt.setInt(1, 123);
            System.out.println("Parameter set");

            // Step 4: Execute the SQL query
            ResultSet rs = pstmt.executeQuery();
            System.out.println("Result set returned");

            while (rs.next()) {
                System.out.println("id: " + rs.getInt("id"));
                System.out.println("name: " + rs.getString("name"));
            }

            // Step 5: Clean up the statements and connection
            rs.close();
            pstmt.close();
            stmt.close();
            conn.close();
            System.out.println("Connection closed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}