import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_37648_JDBCQueryHandler_A07 {

    public static void main(String[] args) {
        try {
            // Step 1: Register MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database", "username", "password");

            // Step 3: Create a statement
            Statement stmt = conn.createStatement();

            // Step 4: Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users WHERE username = 'test' AND password = 'test'");

            // Step 5: Handle the result set
            while (rs.next()) {
                System.out.println("User found");
            }

            // Step 6: Close the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}