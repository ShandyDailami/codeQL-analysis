import java.sql.*;

public class java_42140_JDBCQueryHandler_A03 {

    // Step 1: Database credentials
    private static final String DB_USERNAME = "user";
    private static final String DB_PASSWORD = "password";

    // Step 2: SQL Query
    private static final String SQL_SELECT_QUERY = "SELECT * FROM users";

    // Step 3: Connect to the database
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", DB_USERNAME, DB_PASSWORD);
            stmt = conn.createStatement();

            // Step 4: Execute the SQL Query
            ResultSet rs = stmt.executeQuery(SQL_SELECT_QUERY);

            // Step 5: Print the results
            while (rs.next()) {
                System.out.println("User ID: " + rs.getInt("id"));
                System.out.println("Username: " + rs.getString("username"));
                System.out.println("Password: " + rs.getString("password"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}