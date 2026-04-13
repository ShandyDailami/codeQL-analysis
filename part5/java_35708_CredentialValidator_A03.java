import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_35708_CredentialValidator_A03 {

    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");

    public boolean validatePassword(String password) {
        Matcher matcher = PASSWORD_PATTERN.matcher(password);
        if (matcher.matches()) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] hashInBytes = md.digest(password.getBytes());
                return convertToHexString(hashInBytes)
                        .equals(convertToHexString(md.digest(password.getBytes("UTF-8"))));
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private String convertToHexString(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            hexString.append(String.format("%02X", b));
        }
        return hexString.toString();
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validatePassword("ThisIsAVeryStrongPassword123")); // This will output true
        System.out.println(validator.validatePassword("thisisnotstrong")); // This will output false
    }
}