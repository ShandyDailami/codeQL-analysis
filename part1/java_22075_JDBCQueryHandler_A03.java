import java.sql.*;

public class java_22075_JDBCQueryHandler_A03 {

    // The database credentials
    private static final String USER = "user";
    private static final String PASS = "password";
    private static final String URL = "jdbc:mysql://localhost:3306/dbname";

    // The SQL query
    private static final String QUERY = "SELECT * FROM users WHERE username = ?";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Step 1: Establish a connection
            conn = DriverManager.getConnection(URL, USER, PASS);

            // Step 2: Prepare the statement
            stmt = conn.prepareStatement(QUERY);

            // Set the parameter value
            stmt.setString(1, "exampleUser");

            // Step 3: Execute the statement
            ResultSet rs = stmt.executeQuery();

            // Step 4: Process the result set
            while (rs.next()) {
                String username = rs.getString("username");
                // Do something with the username...
            }

            // Step 5: Clean up
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}