import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_31201_CredentialValidator_A01 implements java.security.AuthenticationValidator {

    private static final String DB_URL = "jdbc:mysql://localhost/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";
    private MessageDigest md;

    public java_31201_CredentialValidator_A01() {
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public boolean validate(Principal arg0, String arg1) {
        String hashedPassword = getHashedPassword(arg0.getName());
        return hashedPassword.equals(arg1);
    }

    private String getHashedPassword(String username) {
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;
        String hashedPassword = null;
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT password FROM users WHERE username ='" + username + "'");
            if (rs.next()) {
                hashedPassword = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Always close the database resources
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return hashedPassword;
    }
}