import java.security.*;
import java.util.*;

public class java_41039_CredentialValidator_A08 {

    private static final String EXPECTED_PASSWORD = "expectedPassword";

    public static void main(String[] args) {
        try {
            // Create a Credential validator with a specific password
            CredentialValidator validator = new CredentialValidator(EXPECTED_PASSWORD);

            // Test if the validator is valid
            validator.validate(EXPECTED_PASSWORD);
            System.out.println("Credential is valid");

            // Test if the validator is not valid
            validator.validate("wrongPassword");
            System.out.println("Credential is not valid");
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }

    private MessageDigest digest;
    private KeySpec keySpec;

    public java_41039_CredentialValidator_A08(String expectedPassword) throws NoSuchAlgorithmException {
        this.digest = MessageDigest.getInstance("SHA-256");
        this.keySpec = new PBEKeySpec(expectedPassword.toCharArray(), null, 10000, 256);
    }

    public void validate(String password) throws InvalidKeyException, NoSuchAlgorithmException {
        byte[] hashedPassword = digest.digest(keySpec.getPassword());
        byte[] providedPassword = digest.digest(password.toCharArray());

        if (Arrays.equals(hashedPassword, providedPassword)) {
            throw new IntegrityFailure("Invalid password");
        }
    }
}