import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_40501_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        try {
            String url = "jdbc:your-database-url";
            String username = "your-username";
            String password = getHashedPassword(password, "SHA-256");
            Connection connection = DriverManager.getConnection(url, username, password);

            String sql = "SELECT password FROM Users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "your-username");

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String dbPassword = resultSet.getString("password");
                System.out.println("User's password from database: " + dbPassword);
            } else {
                System.out.println("No user with the given username found");
            }

            connection.close();
        } catch (SQLException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static String getHashedPassword(String password, String algorithm) throws NoSuchAlgorithmException, SQLException {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        byte[] hash = md.digest(password.getBytes());
        return bytesToHex(hash);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
}