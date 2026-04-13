import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_14071_JDBCQueryHandler_A07 {

    private static final String URL = "jdbc:your_database_url";
    private static final String USERNAME = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver"); // or other driver class

            // Step 2: Establish a connection
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // Step 3: Execute a query
            String query = "SELECT * FROM your_table"; // replace with your actual query
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            // Step 4: Process the result
            while (rs.next()) {
                // process result
            }

            // Step 5: Close connection
            rs.close();
            pstmt.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}