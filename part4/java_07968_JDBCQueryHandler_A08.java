import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_07968_JDBCQueryHandler_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection to the database
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 2: Prepare a statement
            String query = "SELECT * FROM Users WHERE role = 'user' AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);

            // Step 3: Set the parameter
            String password = getPasswordHash("password"); // Assuming the password is 'password'
            pstmt.setString(1, password);

            // Step 4: Execute the query
            ResultSet rs = pstmt.executeQuery();

            // Step 5: Process the results
            while (rs.next()) {
                String username = rs.getString("username");
                String email = rs.getString("email");
                System.out.println("Username: " + username);
                System.out.println("Email: " + email);
            }

            // Step 6: Close the resources
            rs.close();
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String getPasswordHash(String password) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(password.getBytes());
        byte[] bytes = md.digest();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}