import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_18780_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        try {
            // Step 1: Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydatabase", "username", "password");

            // Step 3: Execute a statement
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE age = " + 18);

            // Step 4: Process the ResultSet
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }

            // Step 5: Clean up
            rs.close();
            stmt.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}