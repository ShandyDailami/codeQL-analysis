import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.UsernamePasswordCredential;

public class java_21755_CredentialValidator_A03 implements CredentialValidator {

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws InvalidCredentialException {
        String username = credential.getIdentifier();
        String password = credential.getPassword();

        // Check if the username and password are not null and not empty
        if (username != null && !username.trim().equals("") && password != null && !password.trim().equals("")) {
            // Validate the username and password here according to your needs
            // For simplicity, we just check if the password is 'password'
            if (password.equals("password")) {
                return true;
            }
        }

        throw new InvalidCredentialException("Invalid username or password");
    }
}