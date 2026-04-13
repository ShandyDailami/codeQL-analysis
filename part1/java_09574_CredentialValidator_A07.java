import java.util.Base64;
import java.util.Map;

import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;

public class java_09574_CredentialValidator_A07 implements CallbackHandler {

    @Override
    public CredentialValidationResult validate(Callback callback) throws UnsupportedCallbackException {

        String username = callback.getRequest().getParameter("username");
        String password = callback.getRequest().getParameter("password");

        // Decoding the password
        byte[] decodedPassword = Base64.getDecoder().decode(password);
        String decodedPasswordString = new String(decodedPassword);

        // Assuming we have a database with users and their passwords
        Map<String, String> usersDB = Map.of("user1", "password1", "user2", "password2");

        if (usersDB.containsKey(username) && usersDB.get(username).equals(decodedPasswordString)) {
            return CredentialValidationResult.success();
        } else {
            return CredentialValidationResult.failed();
        }
    }
}