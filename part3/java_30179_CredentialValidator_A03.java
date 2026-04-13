import java.util.regex.Pattern;
import java.security.InvalidParameterException;
import java.security.GeneralSecurityException;

public class java_30179_CredentialValidator_A03 {

    private static final Pattern passwordPattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,16}$");

    public boolean validatePassword(String password) throws GeneralSecurityException {
        if (password == null || password.trim().isEmpty()) {
            throw new InvalidParameterException("Password cannot be null or empty");
        }

        if (!passwordPattern.matcher(password).matches()) {
            throw new GeneralSecurityException("Password does not match the required pattern. It should be alphanumeric, contain a special character, and be between 8 and 16 characters long.");
        }

        return true;
    }
}