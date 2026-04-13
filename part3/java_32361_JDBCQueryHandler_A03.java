import java.sql.*;
import java.security.*;

public class java_32361_JDBCQueryHandler_A03 {

    // A simple way to handle security sensitive operations
    private static MessageDigest md;

    static {
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static String getMD5Hash(String input) {
        byte[] bytes = md.digest(input.getBytes());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    private final String url;
    private final String username;
    private final String password;

    public java_32361_JDBCQueryHandler_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = getMD5Hash(password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}