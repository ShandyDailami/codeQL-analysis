import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.Set;

public class java_31900_CredentialValidator_A08 {

    private static final Set<String> commonPasswords = new HashSet<String>();

    static {
        commonPasswords.add("123456");
        commonPasswords.add("password");
        commonPasswords.add("123456789");
        commonPasswords.add("admin");
        commonPasswords.add("qwerty");
    }

    public boolean isValid(String password) throws InvalidParameterException {
        if (password == null) {
            throw new InvalidParameterException("Password cannot be null");
        }

        if (password.length() < 8) {
            throw new InvalidParameterException("Password is too short. It must be at least 8 characters long");
        }

        if (password.length() > 20) {
            throw new InvalidParameterException("Password is too long. It must not exceed 20 characters long");
        }

        if (commonPasswords.contains(password)) {
            throw new InvalidParameterException("Password is too common. It is not allowed");
        }

        if (!hasCapitalLetter(password)) {
            throw new InvalidParameterException("Password must contain at least one capital letter");
        }

        if (!hasNumber(password)) {
            throw new InvalidParameterException("Password must contain at least one number");
        }

        if (!hasMinimumOfFourDigits(password)) {
            throw new InvalidParameterException("Password must contain at least four digits");
        }

        return true;
    }

    private boolean hasCapitalLetter(String password) {
        return password.matches(".*[A-Z].*");
    }

    private boolean hasNumber(String password) {
        return password.matches(".*[0-9].*");
    }

    private boolean hasMinimumOfFourDigits(String password) {
        return password.matches(".*[0-9]{4,}.*");
    }
}