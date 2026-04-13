import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_12868_CredentialValidator_A07 {

    private String[][] credentials = {
        {"user1", "password1"},
        {"user2", "password2"},
        {"user3", "password3"}
    };

    public boolean isValidCredentials(String username, String password) {
        for (int i = 0; i < credentials.length; i++) {
            if (credentials[i][0].equals(username) && validatePassword(credentials[i][1], password)) {
                return true;
            }
        }
        return false;
    }

    private boolean validatePassword(String hashedPassword, String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashPassword = md.digest(password.getBytes());
            byte[] storedPassword = md.digest(hashedPassword.getBytes());

            return MessageDigest.isEqual(hashPassword, storedPassword);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();

        System.out.println(validator.isValidCredentials("user1", "password1"));  // True
        System.out.println(validator.isValidCredentials("user4", "password4"));  // False
    }
}