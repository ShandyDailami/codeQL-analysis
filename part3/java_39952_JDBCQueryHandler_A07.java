import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class java_39952_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "";
        String query = "SELECT password_hash FROM users WHERE username = ?";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            if (resultSet.next()) {
                String dbPassword = resultSet.getString(1);

                // We're not comparing the passwords directly, but we can use a message digest to do so
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] hashedInput = md.digest(password.getBytes());
                String hashedPassword = bytesToHex(hashedInput);

                // Now we can compare the hashed passwords
                if (hashedPassword.equals(dbPassword)) {
                    System.out.println("Access granted");
                } else {
                    System.out.println("Access denied");
                }
            }
        } catch (SQLException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            stringBuilder.append(Character.forDigit((b >> 4) & 0xF, 16));
            stringBuilder.append(Character.forDigit(b & 0xF, 16));
        }
        return stringBuilder.toString();
    }
}