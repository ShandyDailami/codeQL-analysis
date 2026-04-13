import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_24902_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // Step 3: Execute a query
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM users";
            ResultSet rs = stmt.executeQuery(sql);

            // Step 4: Process the result
            while (rs.next()) {
                String userId = rs.getString("userId");
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("User ID: " + userId);
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Step 5: Close the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}