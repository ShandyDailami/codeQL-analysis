import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_41604_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:your_database_url";
        String username = "username";
        String password = "password";
        String sql = "SELECT password FROM Users WHERE username = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Or the correct driver for your database
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, "user"); // Replace with the username you want to check
                ResultSet result = statement.executeQuery();
                if (result.next()) {
                    String dbPassword = result.getString("password");
                    String inputPassword = getPasswordHash("password", "SHA-256"); // Replace with the real password
                    if (dbPassword.equals(inputPassword)) {
                        System.out.println("Access granted!");
                    } else {
                        System.out.println("Access denied!");
                    }
                } else {
                    System.out.println("User not found!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String getPasswordHash(String password, String algorithm) {
        MessageDigest digest;
        byte[] hash;
        try {
            digest = MessageDigest.getInstance(algorithm);
            hash = digest.digest(password.getBytes());
            return new String(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}