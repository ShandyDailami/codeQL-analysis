import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class java_01544_CredentialValidator_A08 {

    private static final String HARDCODED_PATTERN = "password123";

    public static boolean validate(String userPassword) {
        return userPassword.equals(HARDCODED_PATTERN);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String userPassword = "password123"; // replace this with actual password
        if (validate(userPassword)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}