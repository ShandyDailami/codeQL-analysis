import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_24864_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Setup connection URL, username, password
            String url = "jdbc:mysql://localhost:3306/mydatabase";
            String username = "myuser";
            String password = "mypassword";

            // Open a connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Create a statement
            Statement stmt = con.createStatement();

            // Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM my_table WHERE username = 'myuser' AND password = 'mypassword'");

            // Process the result set
            while (rs.next()) {
                // Get the values
                String username = rs.getString("username");
                String password = rs.getString("password");

                // Do something with the values (e.g., print them)
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Close the connection
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}