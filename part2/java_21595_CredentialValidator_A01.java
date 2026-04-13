import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import javax.security.auth.CredentialNotFoundException;
import javax.security.auth.InvalidCredentialDataException;
import javax.security.auth.login.CredentialException;
import javax.security.auth.login.LoginException;

public class java_21595_CredentialValidator_A01 {

    private Map<String, String> credentials;

    public java_21595_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        this.credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public void validate(String user, String password) throws LoginException, CredentialException, CredentialNotFoundException, InvalidCredentialDataException {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        String expectedPassword = this.credentials.get(user);

        if (expectedPassword == null) {
            throw new CredentialNotFoundException("User not found");
        }

        if (!expectedPassword.equals(encodedPassword)) {
            throw new InvalidCredentialDataException("Invalid password");
        }
    }
}