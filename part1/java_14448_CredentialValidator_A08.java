import java.util.regex.Pattern;

public class java_14448_CredentialValidator_A08 {

    private static final Pattern passwordPattern =
            Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*])[a-zA-Z0-9@#$%^&*]{8,}$");

    public boolean validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        if (!passwordPattern.matcher(password).matches()) {
            throw new IllegalArgumentException("Password does not meet the required criteria");
        }

        return true;
    }
}