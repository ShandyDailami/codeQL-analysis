import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_24899_JDBCQueryHandler_A07 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 3: Prepare a statement
            pstmt = conn.prepareStatement("SELECT * FROM Users WHERE username = ? AND password = ?");

            // Set the parameters
            pstmt.setString(1, "user1");
            pstmt.setString(2, "password1");

            // Step 4: Execute the statement
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("Logged in successfully");
            } else {
                System.out.println("Failed to log in");
            }

            // Close the statement and connection
            pstmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}