import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class java_35080_CredentialValidator_A08 {
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    public boolean validate(String username, String password) {
        try {
            Connection connection = getConnection();
            String hashedPassword = getHashedPassword(password);

            String query = "SELECT password FROM users WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String dbHashedPassword = resultSet.getString("password");

                return comparePasswords(hashedPassword, dbHashedPassword);
            }
        } catch (SQLException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return false;
    }

    private Connection getConnection() throws SQLException, NoSuchAlgorithmException {
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);

        return connection;
    }

    private String getHashedPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        messageDigest.update(salt);
        byte[] hashedPassword = messageDigest.digest(password.getBytes());

        StringBuilder hashedPasswordBuilder = new StringBuilder();
        for (byte b : hashedPassword) {
            hashedPasswordBuilder.append(String.format("%02x", b));
        }

        return hashedPasswordBuilder.toString();
    }

    private boolean comparePasswords(String hashedPassword, String dbHashedPassword) {
        return hashedPassword.equals(dbHashedPassword);
    }
}