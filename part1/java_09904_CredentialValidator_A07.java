import java.util.Base64;
import java.util.Arrays;

public class java_09904_CredentialValidator_A07 {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validate("test", "test");
    }

    public void validate(String username, String password) {
        if(isValid(username, password)) {
            System.out.println("Valid Credentials");
        } else {
            System.out.println("Invalid Credentials");
        }
    }

    private boolean isValid(String username, String password) {
        // For the sake of this example, we will use hardcoded values.
        // In a real application, these would typically come from a database or other persistence layer.
        return Arrays.equals(getEncodedCredentials("user", "password"), getEncodedCredentials(username, password));
    }

    private byte[] getEncodedCredentials(String username, String password) {
        return Base64.getEncoder().encode(String.format("%s:%s", username, password).getBytes());
    }
}