import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class java_35993_SessionManager_A03 {

    // Connection data
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user ID:");
        int userId = scanner.nextInt();

        // Connect to the database
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "SELECT password FROM Users WHERE id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, userId);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        String dbPassword = rs.getString("password");
                        // Check if the input password matches the database password
                        if (dbPassword.equals(userPassword)) {
                            System.out.println("Access granted!");
                        } else {
                            System.out.println("Access denied!");
                        }
                    } else {
                        System.out.println("No user with that ID found!");
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error connecting to database: " + ex.getMessage());
        }
    }
}