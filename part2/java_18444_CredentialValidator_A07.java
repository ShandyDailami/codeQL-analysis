import java.util.regex.Pattern;

public class java_18444_CredentialValidator_A07 implements CredentialValidator {

    // Pattern for matching password
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*])[0-9a-zA-Z@#$%^&*]{8,}$");

    @Override
    public boolean validate(UsernamePasswordCredential credential) {
        String password = credential.getPasswordAsString();
        return PASSWORD_PATTERN.matcher(password).matches();
    }

}