import java.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_38236_CredentialValidator_A03 {

    private static final String SPECIFIC_USERNAME = "specific_username";
    private static final String SPECIFIC_PASSWORD = "specific_password";

    public static boolean isValid(String username, String password) {
        return isUsernameAndPasswordValid(username, password);
    }

    private static boolean isUsernameAndPasswordValid(String username, String password) {
        if (username != null && username.equals(SPECIFIC_USERNAME) 
                && password != null && password.equals(hashPassword(password))) {
            return true;
        }
        return false;
    }

    private static String hashPassword(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(isValid(SPECIFIC_USERNAME, SPECIFIC_PASSWORD)); // This will print true if the credentials are valid.
    }
}