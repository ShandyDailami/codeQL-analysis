import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_25448_JDBCQueryHandler_A07 {

    public static void main(String[] args) {
        try {
            // Step 1: Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_name", "username", "password");

            // Step 3: Create a statement
            Statement stmt = conn.createStatement();

            // Step 4: Execute a SQL query
            String sql = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
            ResultSet rs = stmt.executeQuery(sql);

            // Step 5: Handle the ResultSet
            while (rs.next()) {
                // Authentication successful, do something...
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