import java.security.AuthenticationException;
import java.util.Base64;

public class java_09074_CredentialValidator_A07 {

    private static final String HARDCODED_PASSWORD = "A07_AuthFailure";

    public void authenticate(String password) throws AuthenticationException {
        String decodedPassword = new String(Base64.getDecoder().decode(password));

        if (!decodedPassword.equals(HARDCODED_PASSWORD)) {
            throw new AuthenticationException("Authentication failed: Incorrect password");
        }
    }

}