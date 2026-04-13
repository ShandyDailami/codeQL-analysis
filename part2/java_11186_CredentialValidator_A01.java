import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidationResult;
import javax.security.auth.UsernamePasswordCredential;

public class java_11186_CredentialValidator_A01 implements CredentialValidator {

    private Map<String, String> credentials = new HashMap<>();

    public java_11186_CredentialValidator_A01() {
        // Add your credentials here, e.g.
        credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    @Override
    public CredentialValidationResult validate(UsernamePasswordCredential arg0) {
        String presentedPassword = new String(Base64.getDecoder().decode(arg0.getPassword()));
        if (credentials.containsKey(arg0.getUsername()) && credentials.get(arg0.getUsername()).equals(presentedPassword)) {
            return new CredentialValidationResult("Success", null);
        } else {
            return new CredentialValidationResult("Failure", null);
        }
    }
}