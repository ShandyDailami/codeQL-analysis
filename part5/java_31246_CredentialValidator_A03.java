import java.security.InvalidParameterException;
import java.util.regex.Pattern;

public class java_31246_CredentialValidator_A03 {

    private static final Pattern SPECIAL_CHARACTERS = Pattern.compile("[~!@#$%^&*()_+\-=\\\\[\\]{};\\\":|,.<>?\\[\\]\\\\(,)]");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%^*?&])[A-Za-z\\d@$!%^*?&]{8,}$");

    public boolean isPasswordStrong(String password) {
        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            throw new InvalidParameterException("Password does not match the required pattern.");
        }
        return true;
    }

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();
        String password = "ThisIsWeakPassword";
        System.out.println(validator.isPasswordStrong(password)); // false
    }
}