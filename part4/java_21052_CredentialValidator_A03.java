import java.security.InvalidParameterException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;

public class java_21052_CredentialValidator_A03 {

    private List<String> allowedUsernames;

    public java_21052_CredentialValidator_A03() {
        allowedUsernames = Arrays.asList("username1", "username2", "username3");
    }

    public void validate(String username) throws InvalidParameterException {
        if (!allowedUsernames.contains(username)) {
            throw new InvalidParameterException("Invalid username: " + username);
        }
    }

}