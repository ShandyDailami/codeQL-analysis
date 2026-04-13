import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_39192_JDBCQueryHandler_A07 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Step 2: Open a connection
            conn = DriverManager.getConnection(url, username, password);

            // Step 3: Create a statement
            stmt = conn.createStatement();

            // Step 4: Execute the query
            String sql = "SELECT * FROM Users WHERE username = 'test' AND password = 'test'";
            ResultSet rs = stmt.executeQuery(sql);

            // Step 5: Process the result set
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Username: " + username + ", Password: " + password);
            }

            // Step 6: Close the statement and connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}