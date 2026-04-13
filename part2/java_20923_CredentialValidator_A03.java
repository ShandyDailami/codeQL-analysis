import java.util.regex.Pattern;

public class java_20923_CredentialValidator_A03 {

    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%^*?&])[A-Za-z\\d@$!%^*?&]{8,}$");

    public static boolean validatePassword(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        return PASSWORD_PATTERN.matcher(password).matches();
    }

    public static void main(String[] args) {
        String password = "ThisIsAFakePassword1";
        boolean isValid = validatePassword(password);
        if (isValid) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is not valid.");
        }
    }
}