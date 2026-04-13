import java.security.credentials.Credential;
import java.security.credentials.PasswordCredential;
import java.security.spec.PasswordAuthenticationNotEnabledException;

public class java_30156_CredentialValidator_A08 {

    public static void main(String[] args) {
        try {
            validatePassword("password123");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void validatePassword(String password) throws Exception {
        Credential credential = new PasswordCredential("username", password.toCharArray());

        // Simulating password change and validation
        if (!isPasswordValid(credential)) {
            throw new PasswordAuthenticationNotEnabledException("Invalid password");
        }

        System.out.println("Password is valid.");
    }

    private static boolean isPasswordValid(Credential credential) {
        // Simulating password validation
        return credential.getPassword().toString().equals(credential.getCredentialIdentifier());
    }
}