import java.sql.*;

public class java_00194_JDBCQueryHandler_A03 {
    // Define the JDBC driver name and database URL
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        // Initialize the connection and the statement
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Load the MySQL driver
            Class.forName(DRIVER);

            // Step 2: Open a connection
            conn = DriverManager.getConnection(URL, USER, PASS);

            // Step 3: Prepare the statement
            stmt = conn.createStatement();

            // Step 4: Execute the query
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE username='" + args[0] + "' AND password='" + args[1] + "'");

            // Step 5: Process the result
            while (rs.next()) {
                System.out.println("Found a user with username: " + rs.getString("username"));
            }

            // Step 6: Close the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}