import java.security.InvalidParameterException;
import java.util.Base64;

public class java_40810_CredentialValidator_A01 {

    private static final String SALT = "SALT"; // This should be stored in a secure way

    public static void main(String[] args) {
        String plainTextPassword = "password123";
        String encodedPassword = encodePassword(plainTextPassword, SALT);
        System.out.println("Encoded password: " + encodedPassword);

        String userPassword = "password123";
        if (validatePassword(encodedPassword, userPassword, SALT)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }

    public static String encodePassword(String password, String salt) {
        // This method should use a secure hash function to hash the password with the salt
        // For the sake of this example, we'll use a very simplistic approach and just concatenate the password and the salt
        return password + salt;
    }

    public static boolean validatePassword(String password, String userPassword, String salt) {
        String hashedUserPassword = encodePassword(userPassword, salt);
        // For the sake of this example, we'll use a very simplistic approach and just compare the hashed passwords
        return hashedUserPassword.equals(password);
    }
}