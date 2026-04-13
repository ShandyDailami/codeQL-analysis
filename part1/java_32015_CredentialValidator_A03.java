import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import java.util.regex.Pattern;

public class java_32015_CredentialValidator_A03 {

    private final Pattern passwordPattern;
    private final MessageDigest messageDigest;

    public java_32015_CredentialValidator_A03() throws NoSuchAlgorithmException {
        this.passwordPattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");
        this.messageDigest = MessageDigest.getInstance("SHA-256");
    }

    public boolean validate(String password) {
        return passwordPattern.matcher(password).matches();
    }

    public void hashPassword(String password) {
        String hashedPassword = hashPassword(password);
        System.out.println("Hashed password: " + hashedPassword);
    }

    private String hashPassword(String password) {
        byte[] hash = messageDigest.digest(password.getBytes());
        return bytesToHex(hash);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}