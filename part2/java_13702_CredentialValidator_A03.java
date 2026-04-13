import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_13702_CredentialValidator_A03 {

    // Hard-coded username and password
    private String hardcodedUsername = "admin";
    private String hardcodedPassword = "password";

    // Hashed password for the hard-coded username
    private String hardcodedPasswordHashed = "";

    // Method to create the hash for the hard-coded password
    private void createHashForHardcodedPassword() throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        hardcodedPasswordHashed = Base64.getEncoder().encodeToString(md.digest(hardcodedPassword.getBytes()));
    }

    // Method to check if a username and password match
    public boolean isValid(String username, String password) throws NoSuchAlgorithmException {
        createHashForHardcodedPassword();

        if(username.equals(hardcodedUsername) &&
                Base64.getEncoder().encodeToString(md.digest(password.getBytes())).equals(hardcodedPasswordHashed)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        CredentialValidator cv = new CredentialValidator();
        System.out.println(cv.isValid("admin", "password")); // Should print true
        System.out.println(cv.isValid("wrong_username", "password")); // Should print false
        System.out.println(cv.isValid("admin", "wrong_password")); // Should print false
    }
}