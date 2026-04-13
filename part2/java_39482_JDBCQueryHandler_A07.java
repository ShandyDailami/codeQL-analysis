import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_39482_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        // Step 1: Establish a connection to the database
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DriverManager.getConnection("jdbc:your_database_url", "username", "password");
            String query = "SELECT * FROM your_table"; // Replace with your query
            pstmt = conn.prepareStatement(query);

            // Step 2: Execute the query
            pstmt.execute();

            // Step 3: Handle the result set
            ResultSet rs = pstmt.getResultSet();
            while (rs.next()) {
                // Handle the result set here
            }

            // Step 4: Close the resources
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}