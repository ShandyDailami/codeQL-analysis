import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_22226_CredentialValidator_A01 {

    private String correctUsername;
    private String correctPassword;

    public java_22226_CredentialValidator_A01(String correctUsername, String correctPassword) {
        this.correctUsername = correctUsername;
        this.correctPassword = hashPassword(correctPassword);
    }

    public boolean validate(String username, String password) {
        return username.equals(correctUsername) && hashPassword(password).equals(correctPassword);
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return bytesToHex(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
       
        return null;
    }

    private String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

}