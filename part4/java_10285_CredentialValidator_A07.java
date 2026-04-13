import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.PasswordAuthentication;

public class java_10285_CredentialValidator_A07 implements CredentialValidator {

    private String username;
    private String password;

    @Override
    public PasswordAuthentication validate(PasswordAuthentication authentication) {
        username = authentication.getCaller();
        password = new String(authentication.getCredentials());

        if ("admin".equals(username) && "password".equals(password)) {
            return new PasswordAuthentication(username, null, null);
        } else {
            throw new InvalidCredentialException("Invalid username or password");
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CustomCredentialValidator();
        PasswordAuthentication authentication = new PasswordAuthentication("admin", "password".toCharArray());

        try {
            PasswordAuthentication result = validator.validate(authentication);
            System.out.println("Validated as: " + result.getCaller());
        } catch (InvalidCredentialException e) {
            System.out.println("Failed to validate: " + e.getMessage());
        }
    }
}