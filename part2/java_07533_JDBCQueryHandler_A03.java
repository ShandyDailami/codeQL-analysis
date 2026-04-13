import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_07533_JDBCQueryHandler_A03 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Step 1: Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 3: Execute SQL query
            String query = "SELECT * FROM users WHERE username = ?";
            conn.prepareStatement(query).setString(1, "testUser");

            // Step 4: Handle the result
            // Assume that we have a ResultSet to handle the result.
            // You might need to implement additional logic based on your actual needs.
            while (stmt.execute()) {
                String user = stmt.getString("username");
                System.out.println("User: " + user);
            }

            // Step 5: Close the connection
            if (conn != null) {
                conn.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}