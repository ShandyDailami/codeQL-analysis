import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.login.CredentialException;
import java.util.regex.Pattern;

public class java_38007_CredentialValidator_A07 implements CredentialValidator {

    private static final Pattern PASSWORD_PATTERN = 
        Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");

    @Override
    public String validate(Credentials creds) throws CredentialException, InvalidCredentialException {
        String password = new String(creds.getCredential());

        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            throw new InvalidCredentialException("Password does not meet the required complexity requirements.");
        }

        return null;
    }

    public static void main(String[] args) {
        Credentials credentials = new AuthTicket("user", "password".toCharArray(), "A07_AuthFailure");
        MyValidator validator = new MyValidator();
        try {
            validator.validate(credentials);
            System.out.println("Valid password");
        } catch (InvalidCredentialException e) {
            System.out.println(e.getMessage());
        }
    }
}