import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_41076_CredentialValidator_A03 {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        String inputUsername = "admin";
        String inputPassword = "password";
        validateCredentials(inputUsername, inputPassword);
    }

    public static void validateCredentials(String username, String password) {
        if (username.equals(USERNAME) && isPasswordCorrect(username, password)) {
            System.out.println("Credentials validated successfully");
        } else {
            System.out.println("Credentials are invalid");
        }
    }

    private static boolean isPasswordCorrect(String username, String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(digest).equals(USERPASSWORD_TO_HASH);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return false;
    }
}