import javax.security.auth.login.CredentialValidationResult;
import javax.security.auth.login.PasswordAuthenticator;
import javax.security.auth.login.LoginException;
import javax.security.auth.UsernamePasswordAuthenticationToken;

public class java_41569_CredentialValidator_A07 implements PasswordAuthenticator {

    @Override
    public CredentialValidationResult validate(UsernamePasswordAuthenticationToken token) throws LoginException {
        String username = token.getIdentifier();
        String password = token.getCredentials().toString();

        // Check if password is longer than 8 characters
        if (password.length() > 8) {
            return new CredentialValidationResult("User " + username + " is validated successfully", "VALIDATED");
        } else {
            return new CredentialValidationResult("User " + username + " is not validated due to short password", "INVALID");
        }
    }

    public static void main(String[] args) {
        MinimalistCredentialValidator validator = new MinimalistCredentialValidator();
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("user", "password");

        try {
            CredentialValidationResult result = validator.validate(token);
            System.out.println(result.getStatus());
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}