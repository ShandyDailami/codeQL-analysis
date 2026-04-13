import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_05146_JDBCQueryHandler_A07 {

    // Database credentials
    private String url = "jdbc:mysql://localhost:3306/mydatabase";
    private String username = "root";
    private String password = "password";

    // Message digest for password hashing
    private MessageDigest md;

    public java_05146_JDBCQueryHandler_A07() {
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public boolean validateUser(String userName, String password) {
        String hashedPassword = getHashedPassword(password);
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Users WHERE username = ?");
            statement.setString(1, userName);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                return hashedPassword.equals(result.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private String getHashedPassword(String password) {
        byte[] hashedPasswordBytes = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hashedPasswordBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}