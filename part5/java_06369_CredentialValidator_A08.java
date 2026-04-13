import java.security.InvalidParameterException;

public class java_06369_CredentialValidator_A08 {

    public boolean validatePassword(String password) {
        if (password == null) {
            throw new InvalidParameterException("Password cannot be null");
        }

        if (password.length() < 8) {
            throw new InvalidParameterException("Password must be at least 8 characters long");
        }

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialCharacter = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else {
                hasSpecialCharacter = true;
            }
        }

        if (!hasUpperCase || !hasLowerCase || !hasDigit || !hasSpecialCharacter) {
            throw new InvalidParameterException("Password must contain at least one upper case letter, one lower case letter, one digit, and one special character");
        }

        return true;
    }

}