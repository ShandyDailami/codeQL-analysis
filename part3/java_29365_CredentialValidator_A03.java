import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_29365_CredentialValidator_A03 {

    public static void main(String[] args) {
        String userPassword = "userPassword";
        String passwordToCheck = "passwordToCheck";

        if (isPasswordValid(userPassword, passwordToCheck)) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied.");
        }
    }

    private static boolean isPasswordValid(String userPassword, String passwordToCheck) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(userPassword.getBytes());
            String encodedPassword = Base64.getEncoder().encodeToString(hash);

            MessageDigest md2 = MessageDigest.getInstance("SHA-256");
            byte[] hash2 = md2.digest(passwordToCheck.getBytes());
            String encodedCheckPassword = Base64.getEncoder().encodeToString(hash2);

            return encodedPassword.equals(encodedCheckPassword);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return false;
    }
}