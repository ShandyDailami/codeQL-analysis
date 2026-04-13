import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_22882_SessionManager_A08 {
    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "username", "password");

            // Step 2: Open a session
            conn.setAutoCommit(false);

            // Step 3: Store a string
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO SessionData (data) VALUES (?)");
            pstmt.setString(1, "Some data");
            pstmt.executeUpdate();

            // Step 4: Retrieve the stored string
            ResultSet rs = pstmt.executeQuery("SELECT data FROM SessionData");
            if (rs.next()) {
                System.out.println("Retrieved data: " + rs.getString("data"));
            }

            // Step 5: Try to open a session and store a string
            pstmt = conn.prepareStatement("INSERT INTO SessionData (data) VALUES (?)");
            pstmt.setString(1, "Another data");
            pstmt.executeUpdate();

            // Step 6: Attempt to open a session with integrity failure
            pstmt = conn.prepareStatement("INSERT INTO SessionData (data) VALUES (?)");
            pstmt.setString(1, "Third data");

            // If this fails due to integrity violation, an SQLException will be thrown
            pstmt.executeUpdate();
            System.out.println("Attempted to open a session and store data, but failed due to integrity violation.");

            // Step 7: Close the connection
            conn.close();
        } catch (SQLException e) {
            System.out.println("SQLException caught: " + e.getMessage());
        }
    }
}