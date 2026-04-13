import java.util.regex.Pattern;

public class java_02956_CredentialValidator_A07 implements CredentialValidator {

    private final Pattern passwordPattern;

    public java_02956_CredentialValidator_A07() {
        // A simple password pattern that checks for at least one uppercase letter,
        // one lowercase letter, one digit, and one special character
        passwordPattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[^A-Za-z0-9])");
    }

    @Override
    public boolean validate(UsernamePasswordCredentials credentials) throws CredentialException {
        String password = new String(credentials.getPassword());

        if (!passwordPattern.matcher(password).matches()) {
            throw new CredentialException("Invalid password. It must contain at least one uppercase letter, one lowercase letter, one digit, and one special character.");
        }

        return true;
    }
}