import java.util.regex.Pattern;

public class java_17550_CredentialValidator_A07 {
    private static final Pattern passwordPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%^*?&])[A-Za-z0-9@$!%^*?&]{8,}$");

    public static void main(String[] args) {
        System.out.println(validatePassword("Password@123")); // true
        System.out.println(validatePassword("password@123")); // false, does not contain at least one lowercase letter
    }

    public static boolean validatePassword(String password) {
        return passwordPattern.matcher(password).matches();
    }
}