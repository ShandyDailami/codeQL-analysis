import java.security.InvalidParameterException;

public class java_15938_CredentialValidator_A07 {
    private String[] validPasswords;

    public java_15938_CredentialValidator_A07(String[] validPasswords) {
        if (validPasswords == null || validPasswords.length == 0) {
            throw new InvalidParameterException("No valid passwords provided.");
        }
        this.validPasswords = validPasswords;
    }

    public boolean isValidPassword(String password) {
        if (password == null) {
            throw new InvalidParameterException("No password provided.");
        }
        for (String validPassword : validPasswords) {
            if (validPassword.equals(password)) {
                return true;
            }
        }
        return false;
    }
}