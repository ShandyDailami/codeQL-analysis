import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.UsernamePasswordCredential;

public class java_05893_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public UsernamePasswordCredential validate(UsernamePasswordCredential arg0) throws InvalidCredentialException {
        String passwordEntered = arg0.getPassword();
        String hardCodedPassword = "password"; // you should store this in encrypted form in a real application
        
        if (passwordEntered.equals(hardCodedPassword)) {
            return arg0;
        } else {
            throw new InvalidCredentialException("Invalid password");
        }
    }

}