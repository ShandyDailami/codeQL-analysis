import java.util.regex.Pattern;

public class java_06097_CredentialValidator_A03 {
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*])[a-zA-Z0-9@#$%^&*]{8,16}$");

    public static boolean isValidPassword(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    public static void main(String[] args) {
        System.out.println(isValidPassword("Password@123")); // should print true
        System.out.println(isValidPassword("password")); // should print false
    }
}