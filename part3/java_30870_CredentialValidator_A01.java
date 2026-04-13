import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

public class java_30870_CredentialValidator_A01 {

    // Encapsulate database connection in a static inner class
    private static class DatabaseConnection {
        private static final String URL = "jdbc:mysql://localhost:3306/test";
        private static final String USER = "root";
        private static final String PASSWORD = "password";

        private static Connection connection;

        static Connection getConnection() {
            if (connection == null) {
                try {
                    connection = DriverManager.getConnection(URL, USER, PASSWORD);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return connection;
        }
    }

    public static boolean validateCredentials(String username, String password) {
        String hashedPassword = getHashedPassword(password);

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT password FROM users WHERE username = ?")) {

            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String dbPassword = resultSet.getString("password");
                return hashedPassword.equals(dbPassword);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    private static String getHashedPassword(String password) {
        MessageDigest digest;
        byte[] hash;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            hash = digest.digest(password.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        return Base64.getEncoder().encodeToString(hash);
    }

    public static void main(String[] args) {
        System.out.println(validateCredentials("user", "password")); // true
        System.out.println(validateCredentials("invalid", "password")); // false
    }
}