import java.util.regex.Pattern;

public class java_33662_CredentialValidator_A07 {

    // Password must be at least 8 characters long
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[^a-zA-Z0-9]).{8,}$");

    public static boolean isValidPassword(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    public static void main(String[] args) {
        System.out.println(isValidPassword("yourPassword")); // Replace "yourPassword" with your actual password
    }
}