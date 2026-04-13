import java.sql.*;

public class java_18585_JDBCQueryHandler_A07 {
    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "myuser";
    private static final String PASS = "mypass";

    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;

        try {
            // Step 1: Establish a connection
            con = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 2: Create a statement
            stmt = con.createStatement();

            // Step 3: Execute the query
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users WHERE username = 'alice' AND password = 'password123'");

            // Step 4: Process the ResultSet
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Step 5: Close the connection
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            // Step 6: Close the connection
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (con != null) con.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}