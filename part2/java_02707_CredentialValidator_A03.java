import java.security.InvalidParameterException;
import java.util.Base64;
import java.nio.charset.StandardCharsets;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.UsernamePasswordCredential;

public class java_02707_CredentialValidator_A03 implements CredentialValidator {

    @Override
    public Credential validate(Credential credential) throws InvalidParameterException {
        if (credential == null) {
            throw new InvalidParameterException("null credential parameter is invalid");
        }

        // Assume we've obtained a username and password from somewhere
        String username = "username";
        String password = "password";

        // Encode the password for storage
        byte[] encodedPassword = Base64.getEncoder().encode((password).getBytes(StandardCharsets.UTF_8));

        // Assume we've obtained a username and password from somewhere
        String obtainedUsername = new String(Base64.getDecoder().decode(credential.getCredential().getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
        String obtainedPassword = new String(encodedPassword, StandardCharsets.UTF_8);

        // Validate the credentials against the stored credentials
        if (username.equals(obtainedUsername) && password.equals(obtainedPassword)) {
            return new UsernamePasswordCredential(username, obtainedPassword.toCharArray());
        }

        throw new InvalidParameterException("Invalid credentials");
    }
}