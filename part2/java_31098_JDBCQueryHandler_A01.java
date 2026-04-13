import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_31098_JDBCQueryHandler_A01 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password"; // Assuming this is the hashed password

    public static void main(String[] args) {
        try {
            // Step 1: Retrieve a password hash from the database
            String sql = "SELECT password FROM users WHERE username = ?";
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "testUser"); // Replace with the actual username
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String password = resultSet.getString("password");

                // Step 2: Verify the password
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] thehash = md.digest(password.getBytes());

                // Convert the byte to hexadecimal format
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < thehash.length; i++) {
                    sb.append(Integer.toString((thehash[i] & 0xff) + 0x100, 16).substring(1));
                }

                String encryptedPassword = sb.toString();

                System.out.println(encryptedPassword);
            }

            // Close the resources
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}