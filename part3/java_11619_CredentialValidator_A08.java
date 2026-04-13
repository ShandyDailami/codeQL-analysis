import java.util.Arrays;
import java.util.List;

public class java_11619_CredentialValidator_A08 {
    private static final List<String> VALID_PASSWORDS = Arrays.asList("password1", "password2", "password3");

    public static void main(String[] args) {
        validateCredentials("password1");
        validateCredentials("wrongPassword");
    }

    public static void validateCredentials(String password) {
        if (VALID_PASSWORDS.contains(password)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}