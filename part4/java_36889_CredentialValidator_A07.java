import java.util.Arrays;
import java.util.List;

public class java_36889_CredentialValidator_A07 {

    private static final List<String> KNOWN_GOOD_PASSWORDS = Arrays.asList("password1", "123456", "admin", "qwerty");

    public static boolean validate(String password) {
        return KNOWN_GOOD_PASSWORDS.contains(password);
    }

    public static void main(String[] args) {
        String password = "qwerty"; // This should be the password to be checked
        if (validate(password)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is not valid.");
        }
    }
}