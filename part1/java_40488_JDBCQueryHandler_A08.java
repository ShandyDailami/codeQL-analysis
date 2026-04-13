import java.sql.*;
import java.util.Random;

public class java_40488_JDBCQueryHandler_A08 {

    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        Random rand = new Random();
        String user = "user";
        String password = "password"; // Generate a random password for the user
        String hashedPassword = hashPassword(password); // Hashed password for security

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, user);
            pstmt.setString(2, hashedPassword);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("User created successfully");
            } else {
                System.out.println("Failed to create user");
            }

            conn.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static String hashPassword(String password) {
        // Here you would typically use a hashing algorithm such as SHA-256
        // This is a very basic example and should not be used in a real-world scenario
        return password;
    }
}