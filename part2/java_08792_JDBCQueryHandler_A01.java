import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_08792_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            getUserPassword("user1");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getUserPassword(String username) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement statement = connection.prepareStatement("SELECT password FROM users WHERE username = ?");
        statement.setString(1, username);

        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String password = resultSet.getString("password");
            return checkPasswordStrength(password);
        }

        throw new SQLException("No user found with username: " + username);
    }

    public static String checkPasswordStrength(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashPassword = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hashPassword) {
            sb.append(String.format("%02x", b));
        }
        String hashedPassword = sb.toString();

        // Check the strength of the password here. This is a simplistic example and should not be used as a real password strength check.
        if (hashedPassword.length() > 10) {
            return "Strong password";
        } else {
            return "Weak password";
        }
    }
}