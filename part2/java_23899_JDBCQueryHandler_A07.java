import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class java_23899_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    public static void main(String[] args) {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String userPassword = "password"; // This should be hashed and not stored in plaintext

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String hashedPassword = hashPassword(userPassword);

            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "user");

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String dbPassword = resultSet.getString("password");
                if (isPasswordEqual(hashedPassword, dbPassword)) {
                    System.out.println("Access granted");
                } else {
                    System.out.println("Access denied");
                }
            } else {
                System.out.println("User not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String hashPassword(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte[] hash = md.digest(password.getBytes());
        return new String(hash);
    }

    private static boolean isPasswordEqual(String hashedPassword, String dbPassword) {
        return hashedPassword.equals(dbPassword);
    }
}