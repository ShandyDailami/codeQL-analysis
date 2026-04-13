import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_13579_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        try {
            // Step 1: Load the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection to the database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "username", "password");

            // Step 3: Create a SQL statement
            String sql = "SELECT * FROM Users WHERE ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Step 4: Execute the SQL statement with a parameter
            pstmt.setInt(1, 1001);

            // Step 5: Obtain a ResultSet from the SQL statement
            ResultSet rs = pstmt.executeQuery();

            // Step 6: Process the ResultSet
            while (rs.next()) {
                String id = rs.getString("ID");
                String name = rs.getString("Name");
                System.out.println("ID: " + id + ", Name: " + name);
            }

            // Step 7: Close the ResultSet and the PreparedStatement
            rs.close();
            pstmt.close();

            // Step 8: Close the connection
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}