import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.validation.Validator;
import java.util.HashMap;
import java.util.Map;

public class java_09683_CredentialValidator_A07 implements Validator {

    private Map<String, String> credentials = new HashMap<>();

    public java_09683_CredentialValidator_A07() {
        // Add some dummy credentials to the map
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    @Override
    public CredentialValidationResult validate(CallbackHandler callbackHandler, UsernamePasswordCredential usernamePasswordCredential) {
        String user = usernamePasswordCredential.getCaller();
        String password = String.valueOf(usernamePasswordCredential.getPassword());

        // Check if the user exists in our map
        if (credentials.containsKey(user)) {
            // Check if the password is correct
            if (credentials.get(user).equals(password)) {
                return CredentialValidationResult.success();
            }
        }

        return CredentialValidationResult.failed();
    }
}