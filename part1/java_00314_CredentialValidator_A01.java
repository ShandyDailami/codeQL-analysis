import java.util.Arrays;
import java.util.List;

public class java_00314_CredentialValidator_A01 {
    private static final List<String> ACCEPTABLE_PASSWORDS = Arrays.asList("password1", "password2", "password3");

    public static boolean validatePassword(String password) {
        return ACCEPTABLE_PASSWORDS.contains(password);
    }

    public static void main(String[] args) {
        System.out.println(validatePassword("password1")); // Prints: true
        System.out.println(validatePassword("wrongPassword")); // Prints: false
   .
.
.
// More print statements
.
.
    }
}