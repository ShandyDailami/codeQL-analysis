import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class java_00876_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Prepare SQL query
            String query = "SELECT * FROM my_table WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);

            // Set the parameter value
            pstmt.setInt(1, 123); // Assume id is an integer

            // Execute query
            pstmt.executeUpdate();

            // Close connection
            pstmt.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}