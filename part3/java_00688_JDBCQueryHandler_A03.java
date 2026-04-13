import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_00688_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb", "username", "password");

            // Step 3: Prepare a statement
            String query = "SELECT * FROM mytable WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);

            // Step 4: Use the ? placeholder for the id
            pstmt.setInt(1, 123);

            // Step 5: Execute the statement
            ResultSet rs = pstmt.executeQuery();

            // Step 6: Process the result
            while (rs.next()) {
                System.out.println("Found user: " + rs.getString("name"));
            }

            // Step 7: Close the connection
            rs.close();
            pstmt.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}