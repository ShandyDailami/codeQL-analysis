import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_10192_JDBCQueryHandler_A07 {

    private Connection connection;

    public java_10192_JDBCQueryHandler_A07(String dbUrl, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(dbUrl, user, password);
    }

    public String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        return new String(hash);
    }

    public boolean authenticate(String username, String password) throws SQLException, NoSuchAlgorithmException {
        String hashedPassword;

        PreparedStatement statement = connection.prepareStatement("SELECT password FROM users WHERE username = ?");
        statement.setString(1, username);

        ResultSet result = statement.executeQuery();
        if (result.next()) {
            hashedPassword = result.getString("password");
            return this.verifyPassword(hashedPassword, password);
        }

        return false;
    }

    private boolean verifyPassword(String hashedPassword, String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        String hashedPasswordCheck = new String(hash);
        return hashedPasswordCheck.equals(hashedPassword);
    }
}