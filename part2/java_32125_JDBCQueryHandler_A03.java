import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_32125_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        // Injecting SQL code into the query string
        String query = "SELECT * FROM Users WHERE username='" + args[0] + "' AND password='" + args[1] + "'";

        try {
            // Loading the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connecting to the database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "username", "password");

            // Creating a prepared statement
            PreparedStatement pstmt = connection.prepareStatement(query);

            // Executing the query
            pstmt.executeUpdate();

            // Closing the statement and connection
            pstmt.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}