import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_27722_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        // Step 1: Establish a connection
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database");
            e.printStackTrace();
            return;
        }

        // Step 2: Create a prepared statement
        String query = "INSERT INTO Users (username, password) VALUES (?, ?)";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(query);
        } catch (SQLException e) {
            System.out.println("Failed to prepare statement");
            e.printStackTrace();
            return;
        }

        // Step 3: Set the parameters
        pstmt.setString(1, "testUser");
        pstmt.setString(2, "testPassword");

        // Step 4: Execute the statement
        int rowsInserted = 0;
        try {
            rowsInserted = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Failed to execute statement");
            e.printStackTrace();
            return;
        }

        System.out.println("Rows inserted: " + rowsInserted);

        // Step 5: Close the statement and connection
        try {
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Failed to close connection or statement");
            e.printStackTrace();
            return;
        }
    }
}