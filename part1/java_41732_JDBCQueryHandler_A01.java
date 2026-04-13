import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_41732_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        try {
            // Step 1: Load database driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");

            // Step 3: Create a statement
            Statement stmt = conn.createStatement();

            // Step 4: Execute a SQL query
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE role = 'admin'");

            // Step 5: Process the result set
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Step 6: Close the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}