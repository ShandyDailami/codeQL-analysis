import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_29403_JDBCQueryHandler_A07 {

    public static void main(String[] args) {
        try {
            // Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Setup connection string
            String url = "jdbc:mysql://localhost:3306/mydb";
            String username = "root";
            String password = "password";

            // Setup connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // Setup statement
            Statement stmt = conn.createStatement();

            // Execute query
            String query = "SELECT * FROM Users WHERE username = 'bademintonist' AND password = 'badpassword'";
            ResultSet rs = stmt.executeQuery(query);

            // Check if query returned any result
            if (rs.next()) {
                System.out.println("User found!");
            } else {
                System.out.println("User not found!");
            }

            // Close connection
            rs.close();
            stmt.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}