import java.sql.*;

public class java_09632_JDBCQueryHandler_A01 {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Establish a connection to the database
            con = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 2: Create a statement object
            stmt = con.createStatement();

            // Step 3: Define the SQL query
            String sql = "SELECT * FROM users WHERE username = 'testUser'";

            // Step 4: Execute the query and obtain a result set
            rs = stmt.executeQuery(sql);

            // Step 5: Process the result set
            while (rs.next()) {
                // Retrieve by column name
                String username = rs.getString("username");
                String password = rs.getString("password");

                System.out.println("User Name: " + username);
                System.out.println("Password: " + password);
            }

            // Step 6: Clean up the environment
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}