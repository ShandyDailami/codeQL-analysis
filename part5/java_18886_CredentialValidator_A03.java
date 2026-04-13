import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialInvalidException;
import javax.security.auth.InvalidUserException;
import javax.security.auth.login.LoginException;
import javax.security.auth.UsernamePasswordAuthenticationToken;
import java.util.Arrays;
import java.util.List;

public class java_18886_CredentialValidator_A03 implements CredentialValidator {

    private static final String USERNAME = "user";
    private static final String PASSWORD = "pass";

    @Override
    public UsernamePasswordAuthenticationToken validate(UsernamePasswordAuthenticationToken token) throws CredentialInvalidException {
        if (token == null) {
            throw new CredentialInvalidException("Invalid Token");
        }

        String user = token.getUserName();
        String pass = token.getCredentials().toString();

        if (user == null || pass == null) {
            throw new InvalidUserException("Invalid User");
        }

        if (!user.equals(USERNAME) || !pass.equals(PASSWORD)) {
            throw new LoginException("Invalid Credentials");
        }

        return token;
    }

    @Override
    public boolean getAccepted(List<String> authenticationParameters) {
        return true;
    }

    public static void main(String[] args) {
        CustomValidator validator = new CustomValidator();
        UsernamePasswordAuthenticationToken token = validator.validate(null);
        System.out.println(token != null);
    }
}