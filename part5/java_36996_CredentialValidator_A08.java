import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_36996_CredentialValidator_A08 {
    private static final String DB_URL = "your_db_url";
    private static final String USER = "your_username";
    private static final String PASS = "your_password";

    public static boolean validate(String passwordAttempt) throws NoSuchAlgorithmException, SQLException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashInBytes = md.digest(passwordAttempt.getBytes());
        
        StringBuffer sb = new StringBuffer();
        for(int i=0; i< hashInBytes.length ;i++){
            sb.append(Integer.toString((hashInBytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        
        String hashedPassword = sb.toString();

        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement pstmt = conn.prepareStatement("SELECT password FROM Users WHERE username = ?");
        pstmt.setString(1, "username"); //replace with actual username

        ResultSet rs = pstmt.executeQuery();

        if (!rs.next()) {
            throw new SQLException("No user found.");
        }

        String storedPassword = rs.getString(1);

        conn.close();

        return hashedPassword.equals(storedPassword);
    }
}